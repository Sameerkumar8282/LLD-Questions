package demo;

import core.MessageBroker;
import core.Subscriber;
import publisher.Publisher;
import subscriber.ConcreteSubscriber;

public class Demo {
    static void main() {
        MessageBroker broker =  MessageBroker.getInstance();

        //create Topic
        broker.createTopic("sports");
        broker.createTopic("tech");

        //create subcriber

        Subscriber alice = new ConcreteSubscriber("alice");
        Subscriber bob = new ConcreteSubscriber("bob");
        Subscriber charlie = new ConcreteSubscriber("charlie");

        //Subscribe
        broker.susbcribe("sports",alice);
        broker.susbcribe("tech",bob);
        broker.susbcribe("sports",charlie);
        broker.susbcribe("tech",charlie);

        //publish
        Publisher espn = new Publisher("ESPN");
        Publisher cnn = new Publisher("CNN");

        espn.publish("sports" , "Messi score a goall !!!!");

        cnn.publish("tech", "NVIDIA launches GTX 7080 ");

        System.out.println("\nCharlie unsbscribing from sports");
        broker.unsusbcribe("sports",charlie);

        espn.publish("sports" , "Ronaldo retiers");
        System.out.println("\nendddddddd");
    }
}
