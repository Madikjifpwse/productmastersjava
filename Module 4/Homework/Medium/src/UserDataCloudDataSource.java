import java.util.HashMap;
import java.util.Map;

public class UserDataCloudDataSource {
    private final Map<Integer, UserData> cloudData;

    public UserDataCloudDataSource() {
        cloudData = new HashMap<>();
        cloudData.put(1, new UserData(1, "Someone", "someone@.com"));
        cloudData.put(2, new UserData(2, "Madik", "madik.com"));
        cloudData.put(3, new UserData(3, "Madiyar", "madiyar@.com"));
    }

    public UserData fetchUser(int id) {
        System.out.println("Получаем данные пользователя с ID " + id + " из облака...");
        return cloudData.get(id);
    }
}
