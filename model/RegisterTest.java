package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import intergration.ItemDescriptionDTO;

public class RegisterTest {

    /*
     * Tests if registerItem adds the item to soldItems list
     */
    @Test
    public void registerItemTest() {
        Sale testSale = new Sale();
        Register testRegister = new Register();
        ItemDescriptionDTO dto = new ItemDescriptionDTO(1, 1, 2);
        int quantity = 1;
        Sale registerSale = testRegister.registerItem(dto, quantity, testSale);
        Item testItem = new Item(dto, quantity);
        assertNotNull(registerSale);
        assertEquals(registerSale.getSoldItems().isEmpty(), false);
        assertEquals(testSale.getSoldItems().isEmpty(), false);
        assertEquals(registerSale.getSoldItems().contains(testItem), true);
    }

}
