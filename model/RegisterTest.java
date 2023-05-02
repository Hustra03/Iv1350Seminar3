package model;

import org.junit.Test;

import intergration.ItemDescriptionDTO;

import static org.junit.Assert.*;

public class RegisterTest {

    /*
     * Tests if registerItem adds the item to soldItems list
     */
    @Test
    public void registerItemTest() {
        int id = 33;
        Sale testSale = new Sale();
        Register testRegister = new Register();
        ItemDescriptionDTO dto = new ItemDescriptionDTO(id, 1, 2);
        int quantity = 1;
        Sale registerSale = testRegister.registerItem(dto, quantity, testSale);
        Item testItem = new Item(dto, quantity);
        assertNotNull(registerSale);
        assertEquals(registerSale.getSoldItems().isEmpty(), false);
        assertEquals(testSale.getSoldItems().isEmpty(), false);
        boolean expected = true;
        boolean foundItem = registerSale.getItemFromSaleItemId( registerSale,id);
        assertTrue("Varan finns inte med i listan över sålda varor", foundItem);
    }

}
