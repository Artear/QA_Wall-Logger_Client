package com.qa_wall_logger_client;

import com.qa_wall_logger_client.log.ILog;


public final class RemoteLogger implements IRemoteLogger
{
    private Listener listener;

    public RemoteLogger(Listener listener)
    {
        this.listener = listener;
    }

    @Override
    public void send(ILog log)
    {
        String parsedLog = listener.onParseToJson(log);

        listener.onWriteToLog(parsedLog);
    }
}
