package core;

import model.Message;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageBroker {

    //Singleton(thred safe via Class Loader) only one messageBroker

    private static final MessageBroker INSTANCE = new MessageBroker();

    public static MessageBroker getInstance() {
        return INSTANCE;
    }

    private MessageBroker() {
    }

    private final Map<String, Topic> topics = new ConcurrentHashMap<>();

    public Topic createTopic(String topicName) {
        // putIfAbsent is atomic - no duplicate topic even in concurrent
        topics.putIfAbsent(topicName, new Topic(topicName));
        System.out.println("[Broker] topic created/fetched " + topicName);
        return topics.get(topicName);
    }

    public Topic getTopic(String topicName) {
        return topics.get(topicName);
    }

    //subscribe / unsubscribe
    public void susbcribe(String topicName, Subscriber subscriber) {
        Topic topic = getOrThrow(topicName);
        topic.subscribe(subscriber);
    }

    public void unsusbcribe(String topicName, Subscriber subscriber) {
        Topic topic = getOrThrow(topicName);
        topic.unsubscribe(subscriber);
    }

    //publish
    public void publish(String topicName, String payload) {
        Topic topic = getOrThrow(topicName);
        Message message = new Message(topicName, payload);
        System.out.println("[Broker] Publishing to " + topicName + " : " + payload);
        topic.notifySubscriber(message);
    }

    private Topic getOrThrow(String topicName) {
        Topic topic = topics.get(topicName);
        if (topic == null) {
            throw new IllegalArgumentException("Topic not found: " + topicName);
        }
        return topic;

    }

}
