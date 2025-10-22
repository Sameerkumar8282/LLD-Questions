package model;

public class User {
    private final String name;
    private ChannelType preferedChannel;

    public User(String name,ChannelType preferedChannel) {
        this.name = name;
        this.preferedChannel = preferedChannel;
    }

    public String getName() {
        return name;
    }

    public ChannelType getPreferedChannel() {
        return preferedChannel;
    }

    public void setPreferedChannel(ChannelType preferedChannel) {
        this.preferedChannel = preferedChannel;
    }
}
