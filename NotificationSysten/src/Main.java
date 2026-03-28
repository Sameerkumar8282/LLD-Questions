import api.AsyncNotificationService;
import api.NotificationService;
import model.ChannelType;
import model.Notififcation;
import model.UserPreferances;
import service.NotificationDispatcher;
import service.UserPreferenceService;

void main() {
    IO.println("Start Notification System");

    UserPreferenceService userPreferenceService = new UserPreferenceService();
    userPreferenceService.saveUserPreferances(
            new UserPreferances("user1", Set.of(ChannelType.EMAIL))
    );

    NotificationDispatcher dispatcher = new NotificationDispatcher(userPreferenceService);

    Notififcation notification = new Notififcation("user1", "Hello World");
    NotificationService notificationService = new NotificationService(dispatcher);

    ExecutorService executorService = Executors.newFixedThreadPool(10);
    AsyncNotificationService asyncNotificationService =
            new AsyncNotificationService(dispatcher, executorService);

    asyncNotificationService.sendNotification(notification);

    executorService.shutdown();
    //    notificationService.sendNotification(notification);

    IO.println("End Notification System");
}
