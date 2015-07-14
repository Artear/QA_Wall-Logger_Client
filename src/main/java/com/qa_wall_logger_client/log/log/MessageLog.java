package com.qa_wall_logger_client.log.log;

import java.util.ArrayList;
import java.util.List;

public class MessageLog implements Log
{
    private String logMsg;

    /**
     * @param logMsg a message to identify the com.qa_wall_logger_client.log
     */
    public MessageLog(String logMsg)
    {
        this.logMsg = logMsg;
    }

    @Override
    public List<String> getUrlPaths()
    {
        ArrayList<String> path = new ArrayList<>();
        path.add("message.php");

        return path;
    }

    public String getLogMsg()
    {
        return logMsg;
    }
}
