package com.qa_wall_logger_client.log;


/**
 *
 *
 * id      String representing the event (ie: if you are sending a START-END event, both of them will be tied by this id)
 * type    {@link Type Type} indicating the log type;
 * time    Epoch (milliseconds since 1 jan 1970) when the period start;
 * message a message to identify the com.qa_wall_logger_client.log;
 * deviceId id identifying the device;
 */
public interface ILog {
    enum Type {
        PERIOD_START, PERIOD_END, EVENT
    }

    String getId();

    Type getType();

    long getTime();

    String getMessage();

    String getDeviceId();
}
