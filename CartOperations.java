public interface CartOperations {
    void addToCart(Product product);

    Product removeFromCart(int index);

    Order checkout(User user);

    void displayCart();
}
