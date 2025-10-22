package service;

import factory.NotificationServiceFactory;
import model.Notification;
import model.User;
import strategy.NotificationChannelStrategy;
import strategy.SendingStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotifiactionService {
    // user Subscribe to Notification
    // user Unsubscribe to Notification
    // user Get Notifications
    // set Sending Strategy instant or batch

    private final List<User>  subscriptions = Collections.synchronizedList(new ArrayList<>());
    private SendingStrategy sendingStrategy;

    public NotifiactionService(SendingStrategy sendingStrategy){
        super();
        this.sendingStrategy = sendingStrategy;
    }

    public void subscribe(User user){
        if(user == null){
            throw new IllegalArgumentException("User cannot be null");
        }
        if(!subscriptions.contains(user)){
            subscriptions.add(user);
        }
    }

    public void unsubscribe(User user){
        if (subscriptions.contains(user)){
            subscriptions.remove(user);
        }
    }

    public void setSendingStartegy(SendingStrategy strategy){
        this.sendingStrategy = strategy;
    }

    public void notifyAll(List<User> subscriptions ,Notification notification){
        for(User subscribers : subscriptions){
           NotificationChannelStrategy ch =  NotificationServiceFactory
                                            .getChannelStrategyInstance(subscribers.getPreferedChannel());
           sendingStrategy.send(ch,subscribers,notification);
        }
    }
}
