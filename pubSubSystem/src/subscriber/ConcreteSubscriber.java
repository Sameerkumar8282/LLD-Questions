package subscriber;

import core.Subscriber;
import model.Message;

public class ConcreteSubscriber implements Subscriber {

    private final String name;

    public ConcreteSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("Message received by -> "+name +" Message is -> " + message);
    }

    @Override
    public String toString() {
        return "ConcreteSubscriber{" +
                "name='" + name + '\'' +
                '}';
    }
}
