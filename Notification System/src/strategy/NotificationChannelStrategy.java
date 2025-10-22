package strategy;

import model.Notification;
import model.User;

public interface NotificationChannelStrategy {
    public void sendNotification(User user, Notification notification);
}
