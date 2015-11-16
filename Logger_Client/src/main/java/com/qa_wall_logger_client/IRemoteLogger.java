package com.qa_wall_logger_client;

import com.qa_wall_logger_client.log.ILog;


public interface IRemoteLogger
{
    void send(ILog log);

    interface Listener
    {
        String onParseToJson(ILog log);

        void onWriteToLog(String parsedLog);
    }
}
