package socialfeed.facade;

import socialfeed.model.*;
import socialfeed.bridge.*;
import socialfeed.factory.*;
import socialfeed.observer.*;
import socialfeed.strategy.*;
public class SocialMediaFacade {
    private final Feed feed;
    private final FeedService service;
    private final SocialPlatformFactory platformFactory;

    public SocialMediaFacade(SocialPlatformFactory platformFactory) {
        if (platformFactory == null) throw new IllegalArgumentException("Platform factory is required");
        this.platformFactory = platformFactory;
        this.feed = new Feed();
        FeedView view = new TimelineFeedView(platformFactory.createRenderer());
        this.service = new FeedService(feed, view);
    }

    public void follow(String username) {
        feed.subscribe(new UserNotifier(username, platformFactory.createNotificationSender()));
    }

    public void publish(Post post) { service.publish(post); }
    public void showNewestFirst() { service.showFeed(new NewestFirstStrategy()); }
    public void showMostLiked() { service.showFeed(new MostLikedStrategy()); }
    public Feed getFeed() { return feed; }
}
