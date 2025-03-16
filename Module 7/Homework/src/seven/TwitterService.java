package seven;
import java.util.*;

public class TwitterService {
  private final List<seven.Post> posts = new ArrayList<>();

  public void initializePosts() {
    posts.add(new seven.Post(new seven.User("Alice"), "Привет, мир!"));
    posts.add(new seven.Post(new seven.User("Bob"), "Сегодня отличный день!"));
    posts.add(new seven.Post(new seven.User("Charlie"), "Люблю программировать на Java."));
  }

  public void createPost(seven.User user, String content) {
    if (user == null) {
      System.out.println("Ошибка: пользователь не найден.");
      return;
    }
    seven.Post post = new seven.Post(user, content);
    posts.add(post);
    System.out.println("Пост добавлен!");
  }
  public void commentPost(int postId, seven.User user, String content) {
    posts.stream()
            .filter(p -> p.getId() == postId)
            .findFirst()
            .ifPresentOrElse(
                    post -> {
                      post.addComment(user, content);
                      System.out.println("Комментарий добавлен!");
                    },
                    () -> System.out.println("Пост не найден."));
  }
  public void likePost(int postId) {
    posts.stream()
            .filter(p -> p.getId() == postId)
            .findFirst()
            .ifPresentOrElse(
                    seven.Post::like,
                    () -> System.out.println("Пост не найден.")
            );
  }

  public void repostPost(int postId) {
    posts.stream()
            .filter(p -> p.getId() == postId)
            .findFirst()
            .ifPresentOrElse(
                    seven.Post::repost,
                    () -> System.out.println("Пост не найден.")
            );
  }

  public void showAllPosts() {
    posts.forEach(System.out::println);
  }

  public void showPopularPosts(int count) {
    posts.stream()
            .sorted(Comparator.comparingInt(seven.Post::getLikes).reversed())
            .limit(count)
            .forEach(System.out::println);
  }

  public void showUserPosts(seven.User user) {
    if (user == null) {
      System.out.println("Ошибка: пользователь не найден.");
      return;
    }
    posts.stream()
            .filter(p -> p.getAuthor().equals(user))
            .forEach(System.out::println);
  }
}