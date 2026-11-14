package socialfeed.observer;

import socialfeed.model.*;
public class UserNotifier implements FeedObserver {
    private final String username;
    private final NotificationSender sender;

    public UserNotifier(String username, NotificationSender sender) {
        if (username == null || username.isBlank() || sender == null) {
            throw new IllegalArgumentException("Username and sender are required");
        }
        this.username = username;
        this.sender = sender;
    }

    public void onNewPost(Post post) {
        System.out.println(sender.send(username, "New post from " + post.getAuthor()));
    }
}
