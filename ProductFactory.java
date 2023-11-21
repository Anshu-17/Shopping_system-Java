
public class ProductFactory {

    public static Product createProduct(String type, String productName, double price) {
        switch (type.toLowerCase()) {
            case "electronics":
                return new Electronics(productName, price);
            case "clothing":
                return new Clothing(productName, price);
            default:
                throw new IllegalArgumentException("Invalid product type: " + type);
        }
    }
}

 