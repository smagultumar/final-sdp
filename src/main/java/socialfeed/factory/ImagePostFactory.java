package socialfeed.factory;

import socialfeed.model.*;
import socialfeed.bridge.*;
import socialfeed.observer.*;
public class ImagePostFactory extends PostFactory {
    public Post createPost(String id, String author, String text, String mediaUrl) {
        return new ImagePost(id, author, text, mediaUrl);
    }
}
