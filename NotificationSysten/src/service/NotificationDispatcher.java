package service;

import channel.NotificationChannel;
import factory.NotificationChannelFactory;
import model.ChannelType;
import model.Notififcation;
import model.UserPreferances;

import java.util.Set;

public class NotificationDispatcher {
    private final UserPreferenceService userPreferenceService;

    public NotificationDispatcher(UserPreferenceService userPreferenceService) {
        this.userPreferenceService = userPreferenceService;
    }

    public void dispatch(Notififcation notifification) {
        UserPreferances preferances =
                userPreferenceService.getUserPreferances(notifification.getUserId());
        Set<ChannelType> channels = preferances.getChannels();

        for (ChannelType channel : channels) {
           NotificationChannel channel1 =
                   NotificationChannelFactory.getChannel(channel);
           channel1.sendNotification(notifification);
        }
    }
}
