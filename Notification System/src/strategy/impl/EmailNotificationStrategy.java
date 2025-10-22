package strategy.impl;

import model.Notification;
import model.User;
import strategy.NotificationChannelStrategy;

public class EmailNotificationStrategy implements NotificationChannelStrategy {
    @Override
    public void sendNotification(User user, Notification notification) {
        System.out.println("Sending email to " + user.getName() +
                " with notification " + notification.getTitle() +
                " " + notification.getDescription() +
                " via Email");
    }
}