package api;

import model.Notififcation;
import service.NotificationDispatcher;

public class NotificationService {

    private final NotificationDispatcher notificationDispatcher;

    public NotificationService(NotificationDispatcher notificationDispatcher) {
        this.notificationDispatcher = notificationDispatcher;
    }

    public void sendNotification(Notififcation notification) {
        notificationDispatcher.dispatch(notification);
    }
}
