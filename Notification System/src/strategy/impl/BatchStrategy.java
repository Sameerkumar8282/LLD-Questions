package strategy.impl;

import model.Notification;
import model.User;
import strategy.NotificationChannelStrategy;
import strategy.SendingStrategy;

import java.util.ArrayList;
import java.util.List;

public class BatchStrategy implements SendingStrategy {
    private final List<Runnable> runnables = new ArrayList<>();
    @Override
    public void send(NotificationChannelStrategy channelStrategy, User user, Notification notification) {
        runnables.add(() -> channelStrategy.sendNotification(user, notification));
    }
    public void execute() {
        runnables.forEach(Runnable::run);
    }
}
