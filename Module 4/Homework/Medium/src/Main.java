
public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        UserData user1 = userRepository.getUser(1);
        System.out.println(user1);
        UserData user2 = userRepository.getUser(1);
        System.out.println(user2);
        UserData user3 = userRepository.getUser(2);
        System.out.println(user3);


    }
}
