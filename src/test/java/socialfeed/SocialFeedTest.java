package socialfeed;

import socialfeed.model.*;
import socialfeed.builder.*;
import socialfeed.factory.*;
import socialfeed.bridge.*;
import socialfeed.facade.*;
import socialfeed.decorator.*;
import socialfeed.observer.*;
import socialfeed.strategy.*;
import socialfeed.visitor.*;
import socialfeed.app.*;

public class SocialFeedTest {
    public static void main(String[] args) {
        SocialMediaFacade app = new SocialMediaFacade(new StandardPlatformFactory());
        app.follow("TestUser");
        Post text = new PostBuilder().setId("1").setAuthor("A").setText("Hello").build();
        Post image = PostFactory.forType("IMAGE").createPost("2", "B", "Photo", "https://example.com/a.jpg");
        text.like();
        image.like();
        image.like();
        app.publish(text);
        app.publish(image);

        if (app.getFeed().getPosts().size() != 2) throw new AssertionError("Feed publish failed");

        FeedStatisticsVisitor visitor = new FeedStatisticsVisitor();
        app.getFeed().getPosts().forEach(post -> post.accept(visitor));
        if (visitor.getTextPosts() != 1 || visitor.getImagePosts() != 1 || visitor.getTotalLikes() != 3) {
            throw new AssertionError("Visitor statistics failed");
        }

        String decorated = new HashtagDecorator(
                new EmojiDecorator(new BasicPostDisplay(text), "✨"), "test").display();
        if (!decorated.contains("#test") || !decorated.contains("✨")) throw new AssertionError("Decorator failed");

        if (new MostLikedStrategy().sort(app.getFeed().getPosts()).get(0) != image) {
            throw new AssertionError("Strategy sorting failed");
        }

        if (!new SocialMediaFacade(new CompactPlatformFactory()).getFeed().getPosts().isEmpty()) {
            throw new AssertionError("Facade initialization failed");
        }

        System.out.println("All Social Media Feed tests passed.");
    }
}
