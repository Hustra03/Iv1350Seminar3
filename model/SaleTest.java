package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;

import java.util.*; //For List to function

import model.Sale;
import model.Item;
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

        assertEquals(testSale.getSoldItems().isEmpty(), true);

        testSale.addItemInfo(item);
        testSale.addItemInfo(item2);
        assertEquals(testSale.getSoldItems().size(), 2);
        assertEquals(testSale.getSoldItems().get(0).getQuantity(), 10);
        testSale.itemMerger(item2);
        assertEquals(testSale.getSoldItems().size(), 1);
        assertEquals(testSale.getSoldItems().get(0).getQuantity(), 30);
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
        assertEquals(testSale.getSoldItems().isEmpty(), true);

        testSale.addItemInfo(item);
        testSale.addItemInfo(item2);
        assertEquals(testSale.getSoldItems().isEmpty(), false);
        assertEquals(testSale.getSoldItems().contains(item), true);
        assertEquals(testSale.getSoldItems().contains(item2), true);
    }
}
