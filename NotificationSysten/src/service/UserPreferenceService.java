package service;

import model.ChannelType;
import model.UserPreferances;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserPreferenceService {
    private final Map<String, UserPreferances> userPreferances = new HashMap<>();

    public void saveUserPreferances(UserPreferances userPreferances) {
        this.userPreferances.put(userPreferances.getUserId(), userPreferances);
    }

    public UserPreferances getUserPreferances(String userId) {
        return userPreferances.getOrDefault(
                userId,
                new UserPreferances(userId, Set.of(ChannelType.EMAIL))
        );
    }
}
