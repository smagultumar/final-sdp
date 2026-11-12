package socialfeed.model;

import socialfeed.visitor.*;
import socialfeed.observer.*;
public class ImagePost extends Post {
    public ImagePost(String id, String author, String text, String imageUrl) {
        super(id, author, text, imageUrl);
        if (imageUrl == null || imageUrl.isBlank()) {
            throw new IllegalArgumentException("Image URL is required");
        }
    }
    public String getType() { return "IMAGE"; }
    public void accept(PostVisitor visitor) { visitor.visit(this); }
}
