package socialfeed.model;

import socialfeed.visitor.*;
import socialfeed.observer.*;
public class TextPost extends Post {
    public TextPost(String id, String author, String text) {
        super(id, author, text, "");
    }
    public String getType() { return "TEXT"; }
    public void accept(PostVisitor visitor) { visitor.visit(this); }
}
