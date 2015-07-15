package com.qa_wall_logger_client.sample;

import com.google.gson.Gson;
import com.qa_wall_logger_client.RemoteLogger;
import com.qa_wall_logger_client.log.Log;
import com.qa_wall_logger_client.log.MessageLog;
import com.qa_wall_logger_client.log.TimeLog;
import com.squareup.okhttp.*;

import java.io.IOException;

public class SendMessage
{
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    public static void main(String[] args) throws InterruptedException
    {
        //Remote Logger instantiation;

        final OkHttpClient okHttpClient = new OkHttpClient();

        RemoteLogger remoteLogger = new RemoteLogger(new RemoteLogger.Listener()
        {
            @Override
            public String onGetServerUrl()
            {
                return "http://localhost/QA_Wall-Logger_Server";
            }

            @Override
            public String onParseToJson(final Log log)
            {
                return new Gson().toJson(log);
            }

            @Override
            public void onSentToNetwork(final String serviceUrl, final String parsedObject)
            {
                RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, parsedObject);
                Request request = new Request.Builder().cacheControl(CacheControl.FORCE_NETWORK).url(serviceUrl).post(body).build();

                okHttpClient.newCall(request).enqueue(new Callback()
                {
                    @Override
                    public void onFailure(final Request request, final IOException e)
                    {
                        //Something went wrong!
                    }

                    @Override
                    public void onResponse(final Response response) throws IOException
                    {
                        //All cool
                    }
                });
            }
        });


        // .... your code ....


        //Remote Logger usage

        //Send message
        MessageLog messageLog = new MessageLog("Hello World!");
        remoteLogger.send(messageLog);

        //Send time
        TimeLog timeLog = new TimeLog("http://www.google.com", System.currentTimeMillis(), System.currentTimeMillis() + 5000);
        remoteLogger.send(timeLog);
    }
}
