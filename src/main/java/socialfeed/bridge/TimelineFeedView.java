package socialfeed.bridge;

import socialfeed.model.*;
import socialfeed.strategy.*;
import java.util.List;

public class TimelineFeedView extends FeedView {
    public TimelineFeedView(FeedRenderer renderer) {
        super(renderer);
    }

    public void display(List<Post> posts, FeedSortStrategy strategy) {
        for (Post post : strategy.sort(posts)) {
            System.out.println(renderer.render(post));
        }
    }
}
