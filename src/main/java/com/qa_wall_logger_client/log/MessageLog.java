package com.qa_wall_logger_client.log;

public class MessageLog implements Log
{
    private long time;
    private String logMsg;

    /**
     * @param time Epoch (milliseconds since 1 jan 1970) when the event happened
     * @param logMsg a message to identify the com.qa_wall_logger_client.log
     */
    public MessageLog(long time, String logMsg)
    {
        this.time = time;
        this.logMsg = logMsg;
    }

    public long getTime()
    {
        return time;
    }

    public String getLogMsg()
    {
        return logMsg;
    }
}
