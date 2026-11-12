package socialfeed.model;

import socialfeed.visitor.*;
import socialfeed.observer.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Feed {
    private final List<Post> posts = new ArrayList<>();
    private final List<FeedObserver> observers = new ArrayList<>();

    public void subscribe(FeedObserver observer) {
        if (observer == null) throw new IllegalArgumentException("Observer cannot be null");
        if (!observers.contains(observer)) observers.add(observer);
    }

    public void unsubscribe(FeedObserver observer) {
        observers.remove(observer);
    }

    public void publish(Post post) {
        if (post == null) throw new IllegalArgumentException("Post cannot be null");
        posts.add(post);
        for (FeedObserver observer : List.copyOf(observers)) observer.onNewPost(post);
    }

    public List<Post> getPosts() {
        return Collections.unmodifiableList(posts);
    }
}
