package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
        ItemDescriptionDTO dto= new ItemDescriptionDTO();
        Item item = new Item(dto,10);
        Item item2 = new Item(dto,20);
        Sale testSale = new Sale();
        
        assertEquals(testSale.getSoldItems().isEmpty(),true);
        
        testSale.addItemInfo(item);
        testSale.addItemInfo(item2);
		assertEquals(testSale.getSoldItems().size(),2);
        assertEquals(testSale.getSoldItems().get(0).getQuantity(),10);
        testSale.itemMerger(item2);
        assertEquals(testSale.getSoldItems().size(),1);
        assertEquals(testSale.getSoldItems().get(0).getQuantity(),30);
	}
    /*
     * Tests if calculateRunningTotal calculates a correct running total
     */
    @Test
    public void calculateRunningTotalTest() {
        Sale testSale = new Sale();
        double price=10;
        int VATrate=10;
        ItemDescriptionDTO dto= new ItemDescriptionDTO(price,VATrate);
        Item item = new Item(dto,10);
        testSale.addItemInfo(item);
		assertEquals(testSale.getSoldItems().size(),1);
        testSale.calculateRunningTotal();
        assertNotNull(testSale.getTotalPrice());
        assertNotNull(testSale.getTotalVAT());
	}
    /*
     * Tests if addItemInfo adds the item correctly to the soldItems list
     */
    @Test
    public void addItemInfoTest() {
        ItemDescriptionDTO dto= new ItemDescriptionDTO();
        Item item = new Item(dto,10);
        Item item2 = new Item(dto,20);
        Sale testSale = new Sale();
        
        assertEquals(testSale.getSoldItems().isEmpty(),true);
        
        testSale.addItemInfo(item);
        testSale.addItemInfo(item2);
        assertEquals(testSale.getSoldItems().isEmpty(),false);
	}
}
