package model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import intergration.ItemDescriptionDTO;
import model.Sale;

public class RegisterTest {

    /*
     * Tests if registerItem adds the item to soldItems list
     */
    @Test
    public void registerItemTest() {
        Sale testSale = new Sale();
        Register testRegister = new Register();
        ItemDescriptionDTO dto= new ItemDescriptionDTO();
        int quantity = 1;
        Item testItem = new Item(dto,quantity);
        testSale=testRegister.registerItem(dto, quantity, testSale);
        assertEquals(testSale.getSoldItems().contains(testItem),true);
	}
    
}
