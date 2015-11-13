package com.qa_wall_logger_client.log;

/**
 * Empty Implementation
 */
public class Log implements ILog
{

    public Log(final String id, final Type type, long time, String message) {
    }

    public String getId() {
        return "";
    }

    public Type getType() {
        return Type.EVENT;
    }

    public long getTime() {
        return 0;
    }

    public String getMessage() {
        return "";
    }
}
