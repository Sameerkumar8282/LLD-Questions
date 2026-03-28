package model;

public class Message {
    private final String topicName;
    private final String payload;
    private final long timestamp;

    public Message(String topicName, String payload) {
        this.payload = payload;
        this.topicName = topicName;
        this.timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "Message{" +
                "topicName='" + topicName + '\'' +
                ", payload='" + payload + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
