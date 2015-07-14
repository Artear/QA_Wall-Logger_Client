package com.qa_wall_logger_client.log.log;

import com.qa_wall_logger_client.log.log.Log;

import java.util.ArrayList;
import java.util.List;

public class TimeLog implements Log
{
    private String logMsg;
    private long timeStart;
    private long timeEnd;

    /**
     * @param logMsg    a message to identify the com.qa_wall_logger_client.log
     * @param timeStart the time in milliseconds since January 1, 1970 00:00:00.0 UTC when the event started
     * @param timeEnd   the time in milliseconds since January 1, 1970 00:00:00.0 UTC when the event ended
     */
    public TimeLog(String logMsg, final long timeStart, final long timeEnd)
    {
        this.logMsg = logMsg;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    @Override
    public List<String> getUrlPaths()
    {
        ArrayList<String> path = new ArrayList<>();
        path.add("time.php");

        return path;
    }

    public String getLogMsg()
    {
        return logMsg;
    }

    public long getTimeStart()
    {
        return timeStart;
    }

    public long getTimeEnd()
    {
        return timeEnd;
    }
}
