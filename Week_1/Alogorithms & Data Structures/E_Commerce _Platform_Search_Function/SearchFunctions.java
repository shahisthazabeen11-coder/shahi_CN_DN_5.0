//package Week_1.Alogorithms & Data Structures.E_Commerce _Platform_Search_Function;
import java.util.Arrays;
import java.util.Comparator;
//import E_Commerce_Platform_Search_Function.Product;

public class SearchFunctions {
     public static Product linearSearch(Product[] products,String searchTerm) {
        for(Product product : products){
            if(product.getProductName().equalsIgnoreCase(searchTerm)){
                return product;
            }
        }
        return null; // Return null if the product is not found 
    }
    public static Product binarySearch(Product[] products,String searchTerm) {
        Arrays.sort(products,Comparator.comparing(Product::getProductName,String.CASE_INSENSITIVE_ORDER));
        int left=0;
        int right=products.length-1;

        while(left<=right) {
            int mid=(left+right)/2;
            int comp=products[mid].getProductName().compareToIgnoreCase(searchTerm);

            if (comp==0){
                return products[mid]; // Product found
            } else if(comp<0){
                left=mid+1;// Search in the right half
            } else{
                right=mid-1; // Search in the left half
            }
        }
        return null; // Return null if the product is not found
    }
}

