package core;

import model.Message;

public interface Subscriber {
    void onMessage(Message message);
}
