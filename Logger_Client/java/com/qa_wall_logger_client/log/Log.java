package com.qa_wall_logger_client.log;

public class Log
{
    public enum LogType
    {
        PERIOD_START, PERIOD_END, EVENT
    }

    private final LogType type;
    private long time;
    private String message;

    /**
     * @param type    {@link LogType LogType} indicating the log type;
     * @param time    Epoch (milliseconds since 1 jan 1970) when the period start;
     * @param message a message to identify the com.qa_wall_logger_client.log;
     */
    public Log(final LogType type, long time, String message)
    {
        this.type = type;
        this.time = time;
        this.message = message;
    }

    public LogType getType()
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
