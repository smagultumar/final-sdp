package socialfeed.observer;

import socialfeed.model.*;
public class ConsoleNotificationSender implements NotificationSender {
    public String send(String recipient, String message) {
        return "Notification to " + recipient + ": " + message;
    }
}
