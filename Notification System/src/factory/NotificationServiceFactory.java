package factory;

import model.ChannelType;
import strategy.NotificationChannelStrategy;
import strategy.impl.EmailNotificationStrategy;
import strategy.impl.PushNotificationStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class NotificationServiceFactory {

    private static final Map<ChannelType, Supplier<NotificationChannelStrategy>> registry = new HashMap<>();

    static {
        registry.put(ChannelType.PUSH, PushNotificationStrategy::new);
        registry.put(ChannelType.EMAIL, EmailNotificationStrategy::new);
    }


    public static NotificationChannelStrategy getChannelStrategyInstance(ChannelType channelType) {
        if (channelType == null) {
            throw new IllegalArgumentException("Channel can't be null");
        }
        Supplier<NotificationChannelStrategy> supplier = registry.get(channelType);
        if (supplier == null) {
            throw new IllegalArgumentException("No strategy registered for channel: " + channelType);
        }
        return supplier.get(); // <--- call get() on Supplier
    }

}
