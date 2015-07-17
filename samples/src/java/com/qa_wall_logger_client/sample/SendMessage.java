package com.qa_wall_logger_client.sample;

import com.google.gson.Gson;
import com.qa_wall_logger_client.RemoteLogger;
import com.qa_wall_logger_client.log.Log;
import com.qa_wall_logger_client.log.MessageLog;
import com.qa_wall_logger_client.log.TimeLog;

public class SendMessage
{
    public static void main(String[] args) throws InterruptedException
    {
        //Remote Logger instantiation;

        RemoteLogger remoteLogger = new RemoteLogger(new RemoteLogger.Listener()
        {
            @Override
            public String onParseToJson(final Log log)
            {
                return new Gson().toJson(log);
            }

            @Override
            public void onSentToNetwork(final String parsedObject)
            {
                //Send data to server here
            }
        });


        // .... your code ....


        //Remote Logger usage

        //Send message
        MessageLog messageLog = new MessageLog(System.currentTimeMillis(), "Hello World!");
        remoteLogger.send(messageLog);

        //Send time
        TimeLog timeLog = new TimeLog("http://www.google.com", System.currentTimeMillis(), System.currentTimeMillis() + 5000);
        remoteLogger.send(timeLog);
    }
}
