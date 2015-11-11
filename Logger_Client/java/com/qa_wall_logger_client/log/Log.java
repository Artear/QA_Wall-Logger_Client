package com.qa_wall_logger_client.log;

public class Log
{
    public enum Type
    {
        PERIOD_START, PERIOD_END, EVENT
    }

    private final Type type;
    private long time;
    private String message;

    /**
     * @param type    {@link Type Type} indicating the log type;
     * @param time    Epoch (milliseconds since 1 jan 1970) when the period start;
     * @param message a message to identify the com.qa_wall_logger_client.log;
     */
    public Log(final Type type, long time, String message)
    {
        this.type = type;
        this.time = time;
        this.message = message;
    }

    public Type getType()
    {
        return type;
    }

    public long getTime()
    {
        return time;
    }

    public String getMessage()
    {
        return message;
    }
}
