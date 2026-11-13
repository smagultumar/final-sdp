package socialfeed.factory;

import socialfeed.model.*;
import socialfeed.bridge.*;
import socialfeed.observer.*;
public abstract class PostFactory {
    public abstract Post createPost(String id, String author, String text, String mediaUrl);

    public static PostFactory forType(String type) {
        if ("TEXT".equalsIgnoreCase(type)) return new TextPostFactory();
        if ("IMAGE".equalsIgnoreCase(type)) return new ImagePostFactory();
        throw new IllegalArgumentException("Unsupported post type: " + type);
    }
}
