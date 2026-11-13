package socialfeed.factory;

import socialfeed.model.*;
import socialfeed.bridge.*;
import socialfeed.observer.*;
public interface SocialPlatformFactory {
    FeedRenderer createRenderer();
    NotificationSender createNotificationSender();
}
