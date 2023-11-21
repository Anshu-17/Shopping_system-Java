import java.util.ArrayList;
import java.util.Scanner;

public class UserLoginAuth {
	
	public User loginUser(Scanner scanner, ArrayList<User> userList) {
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                return user;
            }
        }

        System.out.println("Login failed. Invalid email or password.");
        return null;
    }
}
