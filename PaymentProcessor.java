import java.util.Scanner;

class PaymentProcessor {
    private static Scanner paymentScanner = new Scanner(System.in);

    @SuppressWarnings("unused")
	public boolean processPayment(double amount, String paymentMethod) {
        try {
            if ("cash_on_delivery".equalsIgnoreCase(paymentMethod)) {
                System.out.println("Cash on delivery selected. The product will be delivered next week.");
                return true; 
            } else if ("online_payment".equalsIgnoreCase(paymentMethod)) {
                System.out.println("Enter your account number:");
                String accountNumber = paymentScanner.nextLine();

                System.out.println("Enter your CVV:");
                String cvv = paymentScanner.nextLine();

                System.out.println("Processing online payment of $" + amount + " using account number: " + accountNumber);
                System.out.println("Payment complete!");
                return true; 
            } else {
                System.out.println("Invalid payment method.");
                return false;
            }
        } finally {
           
        }
    }
}
