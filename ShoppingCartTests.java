import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.*;
import org.junit.jupiter.api.Test;

public class ShoppingCartTests {

    @Test
    public void testProductCatalogInitialization() {
        ProductCatalog productCatalog = new ProductCatalog();
        assertNotNull(productCatalog.getProductList());
        assertFalse(productCatalog.getProductList().isEmpty());
    }

    @Test
    public void testCartOperations() {
        Cart cart = Cart.getInstance();
        assertNotNull(cart);

        Product product1 = new Electronics("Test Electronics", 99.99);
        Product product2 = new Clothing("Test Clothing", 29.99);

        cart.addToCart(product1);
        cart.addToCart(product2);

        assertEquals(2, cart.getItems().size());

        Product removedProduct = cart.removeFromCart(0);
        assertEquals(product1, removedProduct);
        assertEquals(1, cart.getItems().size());

        Order order = cart.checkout(new User("TestUser", "test@example.com", "password"));
        assertNotNull(order);
        assertEquals(1, order.getOrderedProducts().size());

        cart.displayCart(); // Test displayCart method
    }

    @Test
    public void testOrderProcessing() {
        User user = new User("TestUser", "test@example.com", "password");
        Cart cart = Cart.getInstance();
        assertNotNull(cart);

        Product product = new Electronics("Test Electronics", 99.99);
        cart.addToCart(product);

        Order order = cart.checkout(user);
        assertNotNull(order);

        PaymentProcessor paymentProcessor = new PaymentProcessor();
        assertTrue(order.processPayment(paymentProcessor, "cash_on_delivery"));
        assertFalse(order.processPayment(paymentProcessor, "invalid_payment_method"));

        order.displayOrder(); 
    }

        @Test
        public void testInvalidProductIndex() {
            ProductCatalog productCatalog = new ProductCatalog();
            assertFalse(CartManager.isValidProductIndex(-1, productCatalog));
            assertFalse(CartManager.isValidProductIndex(productCatalog.getProductList().size(), productCatalog));
        }

        @Test
        public void testEmptyCartCheckout() {
            Cart cart = Cart.getInstance();
            assertNotNull(cart);

            User user = new User("TestUser", "test@example.com", "password");
            Order order = cart.checkout(user);

            assertNotNull(order);
            assertTrue(order.getOrderedProducts().isEmpty());
            assertEquals(0.0, order.calculateTotalAmount(), 0.001);
        }

        @Test
        public void testOrderProcessingFailure() {
            Cart cart = Cart.getInstance();
            assertNotNull(cart);

            Product product = new Electronics("Test Electronics", 99.99);
            cart.addToCart(product);

            Order order = cart.checkout(new User("TestUser", "test@example.com", "password"));
            assertNotNull(order);

            PaymentProcessor paymentProcessor = new PaymentProcessor();
            assertFalse(order.processPayment(paymentProcessor, "invalid_payment_method"));
        }

        @Test
        public void testUserLogin() {
            ArrayList<User> userList = new ArrayList<>();
            User newUser = new User("NewUser", "newuser@example.com", "newpassword");
            userList.add(newUser);

            UserLoginAuth userLoginAuth = new UserLoginAuth();
            User loggedInUser = userLoginAuth.loginUser(new Scanner("newuser@example.com\nnewpassword\n"), userList);

            assertNotNull(loggedInUser);
            assertEquals(newUser, loggedInUser);
        }

}





