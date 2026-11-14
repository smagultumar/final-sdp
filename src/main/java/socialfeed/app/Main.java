package socialfeed.app;

import socialfeed.builder.*;
import socialfeed.bridge.*;
import socialfeed.decorator.*;
import socialfeed.facade.*;
import socialfeed.factory.*;
import socialfeed.model.*;
import socialfeed.observer.*;
import socialfeed.visitor.*;

public class Main {
    public static void main(String[] args) {
        SocialMediaFacade app = new SocialMediaFacade(new StandardPlatformFactory());
        app.follow("Zamira");

        Post first = new PostBuilder()
                .setId("P-101")
                .setAuthor("Tumar")
                .setText("Hello from our Social Media Feed project!")
                .build();

        Post second = PostFactory.forType("IMAGE")
                .createPost("P-102", "Zeine", "Our team project is ready", "https://example.com/team.jpg");

        first.like();
        second.like();
        second.like();

        app.publish(first);
        app.publish(second);

        System.out.println("\n=== NEWEST FIRST ===");
        app.showNewestFirst();

        System.out.println("\n=== MOST LIKED ===");
        app.showMostLiked();

        System.out.println("\n=== DECORATOR ===");
        PostDisplay decorated = new HashtagDecorator(
                new EmojiDecorator(new BasicPostDisplay(first), "✨"), "SE2510");
        System.out.println(decorated.display());

        System.out.println("\n=== VISITOR STATISTICS ===");
        FeedStatisticsVisitor statistics = new FeedStatisticsVisitor();
        for (Post post : app.getFeed().getPosts()) post.accept(statistics);
        System.out.println("Text posts: " + statistics.getTextPosts());
        System.out.println("Image posts: " + statistics.getImagePosts());
        System.out.println("Total likes: " + statistics.getTotalLikes());

        System.out.println("\n=== ABSTRACT FACTORY ===");
        SocialMediaFacade compactApp = new SocialMediaFacade(new CompactPlatformFactory());
        compactApp.follow("Tumar");
        compactApp.publish(new TextPost("P-103", "Zamira", "Compact feed is active"));
    }
}
