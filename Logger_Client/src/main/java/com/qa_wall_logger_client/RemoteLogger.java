package com.qa_wall_logger_client;

import com.qa_wall_logger_client.log.Log;


public final class RemoteLogger
{
    private Listener listener;

    public RemoteLogger(Listener listener)
    {
        this.listener = listener;
    }

    public void send(Log log)
    {
        String parsedLog = listener.onParseToJson(log);

        listener.onWriteToLog(parsedLog);
    }

    public interface Listener
    {
        String onParseToJson(Log log);

        void onWriteToLog(String parsedLog);
    }
}
