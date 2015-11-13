package sample;


import com.google.gson.Gson;
import com.qa_wall_logger_client.RemoteLogger;
import com.qa_wall_logger_client.log.Log;

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
            public void onWriteToLog(final String parsedLog)
            {
                //Send data to server here
            }
        });


        // .... your code ....


        //Remote Logger usage

        //Send Period
        Log periodStart = new Log("Test1", Log.Type.PERIOD_START, System.currentTimeMillis(), "Hello World!", "device1");
        remoteLogger.send(periodStart);

        Log periodEnd = new Log("Test1", Log.Type.PERIOD_END, System.currentTimeMillis()+ 5000, "Bye Bye World!", "device1");
        remoteLogger.send(periodEnd);

        //Send time
        Log timeLog = new Log("Test2", Log.Type.EVENT,  System.currentTimeMillis() ,"http://www.google.com", "device1");
        remoteLogger.send(timeLog);
    }
}
