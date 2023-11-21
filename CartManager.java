import java.util.Scanner;

public class CartManager {

    private static Scanner scanner = new Scanner(System.in);

    public static void addToCart(Scanner scanner, User loggedInUser, ProductCatalog productCatalog) {
        if (loggedInUser != null) {
            productCatalog.displayProducts();
            System.out.println("Enter the product index to add to the cart:");
            int productIndex = scanner.nextInt();
            scanner.nextLine(); 
            if (isValidProductIndex(productIndex, productCatalog)) {
                Product selectedProduct = productCatalog.getProductList().get(productIndex);
                //loggedInUser.getCart().addToCart(selectedProduct);
                Cart.getInstance().addToCart(selectedProduct);
                Logger.log(loggedInUser, "added product to the cart: " + selectedProduct.getProductName());
            } else {
                System.out.println("Invalid product index.");
            }
        } else {
            System.out.println("Login required to add to the cart.");
        }
    }
    public static void removeFromCart(Scanner scanner, User loggedInUser) {
        if (loggedInUser != null) {
        	Cart userCart = Cart.getInstance();
            userCart.displayCart();

            if (!userCart.getItems().isEmpty()) {
                System.out.println("Enter the index of the item to remove from the cart:");
                int itemIndex = scanner.nextInt();
                scanner.nextLine(); 
                Product removedProduct = userCart.removeFromCart(itemIndex);
                if (removedProduct != null) {
                    Logger.log(loggedInUser, "removed product from the cart: " + removedProduct.getProductName());
                } else {
                    System.out.println("Invalid item index.");
                }
            } else {
                System.out.println("Cart is empty. Nothing to remove.");
            }
        } else {
            System.out.println("Login required to remove from the cart.");
        }
    }
    public static void checkout(User loggedInUser, PaymentProcessor paymentProcessor) {
        if (loggedInUser != null) {
        	Cart userCart = Cart.getInstance(); 
            if (!userCart.getItems().isEmpty()) {
                Order order = userCart.checkout(loggedInUser);

                System.out.println("Select a payment method:");
                System.out.println("1. Cash on delivery");
                System.out.println("2. Online payment");

                int paymentChoice = scanner.nextInt();
                scanner.nextLine();  

                String paymentMethod;
                switch (paymentChoice) {
                    case 1:
                        paymentMethod = "cash_on_delivery";
                        break;
                    case 2:
                        paymentMethod = "online_payment";
                        break;
                    default:
                        System.out.println("Invalid payment method. Order canceled.");
                        return;
                }

                boolean paymentSuccess = order.processPayment(paymentProcessor, paymentMethod);
                if (paymentSuccess) {
                    System.out.println("Checkout successful!");
                    order.displayOrder();
                    Logger.log(loggedInUser, "completed the checkout.");
                } else {
                    System.out.println("Payment processing failed. Order canceled.");
                    Logger.log(loggedInUser, "attempted to checkout, but payment failed.");
                }
            } else {
                System.out.println("Cart is empty. Nothing to checkout.");
            }
        } else {
            System.out.println("Login required to checkout.");
        }
    }

    public static void displayCart(User loggedInUser) {
        if (loggedInUser != null) {
        	Cart.getInstance().displayCart(); 
            Logger.log(loggedInUser, "viewed their cart.");
        } else {
            System.out.println("Login required to display the cart.");
        }
    }

    public static boolean isValidProductIndex(int index, ProductCatalog productCatalog) {
        return index >= 0 && index < productCatalog.getProductList().size();
    }
}
