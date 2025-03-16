package seven;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class Post {
    private static final AtomicInteger idCounter = new AtomicInteger(1);
    private final int id;
    private final seven.User author;
    private final String content;
    private int likes;
    private int reposts;
    private final Map<seven.User, String> comments = new LinkedHashMap<>();

    public Post(seven.User author, String content) {
        this.id = idCounter.getAndIncrement();
        this.author = author;
        this.content = content.length() > 280 ? content.substring(0, 280) : content;
    }

    public int getId() { return id; }
    public seven.User getAuthor() { return author; }
    public String getContent() { return content; }
    public int getLikes() { return likes; }
    public int getReposts() { return reposts; }
    public void like() { likes++; }
    public void repost() { reposts++; }

    public void addComment(seven.User user, String content) { //Я добавил комментарии к посту
        comments.put(user, content);
    }

    @Override
    public String toString() {
        String commentSection = comments.isEmpty() ? "Нет комментариев" :
                comments.entrySet().stream()
                        .map(entry -> entry.getKey().getName() + ": " + entry.getValue())
                        .collect(Collectors.joining("\n    "));

        return String.format("Post{id=%d, author=%s, content='%s', likes=%d, reposts=%d}\nКомментарии:\n    %s",
                id, author.getName(), content, likes, reposts, commentSection);
    }
}
