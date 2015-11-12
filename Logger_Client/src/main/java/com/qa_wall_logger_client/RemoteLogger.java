package com.qa_wall_logger_client;

import com.qa_wall_logger_client.log.Log;


public final class RemoteLogger
{
    private Listener listener;
    private String urlRemote;

    public RemoteLogger(){

    }

    public void setRemoteListener(Listener listener)
    {
        this.listener = listener;
    }

    public String getUrlRemote(){
        return urlRemote;
    }

    public void setUrlRemote(String urlRemote){
        this.urlRemote = urlRemote;
    }

    public void send(Log log)
    {
        String parsedLog = listener.onParseToJson(log);

        listener.onSentToNetwork(parsedLog);
    }

    public interface Listener
    {
        String onParseToJson(Log log);

        void onSentToNetwork(String parsedObject);
    }
}
