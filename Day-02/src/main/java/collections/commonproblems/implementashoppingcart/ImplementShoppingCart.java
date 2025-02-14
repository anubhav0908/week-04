package collections.commonproblems.implementashoppingcart;
import java.util.*;

public class ImplementShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>(); // Stores product prices (unordered)
    private Map<String, Double> cartOrder = new LinkedHashMap<>(); // Maintains insertion order
    private TreeMap<Double, String> sortedCart = new TreeMap<>(); // Sorts by price
    public static void main(String[] args) {
        ImplementShoppingCart cart = new ImplementShoppingCart();

        // Adding products
        cart.addProduct("Skirt", 500);
        cart.addProduct("Top", 300);
        cart.addProduct("Headphones", 2000);
        cart.addProduct("Mouse", 1500);
        cart.addProduct("Speaker", 2500);

        // Display results
        cart.displayCartOrder();
        cart.displaySortedCart();
        cart.displayAllProducts();
    }

    // Method to add a product with price
    public void addProduct(String product, double price) {
        productPrices.put(product, price); // Store in HashMap
        cartOrder.put(product, price); // Store in LinkedHashMap
        sortedCart.put(price, product); // Store in TreeMap
    }

    // Display products in order they were added
    public void displayCartOrder() {
        System.out.println("\nCart Items (Order of Addition):");
        for (Map.Entry<String, Double> entry : cartOrder.entrySet()) {
            System.out.println(entry.getKey() + " - ₹" + entry.getValue());
        }
    }

    // Display products sorted by price
    public void displaySortedCart() {
        System.out.println("\nCart Items (Sorted by Price):");
        for (Map.Entry<Double, String> entry : sortedCart.entrySet()) {
            System.out.println(entry.getValue() + " - ₹" + entry.getKey());
        }
    }

    // Display all products (unordered)
    public void displayAllProducts() {
        System.out.println("\nAll Products (Unordered):");
        for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
            System.out.println(entry.getKey() + " - ₹" + entry.getValue());
        }
    }
}

