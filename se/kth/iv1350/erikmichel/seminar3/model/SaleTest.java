package se.kth.iv1350.erikmichel.seminar3.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;

import se.kth.iv1350.erikmichael.seminar3.intergration.ItemDescriptionDTO;
import se.kth.iv1350.erikmichel.seminar3.intergration.ItemDescriptionDTO;

public class SaleTest {
    private Sale testSale;
    private ItemDescriptionDTO dto;
    private Item item;
    private Item item2;

    @Before
    public void setUp() {
        testSale = new Sale();
        dto = new ItemDescriptionDTO();
        item = new Item(dto, 10);
        item2 = new Item(dto, 20);
    }

    @After
    public void tearDown() {
        dto = null;
        testSale = null;
        item = null;
        item2 = null;
    }

    /*
     * Tests if setItemFoundFalse does so
     */
    @Test
    public void setItemFoundFalseTest() {
        testSale.setItemFoundFalse();
        assertEquals("Item Found False Is Not False",testSale.getItemFound(), false);
    }

    /*
     * Tests if itemMerger merges items with identical DTOs
     */
    @Test
    public void itemMergerTest() {

        assertEquals("Sold Items Is Not Empty At Sale Creation",testSale.getSoldItems().isEmpty(), true);
        testSale.addItemInfo(item);
        testSale.addItemInfo(item2);
        assertEquals("More or Less Than Two Items Have Been Added To TestSale",testSale.getSoldItems().size(), 2);
        assertEquals("Quantity Of First Item Is Incorrect",testSale.getSoldItems().get(0).getQuantity(), 10);
        testSale.itemMerger(item2);
        assertEquals("Items Objects Not Removed Correctly From Sold Items",testSale.getSoldItems().size(), 1);
        assertEquals("Quantity Of Items Not Merged Successfully",testSale.getSoldItems().get(0).getQuantity(), 30);
    }

    /*
     * Tests if calculateRunningTotal calculates a correct running total
     */
    @Test
    public void calculateRunningTotalTest() {
        testSale.addItemInfo(item);
        assertEquals("Size Of Sold Items Incorrect",testSale.getSoldItems().size(), 1);
        testSale.calculateRunningTotal();
        assertNotNull("Total Price Does Not Exist",testSale.getTotalPrice());
        assertNotNull("Total VAT Does Not Exist",testSale.getTotalVAT());
    }

    /*
     * Tests if addItemInfo adds the item correctly to the soldItems list
     */
    @Test
    public void addItemInfoTest() {
        assertEquals("Sold Items Is Not Empty At Sale Creation",testSale.getSoldItems().isEmpty(), true);

        testSale.addItemInfo(item);
        testSale.addItemInfo(item2);
        assertEquals("Sold Items Empty After Adding Items",testSale.getSoldItems().isEmpty(), false);
        assertEquals("Sold Items Does Not Contain Item Which Should Have Been Added",testSale.getSoldItems().contains(item), true);
        assertEquals("Sold Items Does Not Contain Item2 Which Should Have Been Added",testSale.getSoldItems().contains(item2), true);
    }
}
