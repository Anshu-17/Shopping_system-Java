import java.util.ArrayList;
import java.util.Scanner;

public class CreateAccount {

    public void createacc(Scanner scanner, ArrayList<User> userList) {

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your email: ");
        String email = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        User user = new User(name, email, password);
        userList.add(user);

    }
}
