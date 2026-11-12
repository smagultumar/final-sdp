package socialfeed.model;

import socialfeed.visitor.*;
import socialfeed.observer.*;
public abstract class Post {
    private final String id;
    private final String author;
    private final String text;
    private final String mediaUrl;
    private int likes;

    protected Post(String id, String author, String text, String mediaUrl) {
        if (id == null || id.isBlank() || author == null || author.isBlank() || text == null) {
            throw new IllegalArgumentException("Post fields are required");
        }
        this.id = id;
        this.author = author;
        this.text = text;
        this.mediaUrl = mediaUrl == null ? "" : mediaUrl;
    }

    public String getId() { return id; }
    public String getAuthor() { return author; }
    public String getText() { return text; }
    public String getMediaUrl() { return mediaUrl; }
    public int getLikes() { return likes; }
    public void like() { likes++; }
    public abstract String getType();
    public abstract void accept(PostVisitor visitor);
}
