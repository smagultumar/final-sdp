package socialfeed.observer;

import socialfeed.model.*;
public class EmailNotificationSender implements NotificationSender {
    public String send(String recipient, String message) {
        return "Email to " + recipient + ": " + message;
    }
}
