package socialfeed.visitor;

import socialfeed.model.ImagePost;
import socialfeed.model.TextPost;

public class FeedStatisticsVisitor implements PostVisitor {
    private int textPosts;
    private int imagePosts;
    private int totalLikes;

    public void visit(TextPost var1) {
        ++this.textPosts;
        this.totalLikes += var1.getLikes();
    }

    public void visit(ImagePost var1) {
        ++this.imagePosts;
        this.totalLikes += var1.getLikes();
    }

    public int getTextPosts() {
        return this.textPosts;
    }

    public int getImagePosts() {
        return this.imagePosts;
    }

    public int getTotalLikes() {
        return this.totalLikes;
    }
}
