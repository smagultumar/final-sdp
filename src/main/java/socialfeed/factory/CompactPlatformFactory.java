package socialfeed.factory;

import socialfeed.model.*;
import socialfeed.bridge.*;
import socialfeed.observer.*;
public class CompactPlatformFactory implements SocialPlatformFactory {
    public FeedRenderer createRenderer() { return new CompactFeedRenderer(); }
    public NotificationSender createNotificationSender() { return new EmailNotificationSender(); }
}
