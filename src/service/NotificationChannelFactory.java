package service;

import channel.EmailChannel;
import channel.NotificationChannel;
import channel.SmsChannel;
import enums.NotificationType;

public class NotificationChannelFactory {

    public static NotificationChannel createChannel(NotificationType type) {
        switch (type) {
            case EMAIL:
                return new EmailChannel();
            case SMS:
                return new SmsChannel();
            default:
                throw new IllegalArgumentException("Unsupported Notification Type: " + type);
        }
    }
}
