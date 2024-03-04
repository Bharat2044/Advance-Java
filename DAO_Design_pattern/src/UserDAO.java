import java.util.List;

public interface UserDAO {
    User getUserById(int userId);
    List<User> getAllUsers();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
}
