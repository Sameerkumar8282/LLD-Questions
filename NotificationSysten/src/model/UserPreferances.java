package model;

import java.util.Set;

public class UserPreferances {
    private String userId;
    private Set<ChannelType> channels;

    public UserPreferances(String userId, Set<ChannelType> channels) {
        this.userId = userId;
        this.channels = channels;
    }

    public Set<ChannelType> getChannels() {
        return channels;
    }

    public String getUserId() {
        return userId;
    }
}
