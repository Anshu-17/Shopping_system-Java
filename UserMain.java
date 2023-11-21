import java.util.ArrayList;
import java.util.Scanner;

public class UserMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> userList = new ArrayList<>();
        UserLoginAuth loginAuthentication = new UserLoginAuth();
        User loggedInUser = null;
        ProductCatalog productCatalog = new ProductCatalog();
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Create account");
            System.out.println("2. Display all users");
            System.out.println("3. Login");
            System.out.println("4. Display products");
            System.out.println("5. Add to cart");
            System.out.println("6. Remove from cart");
            System.out.println("7. Display cart");
            System.out.println("8. Check Out");
            System.out.println("9. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    CreateAccount createAccount = new CreateAccount();
                    createAccount.createacc(scanner, userList);
                    break;
                case 2:
                    Displaycust displaycust = new Displaycust();
                    displaycust.displaycust(userList);
                    break;
                case 3:
                    loggedInUser = loginAuthentication.loginUser(scanner, userList);
                    break;
                case 4:
                    productCatalog.displayProducts();
                    break;
                case 5:
                    CartManager.addToCart(scanner, loggedInUser, productCatalog);
                    break;
                case 6:
                    CartManager.removeFromCart(scanner, loggedInUser);
                    break;
                case 7:
                    CartManager.displayCart(loggedInUser);
                    break;  // Added break statement here
                case 8:
                    CartManager.checkout(loggedInUser, paymentProcessor);
                    break;
                case 9:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
