package channel;

import model.Notififcation;

public class SmsNotificationChannel implements NotificationChannel{
    @Override
    public void sendNotification(Notififcation notification) {
        System.out.println("Sending sms notification to user: " + notification.getUserId() +
                " with message: " + notification.getMessage());
    }
}
