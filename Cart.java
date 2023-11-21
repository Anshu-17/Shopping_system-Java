import java.util.ArrayList;

public class Cart implements CartOperations {
    private static Cart instance;
    private ArrayList<Product> items;

    public Cart() {
        this.items = new ArrayList<>();
    }
    
    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    @Override
    public void addToCart(Product product) {
        items.add(product);
        System.out.println(product.getProductName() + " added to the cart.");
    }

    @Override
    public Product removeFromCart(int index) {
        if (index >= 0 && index < items.size()) {
            return items.remove(index);
        }
        return null;
    }

    @Override
    public Order checkout(User user) {
        Order order = new Order(user, new ArrayList<>(items));
        items.clear();
        return order;
    }

    @Override
    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Items in the cart:");
            for (Product item : items) {
                System.out.println(item.toString());
            }
        }
    }

    public ArrayList<Product> getItems() {
        return items;
    }
}
