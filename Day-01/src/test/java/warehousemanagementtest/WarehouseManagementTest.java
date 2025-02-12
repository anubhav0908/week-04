package warehousemanagementtest;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import com.generics.smartwarehousemanagementsystem.Electronics;
import com.generics.smartwarehousemanagementsystem.Groceries;
import com.generics.smartwarehousemanagementsystem.Furniture;
import com.generics.smartwarehousemanagementsystem.Storage;
import com.generics.smartwarehousemanagementsystem.WarehouseItem;

public class WarehouseManagementTest {

    @Test
    public void testElectronicsStorage() {
        // Create a Storage for Electronics
        Storage<Electronics> electronicsStorage = new Storage<>();

        // Add items to the storage
        electronicsStorage.addItem(new Electronics("Laptop", 1200));
        electronicsStorage.addItem(new Electronics("Smartphone", 800));

        // Verify the items in the storage
        List<Electronics> items = electronicsStorage.getItems();
        Assert.assertEquals(2, items.size());
        Assert.assertEquals("Laptop", items.get(0).getName());
        Assert.assertEquals(1200, items.get(0).getPrice(), 0.01);
    }

    @Test
    public void testGroceriesStorage() {
        // Create a Storage for Groceries
        Storage<Groceries> groceriesStorage = new Storage<>();

        // Add items to the storage
        groceriesStorage.addItem(new Groceries("Apple", 1.5));
        groceriesStorage.addItem(new Groceries("Milk", 2.0));

        // Verify the items in the storage
        List<Groceries> items = groceriesStorage.getItems();
        Assert.assertEquals(2, items.size());
        Assert.assertEquals("Apple", items.get(0).getName());
        Assert.assertEquals(1.5, items.get(0).getPrice(), 0.01);
    }

    @Test
    public void testFurnitureStorage() {
        // Create a Storage for Furniture
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Add items to the storage
        furnitureStorage.addItem(new Furniture("Chair", 50));
        furnitureStorage.addItem(new Furniture("Table", 150));

        // Verify the items in the storage
        List<Furniture> items = furnitureStorage.getItems();
        Assert.assertEquals(2, items.size());
        Assert.assertEquals("Chair", items.get(0).getName());
        Assert.assertEquals(50, items.get(0).getPrice(), 0.01);
    }

    @Test
    public void testWarehouseUtilDisplay() {
        // Create a Storage for Electronics
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", 1200));
        electronicsStorage.addItem(new Electronics("Smartphone", 800));

        // Create a Storage for Groceries
        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Apple", 1.5));
        groceriesStorage.addItem(new Groceries("Milk", 2.0));

        // Create a Storage for Furniture
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", 50));
        furnitureStorage.addItem(new Furniture("Table", 150));

        // Use WarehouseUtil to display items (this is more of an integration test)
        // Here we will just check the number of items in the list before invoking the display method
        List<? extends WarehouseItem> electronicsItems = electronicsStorage.getItems();
        List<? extends WarehouseItem> groceriesItems = groceriesStorage.getItems();
        List<? extends WarehouseItem> furnitureItems = furnitureStorage.getItems();

        Assert.assertEquals(2, electronicsItems.size());
        Assert.assertEquals(2, groceriesItems.size());
        Assert.assertEquals(2, furnitureItems.size());
    }
}
