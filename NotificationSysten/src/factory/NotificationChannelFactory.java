package factory;

import channel.EmailNotificationChannel;
import channel.NotificationChannel;
import channel.PushNotifcationChannel;
import channel.SmsNotificationChannel;
import model.ChannelType;

public class NotificationChannelFactory {

    public static NotificationChannel getChannel(ChannelType channelType) {
        return switch (channelType) {
            case SMS -> new SmsNotificationChannel();
            case EMAIL -> new EmailNotificationChannel();
            case PUSH -> new PushNotifcationChannel();
        };
    }
}
