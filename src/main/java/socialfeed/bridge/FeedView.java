package socialfeed.bridge;

import socialfeed.model.*;
import socialfeed.strategy.*;
import java.util.List;

public abstract class FeedView {
    protected final FeedRenderer renderer;

    protected FeedView(FeedRenderer renderer) {
        if (renderer == null) throw new IllegalArgumentException("Renderer is required");
        this.renderer = renderer;
    }

    public abstract void display(List<Post> posts, FeedSortStrategy strategy);
}
