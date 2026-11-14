package socialfeed.observer;

import socialfeed.model.*;
public interface NotificationSender {
    String send(String recipient, String message);
}
