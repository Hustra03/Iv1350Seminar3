package model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import intergration.ItemDescriptionDTO;
import model.Item;
import model.Sale;

public class RegisterTest {

    /*
     * Tests if registerItem adds the item to soldItems list
     */
    @Test
    public void registerItemTest() {
        Sale testSale = new Sale();
        Register testRegister = new Register();
        ItemDescriptionDTO dto= new ItemDescriptionDTO(1, 2);
        int quantity = 1;
        assertNotNull(testRegister.registerItem(dto, quantity, testSale));
        assertEquals(testRegister.registerItem(dto, quantity, testSale).getSoldItems().isEmpty(),false);
        assertEquals(testRegister.registerItem(dto, quantity, testSale)!=testSale,true);
	}
    
}
