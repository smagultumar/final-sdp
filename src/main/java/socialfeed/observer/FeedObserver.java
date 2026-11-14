package socialfeed.observer;

import socialfeed.model.*;
public interface FeedObserver {
    void onNewPost(Post post);
}
