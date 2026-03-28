package api;

import model.Notififcation;
import service.NotificationDispatcher;

import java.util.concurrent.ExecutorService;

public class AsyncNotificationService {
    private final NotificationDispatcher notificationDispatcher;
    private final ExecutorService executorService;

    public AsyncNotificationService(NotificationDispatcher notificationDispatcher,ExecutorService executorService) {
        this.notificationDispatcher = notificationDispatcher;
        this.executorService = executorService;
    }

    public void sendNotification(Notififcation notification) {
        executorService.submit(() -> notificationDispatcher.dispatch(notification));
    }

}
