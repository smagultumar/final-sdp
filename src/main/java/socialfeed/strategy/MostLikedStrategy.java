package socialfeed.strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import socialfeed.model.Post;

public class MostLikedStrategy implements FeedSortStrategy {
    public List<Post> sort(List<Post> var1) {
        ArrayList var2 = new ArrayList(var1);
        var2.sort(Comparator.comparingInt(Post::getLikes).reversed());
        return var2;
    }
}
