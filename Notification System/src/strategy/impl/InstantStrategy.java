package strategy.impl;

import model.Notification;
import model.User;
import strategy.NotificationChannelStrategy;
import strategy.SendingStrategy;

public class InstantStrategy implements SendingStrategy {
    @Override
    public void send(NotificationChannelStrategy channelStrategy, User user, Notification notification) {
        channelStrategy.sendNotification(user, notification);
    }
}
