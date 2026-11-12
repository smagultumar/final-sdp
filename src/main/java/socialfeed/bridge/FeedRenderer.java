package socialfeed.bridge;

import socialfeed.model.*;
import socialfeed.strategy.*;
public interface FeedRenderer {
    String render(Post post);
}
