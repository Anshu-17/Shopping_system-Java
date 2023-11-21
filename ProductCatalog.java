import java.util.ArrayList;

public class ProductCatalog {
    private ArrayList<Product> productList;
    

    public ProductCatalog() {
        this.productList = initializeProducts();
    }

    private ArrayList<Product> initializeProducts() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(ProductFactory.createProduct("electronics", "Iphone11", 699.99));
        products.add(ProductFactory.createProduct("electronics", "DELL Laptop", 999.99));
        products.add(ProductFactory.createProduct("electronics", "Mouse", 200.00));
        products.add(ProductFactory.createProduct("clothing", "Tshirt", 29.99));
        products.add(ProductFactory.createProduct("clothing", "Jeans", 25.79));
        products.add(ProductFactory.createProduct("clothing", "Hoodie", 40.19));
        return products;
    }

    public void displayProducts() {
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(i + ". " + productList.get(i).toString());
            System.out.println();
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
}
