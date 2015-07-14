package com.qa_wall_logger_client.log;

import com.qa_wall_logger_client.log.log.Log;


public final class RemoteLogger
{
    private Listener listener;

    public RemoteLogger(Listener listener)
    {
        this.listener = listener;
    }

    public void send(Log log)
    {
        String url = listener.onGetServerUrl();

        for (String path : log.getUrlPaths())
        {
            url += "/" + path;
        }

        String parsedLog = listener.onParseToJson(log);

        listener.onSentToNetwork(url, parsedLog);
    }

    public interface Listener
    {
        String onGetServerUrl();

        String onParseToJson(Log log);

        void onSentToNetwork(String serviceUrl, String parsedObject);
    }
}
