package socialfeed.facade;

import socialfeed.model.*;
import socialfeed.bridge.*;
import socialfeed.factory.*;
import socialfeed.observer.*;
import socialfeed.strategy.*;
public class FeedService {
    private final Feed feed;
    private final FeedView view;

    public FeedService(Feed feed, FeedView view) {
        if (feed == null || view == null) throw new IllegalArgumentException("Feed and view are required");
        this.feed = feed;
        this.view = view;
    }

    public void publish(Post post) { feed.publish(post); }

    public void showFeed(FeedSortStrategy strategy) {
        view.display(feed.getPosts(), strategy);
    }

    public Feed getFeed() { return feed; }
}
