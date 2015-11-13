package com.qa_wall_logger_client.log;

public class Log implements ILog
{
    private String id;
    private final Type type;
    private long time;
    private String message;
    private String deviceId;

    /**
     * @param id      String representing the event (ie: if you are sending a START-END event, both of them will be tied by this id)
     * @param type    {@link Type Type} indicating the log type;
     * @param time    Epoch (milliseconds since 1 jan 1970) when the period start;
     * @param message a message to identify the com.qa_wall_logger_client.log;
     */
    public Log(final String id, final Type type, long time, String message, String deviceId) {
        this.id = id;
        this.type = type;
        this.time = time;
        this.message = message;
        this.deviceId = deviceId;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public long getTime() {
        return time;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getDeviceId() {
        return deviceId;
    }
}
