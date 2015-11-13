package com.qa_wall_logger_client.log;

/**
 * Empty Implementation
 */
public class Log implements ILog
{

    public Log(final String id, final Type type, final long time, final String message, final String deviceId) {
    }

    @Override
    public String getId() {
        return "";
    }

    @Override
    public Type getType() {
        return Type.EVENT;
    }

    @Override
    public long getTime() {
        return 0;
    }

    @Override
    public String getMessage() {
        return "";
    }

    @Override
    public String getDeviceId() {
        return "";
    }
}
