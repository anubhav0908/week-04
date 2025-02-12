package onlinemarketplacetest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import com.generics.dynamiconlinemarketplace.Product;
import com.generics.dynamiconlinemarketplace.ProductCatalog;
import com.generics.dynamiconlinemarketplace.BookCategory;
import com.generics.dynamiconlinemarketplace.ClothingCategory;
import com.generics.dynamiconlinemarketplace.GadgetCategory;
import com.generics.dynamiconlinemarketplace.DiscountUtil;

public class OnlineMarketPlaceTest {

    private ProductCatalog<Product<BookCategory>> bookCatalog;
    private ProductCatalog<Product<ClothingCategory>> clothingCatalog;
    private ProductCatalog<Product<GadgetCategory>> gadgetCatalog;

    @Before
    public void setUp() {
        // Set up catalogs before each test
        bookCatalog = new ProductCatalog<>();
        clothingCatalog = new ProductCatalog<>();
        gadgetCatalog = new ProductCatalog<>();

        // Add products to catalogs
        bookCatalog.addProduct(new Product<>("The Alchemist", 15.99, BookCategory.FICTION));
        bookCatalog.addProduct(new Product<>("A Brief History of Time", 20.99, BookCategory.SCIENCE));

        clothingCatalog.addProduct(new Product<>("T-Shirt", 9.99, ClothingCategory.MEN));
        clothingCatalog.addProduct(new Product<>("Dress", 29.99, ClothingCategory.WOMEN));

        gadgetCatalog.addProduct(new Product<>("Smartphone", 699.99, GadgetCategory.SMARTPHONES));
        gadgetCatalog.addProduct(new Product<>("Laptop", 1299.99, GadgetCategory.LAPTOPS));
    }

    @Test
    public void testAddProductToCatalog() {
        // Check that the number of products in the book catalog is 2
        List<Product<BookCategory>> books = bookCatalog.getProducts();
        Assert.assertEquals(2, books.size());

        // Check the name and price of the first book in the catalog
        Assert.assertEquals("The Alchemist", books.get(0).getName());
        Assert.assertEquals(15.99, books.get(0).getPrice(), 0.01);

        // Check the name and price of the second book in the catalog
        Assert.assertEquals("A Brief History of Time", books.get(1).getName());
        Assert.assertEquals(20.99, books.get(1).getPrice(), 0.01);
    }

    @Test
    public void testDisplayCatalog() {
        // Check that the catalog has products
        List<Product<ClothingCategory>> clothingItems = clothingCatalog.getProducts();
        Assert.assertTrue(clothingItems.size() > 0);

        // Check that the catalog contains a product of type "Dress"
        boolean foundDress = false;
        for (Product<ClothingCategory> item : clothingItems) {
            if (item.getName().equals("Dress")) {
                foundDress = true;
                break;
            }
        }
        Assert.assertTrue(foundDress);
    }

    @Test
    public void testApplyDiscount() {
        // Apply discount to the first book in the catalog (10% discount)
        Product<BookCategory> book = bookCatalog.getProducts().get(0);
        double originalPrice = book.getPrice();
        DiscountUtil.applyDiscount(book, 10); // Applying 10% discount

        // Verify that the price has been updated correctly
        double expectedPrice = originalPrice * 0.9; // 10% off
        Assert.assertEquals(expectedPrice, book.getPrice(), 0.01);
    }

    @Test
    public void testProductPriceAfterDiscount() {
        // Apply discount to the first gadget in the catalog (20% discount)
        Product<GadgetCategory> gadget = gadgetCatalog.getProducts().get(0);
        double originalPrice = gadget.getPrice();
        DiscountUtil.applyDiscount(gadget, 20); // Applying 20% discount

        // Verify the price after discount
        double expectedPrice = originalPrice * 0.8; // 20% off
        Assert.assertEquals(expectedPrice, gadget.getPrice(), 0.01);
    }
}
