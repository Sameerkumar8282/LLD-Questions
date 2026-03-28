package channel;

import model.Notififcation;

public class PushNotifcationChannel implements NotificationChannel{
    @Override
    public void sendNotification(Notififcation notification) {
        System.out.println("Sending push notification to user: " + notification.getUserId() +
                " with message: " + notification.getMessage());
    }
}
