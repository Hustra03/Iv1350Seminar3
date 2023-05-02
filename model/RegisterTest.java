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
        assertEquals(false, registerSale.getSoldItems().isEmpty());
        assertEquals(false, testSale.getSoldItems().isEmpty());
        boolean identicalItemExists = false;
        for (Item item : registerSale.getSoldItems()) {
            if (item.getQuantity() == testItem.getQuantity()) {
                if (item.getItemDescriptionDTO() == testItem.getItemDescriptionDTO()) {
                    identicalItemExists=true;
                    break;
                }
            }
        }
        assertEquals(true, identicalItemExists);
    }

}
