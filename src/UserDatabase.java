import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private List<User> users = new ArrayList<>();

    public UserDatabase() {
        users.add(new User("Sanat", "sanat", "2007"));
        users.add(new User("Nurkeldi", "nurik", "2009"));
        users.add(new User("Mansur", "mans", "2006"));
    }

    public User login(String login, String password) {
        for (User u : users) {
            if (u.login.equals(login) && u.password.equals(password)) {
                return u;
            }x
        }
        return null;
    }
}