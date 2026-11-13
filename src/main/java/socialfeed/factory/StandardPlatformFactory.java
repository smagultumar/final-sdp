package socialfeed.factory;

import socialfeed.model.*;
import socialfeed.bridge.*;
import socialfeed.observer.*;
public class StandardPlatformFactory implements SocialPlatformFactory {
    public FeedRenderer createRenderer() { return new StandardFeedRenderer(); }
    public NotificationSender createNotificationSender() { return new ConsoleNotificationSender(); }
}
