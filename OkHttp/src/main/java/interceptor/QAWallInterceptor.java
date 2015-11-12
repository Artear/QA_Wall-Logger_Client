package interceptor;

import com.google.gson.Gson;
import com.qa_wall_logger_client.RemoteLogger;
import com.qa_wall_logger_client.log.Log;
import com.squareup.okhttp.*;

import java.io.IOException;

public class QAWallInterceptor implements Interceptor
{
    private static final String START_END_EVENT = "START_END";
    private static final String URL_REMOTE = "";

    public static final MediaType JSON  = MediaType.parse("application/json; charset=utf-8");

    private final RemoteLogger remoteLogger;

    public QAWallInterceptor()
    {
        remoteLogger = new RemoteLogger();
        remoteLogger.setUrlRemote(URL_REMOTE);
        remoteLogger.setRemoteListener(new RemoteLogger.Listener()
        {
            @Override
            public String onParseToJson(final Log log)
            {
                return new Gson().toJson(log);
            }

            @Override
            public void onSentToNetwork(final String parsedObject)
            {
                //Send data to server here
                OkHttpClient client = new OkHttpClient();

                RequestBody body = RequestBody.create(JSON, parsedObject);
                Request request = new Request.Builder()
                        .url(remoteLogger.getUrlRemote())
                        .post(body)
                        .build();
                try
                {
                    Response response = client.newCall(request).execute();
                } catch (IOException e)
                {

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
                        request.url(), chain.connection(), request.headers()));

        remoteLogger.send(logStart);

        Response response = chain.proceed(request);

        long t2 = System.nanoTime();

        Log logEnd = new Log(START_END_EVENT, Log.Type.PERIOD_END, t2,
                String.format("Received response for %s in %.1fms%n%s",
                        response.request().url(), (t2 - t1) / 1e6d, response.headers()));

        remoteLogger.send(logEnd);

        return response;
    }

}
