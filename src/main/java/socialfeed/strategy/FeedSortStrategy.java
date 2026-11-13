package socialfeed.strategy;

import java.util.List;

import socialfeed.model.Post;

public interface FeedSortStrategy {
    List<Post> sort(List<Post> var1);
}
