package strategy.impl;

import factory.NotificationServiceFactory;
import model.ChannelType;
import model.Notification;
import model.User;
import strategy.NotificationChannelStrategy;

public class PushNotificationStrategy implements NotificationChannelStrategy {

    @Override
    public void sendNotification(User user, Notification notification) {
        System.out.println("Sending push notification to " + user.getName() + " with notification " + notification.getTitle() + " via Push Notification");
    }
}
