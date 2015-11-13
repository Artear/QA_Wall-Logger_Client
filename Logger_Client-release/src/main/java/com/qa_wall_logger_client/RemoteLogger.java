package com.qa_wall_logger_client;

import com.qa_wall_logger_client.log.ILog;


/**
 * Empty Implementation
 */
public final class RemoteLogger implements IRemoteLogger
{
    public RemoteLogger(final Listener listener)
    {
    }

    @Override
    public void send(ILog log)
    {
    }
}
