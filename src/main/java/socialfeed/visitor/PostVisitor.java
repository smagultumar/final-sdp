package socialfeed.visitor;

import socialfeed.model.ImagePost;
import socialfeed.model.TextPost;

public interface PostVisitor {
    void visit(TextPost var1);

    void visit(ImagePost var1);
}
