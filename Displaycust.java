import java.util.ArrayList;

public class Displaycust {
    public void displaycust(ArrayList<User> userList) {
        for (User user : userList) {
            System.out.println(user.toString());
            System.out.println();
        }
    }
}
