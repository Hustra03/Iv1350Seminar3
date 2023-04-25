package model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;  //For List to function

import model.Sale;
import model.Item;
import intergration.ItemDescriptionDTO;

public class SaleTest {
    

    /*
     * Tests if setItemFoundFalse does so
     */
    @Test
    public void setItemFoundFalseTest() {
        Sale testSale = new Sale();
        testSale.setItemFoundFalse();
		assertEquals(testSale.getItemFound(),false);
	}
    /*
     * Tests if itemMerger merges items with identical DTOs
     */
    @Test
    public void itemMergerTest() {
        Sale testSale = new Sale();
        ItemDescriptionDTO dto= new ItemDescriptionDTO();
        Item item = new Item(dto,10);
        Item item2 = new Item(dto,20);
        testSale.addItemInfo(item);
        testSale.addItemInfo(item);
		assertEquals(testSale.getSoldItems().size(),1);
        assertEquals(testSale.getSoldItems().contains(item2),true);
	}
    /*
     * Tests if calculateRunningTotal calculates a correct running total
     */
    @Test
    public void calculateRunningTotalTest() {
        Sale testSale = new Sale();
        ItemDescriptionDTO dto= new ItemDescriptionDTO();
        Item item = new Item(dto,10);
        Item item2 = new Item(dto,20);
        testSale.addItemInfo(item);
        testSale.addItemInfo(item);
		assertEquals(testSale.getSoldItems().size(),1);
        assertEquals(testSale.getSoldItems().contains(item2),true);
	}
    /*
     * Tests if addItemInfo adds the item correctly to the soldItems list
     */
    @Test
    public void addItemInfoTest() {
        Sale testSale = new Sale();
        ItemDescriptionDTO dto= new ItemDescriptionDTO();
        Item item = new Item(dto,10);
        Item item2 = new Item(dto,20);
        testSale.addItemInfo(item);
        testSale.addItemInfo(item);
		assertEquals(testSale.getSoldItems().size(),1);
        assertEquals(testSale.getSoldItems().contains(item2),true);
	}
}
