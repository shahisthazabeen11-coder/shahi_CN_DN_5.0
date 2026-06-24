//package Week_1.Alogorithms & Data Structures.E_Commerce _Platform_Search_Function;


public class TestSearch {
    public static void main(String[] args) {
        Product[] products = {
                new Product(1,"Laptop","Electronics"),
                new Product(2,"Smartphone","Electronics"),
                new Product(3,"Headphones","Electronics"),
                new Product(4,"Shoes","Fashion"),
                new Product(5,"T-shirt","Fashion")
        };

        String searchTerm = "Shoes";

        // Perform linear search
        Product linearResult=SearchFunctions.linearSearch(products, searchTerm);
        if(linearResult != null) {
            System.out.println("Linear Search: Product found-ID: " + linearResult.getProductId()+",Name:"+linearResult.getProductName()+",Category:"+linearResult.getCategory());
        } else {
            System.out.println("Linear Search: Product not found");
        }

        // Perform binary search
        Product binaryResult = SearchFunctions.binarySearch(products, searchTerm);
        if(binaryResult != null) {
            System.out.println("Binary Search: Product found-ID: " + binaryResult.getProductId()+",Name:"+binaryResult.getProductName()+",Category:"+binaryResult.getCategory());
        } else{
            System.out.println("Binary Search: Product not found");
        }
    }
}
