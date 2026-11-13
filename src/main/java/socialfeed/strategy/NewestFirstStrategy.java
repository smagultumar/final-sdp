package socialfeed.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import socialfeed.model.Post;

public class NewestFirstStrategy implements FeedSortStrategy {
    public List<Post> sort(List<Post> var1) {
        ArrayList var2 = new ArrayList(var1);
        Collections.reverse(var2);
        return var2;
    }
}
