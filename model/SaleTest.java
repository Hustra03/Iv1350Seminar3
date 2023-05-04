package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;

import intergration.ItemDescriptionDTO;

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
        assertEquals(testSale.getItemFound(), false);
    }

    /*
     * Tests if itemMerger merges items with identical DTOs
     */
    @Test
    public void itemMergerTest() {

        assertEquals("The created list isnt empty as it should be",testSale.getSoldItems().isEmpty(), true);
        testSale.addItemInfo(item);
        testSale.addItemInfo(item2);
        assertEquals("TestSale doesnt consists of two items as it should",testSale.getSoldItems().size(), 2);
        assertEquals("Wrong amount of the first item",testSale.getSoldItems().get(0).getQuantity(), 10);
        testSale.itemMerger(item2);
        assertEquals("Wrong number of items",testSale.getSoldItems().size(), 1);
        assertEquals("Total amount of quantity deviates from the expected value",testSale.getSoldItems().get(0).getQuantity(), 30);
    }

    /*
     * Tests if calculateRunningTotal calculates a correct running total
     */
    @Test
    public void calculateRunningTotalTest() {
        testSale.addItemInfo(item);
        assertEquals(testSale.getSoldItems().size(), 1);
        testSale.calculateRunningTotal();
        assertNotNull(testSale.getTotalPrice());
        assertNotNull(testSale.getTotalVAT());
    }

    /*
     * Tests if addItemInfo adds the item correctly to the soldItems list
     */
    @Test
    public void addItemInfoTest() {
        assertEquals("Solditems is not empty",testSale.getSoldItems().isEmpty(), true);

        testSale.addItemInfo(item);
        testSale.addItemInfo(item2);
        assertEquals("Solditems are missing items!",testSale.getSoldItems().isEmpty(), false);
        assertEquals("Item is missing in the list of solditems",testSale.getSoldItems().contains(item), true);
        assertEquals("Item2 is missing in the list of solditems",testSale.getSoldItems().contains(item2), true);
    }
}
