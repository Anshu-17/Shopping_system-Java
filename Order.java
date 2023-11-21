import java.util.ArrayList;

class Order {
    private User user;
    private ArrayList<Product> orderedProducts;

    public Order(User user, ArrayList<Product> orderedProducts) {
        this.user = user;
        this.orderedProducts = new ArrayList<>(orderedProducts);
    }
    
    public ArrayList<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public double calculateTotalAmount() {
        double totalAmount = 0;
        for (Product product : orderedProducts) {
            totalAmount += product.getPrice();
        }
        return totalAmount;
    }

    public void displayOrder() {
        System.out.println("Order for " + user.getName() + ":");
        for (Product product : orderedProducts) {
            System.out.println(product.toString());
        }
        System.out.println("Total Amount: $" + calculateTotalAmount());
    }
    
    public boolean processPayment(PaymentProcessor paymentProcessor, String paymentMethod) {
        double totalAmount = calculateTotalAmount();
        return paymentProcessor.processPayment(totalAmount, paymentMethod);
    }
}