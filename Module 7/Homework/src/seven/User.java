package seven;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Objects;

public class User {
  private static final AtomicInteger idCounter = new AtomicInteger(1);
  private final int id;
  private final String name;

  public User(String name) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Имя пользователя не может быть пустым!");
    }
    this.id = idCounter.getAndIncrement();
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    User user = (User) obj;
    return id == user.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return name;
  }
}
