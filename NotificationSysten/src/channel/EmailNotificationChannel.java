package channel;

import model.Notififcation;

public class EmailNotificationChannel implements NotificationChannel{
    @Override
    public void sendNotification(Notififcation notification) {
        System.out.println("Sending email notification to user: " + notification.getUserId() +
                " with message: " + notification.getMessage());
    }
}
