package core;

import model.Message;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Topic {

    private final String topicName;
    private final List<Subscriber> subscribers;

    public Topic(String topicName) {
        this.topicName = topicName;
        this.subscribers = new CopyOnWriteArrayList<>();
    }

    public String getTopicName() {
        return topicName;
    }

    public synchronized void subscribe(Subscriber subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
            System.out.println(" [Topic: " + topicName + "Subscribed" + subscriber);
        } else {
            System.out.println("Already subscribed");
        }
    }

    public synchronized void unsubscribe(Subscriber subscriber) {
        if (subscribers.contains(subscriber)) {
            subscribers.remove(subscriber);
            System.out.println("Unsubscribed");
        } else {
            System.out.println("Not subscribed");
        }
    }

    public void notifySubscriber(Message message) {
        for (Subscriber subscriber : subscribers) {
            try {
                subscriber.onMessage(message);
            } catch (Exception e) {
                //add dead latter queue or Retry
                System.err.println("Error in Notifying the Subscriber" + e.getMessage());
            }
        }
    }

    public int subscribersCount() {
        return subscribers.size();
    }
}
