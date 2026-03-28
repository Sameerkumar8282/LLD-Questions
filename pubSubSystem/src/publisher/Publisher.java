package publisher;

import core.MessageBroker;

public class Publisher {
    private final String name;
    private final MessageBroker broker;

    public Publisher( String name) {
        this.broker = MessageBroker.getInstance();
        this.name = name;
    }

    public void publish(String topicName, String payload) {
        System.out.println("\n[Publisher: " + name + "] publishing....");
        broker.publish(topicName, payload);
    }
}
