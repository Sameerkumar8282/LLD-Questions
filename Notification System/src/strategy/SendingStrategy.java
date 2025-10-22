package strategy;

import model.Notification;
import model.User;

public interface SendingStrategy {
    void send(NotificationChannelStrategy channelStrategy, User user, Notification notification);
}
