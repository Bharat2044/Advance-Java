import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImpl();

        // Use the UserDAO methods to interact with the database
        User user = userDAO.getUserById(1);
        List<User> allUsers = userDAO.getAllUsers();
        // Add, update, or delete users as needed
    }
}
