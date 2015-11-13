package com.qa_wall_logger_client;

import com.qa_wall_logger_client.log.ILog;


public interface IRemoteLogger
{
    public void send(ILog log);

    public interface Listener
    {
        String onParseToJson(ILog log);

        void onWriteToLog(String parsedLog);
    }
}
