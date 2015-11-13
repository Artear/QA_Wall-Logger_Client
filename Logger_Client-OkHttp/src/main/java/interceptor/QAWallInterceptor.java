package interceptor;

import com.google.gson.Gson;
import com.qa_wall_logger_client.IRemoteLogger;
import com.qa_wall_logger_client.RemoteLogger;
import com.qa_wall_logger_client.log.ILog;
import com.qa_wall_logger_client.log.Log;
import com.squareup.okhttp.*;

import java.io.IOException;

public class QAWallInterceptor implements Interceptor
{
    private static final String START_END_EVENT = "START_END";

    public static final MediaType JSON  = MediaType.parse("application/json; charset=utf-8");

    private final IRemoteLogger remoteLogger;
    private final String deviceId;

    public QAWallInterceptor(final String urlRemote, final String deviceId)
    {
        this.deviceId = deviceId;
        remoteLogger = new RemoteLogger(new IRemoteLogger.Listener()
        {
            @Override
            public String onParseToJson(final ILog log)
            {
                return new Gson().toJson(log);
            }

            @Override
            public void onWriteToLog(final String parsedLog)
            {
                //Send data to server here
                OkHttpClient client = new OkHttpClient();

                RequestBody body = RequestBody.create(JSON, parsedLog);
                Request request = new Request.Builder().url(urlRemote)
                        .post(body)
                        .build();
                try
                {
                    Response response = client.newCall(request).execute();
                } catch (IOException e)
                {
                    System.out.println("Error: " + e.getMessage() + ", At Milliseconds:"
                            + System.nanoTime());
                }

            }
        });
    }

    @Override
    public Response intercept(Chain chain) throws IOException
    {
        Request request = chain.request();

        long t1 = System.nanoTime();

        Log logStart = new Log(START_END_EVENT, Log.Type.PERIOD_START, t1,
                String.format("Sending request %s on %s%n%s",
                        request.url(), chain.connection(), request.headers()), deviceId);

        remoteLogger.send(logStart);

        Response response = chain.proceed(request);

        long t2 = System.nanoTime();

        Log logEnd = new Log(START_END_EVENT, Log.Type.PERIOD_END, t2,
                String.format("Received response for %s in %.1fms%n%s",
                        response.request().url(), (t2 - t1) / 1e6d, response.headers()), deviceId);

        remoteLogger.send(logEnd);

        return response;
    }

}
