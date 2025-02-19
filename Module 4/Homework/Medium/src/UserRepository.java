import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private final UserDataCloudDataSource cloudDataSource;
    private final Map<Integer, UserData> cache;

    public UserRepository() {
        this.cloudDataSource = new UserDataCloudDataSource();
        this.cache = new HashMap<>();
    }

    public UserData getUser(int id) {
        if (cache.containsKey(id)) {
            System.out.println("Возвращаем пользователя из кэша...");
            return cache.get(id);
        }

        UserData user = cloudDataSource.fetchUser(id);
        if (user != null) {
            cache.put(id, user);
        }
        return user;
    }
}
