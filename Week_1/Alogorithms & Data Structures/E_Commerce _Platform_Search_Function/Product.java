//package Week_1.Alogorithms & Data Structures.E_Commerce _Platform_Search_Function;

public class Product{
    // Private instance variables for product details
    private int productId;
    private String productName;
    private String category;

    // Constructor to initialize product details
    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
    // Getter methods to access product details
    // These methods return the respective product details when called
    public int getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public String getCategory() {
        return category;
    }

}

