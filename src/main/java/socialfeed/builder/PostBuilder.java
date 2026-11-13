package socialfeed.builder;

import socialfeed.model.*;
public class PostBuilder {
    private String id;
    private String author;
    private String text = "";
    private String imageUrl = "";

    public PostBuilder setId(String id) { this.id = id; return this; }
    public PostBuilder setAuthor(String author) { this.author = author; return this; }
    public PostBuilder setText(String text) { this.text = text; return this; }
    public PostBuilder setImageUrl(String imageUrl) { this.imageUrl = imageUrl; return this; }

    public Post build() {
        if (id == null || author == null) throw new IllegalStateException("Post id and author are required");
        if (imageUrl != null && !imageUrl.isBlank()) return new ImagePost(id, author, text, imageUrl);
        return new TextPost(id, author, text);
    }
}
