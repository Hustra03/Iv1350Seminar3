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
        ItemDescriptionDTO dto2 = new ItemDescriptionDTO(id + 1, 1, 2);

        int quantity = 1;
        Sale registerSale = testRegister.registerItem(dto, quantity, testSale);
        assertNotNull(registerSale);
        assertEquals(registerSale.getSoldItems().isEmpty(), false);
        boolean expected = true;
        boolean foundItem = registerSale.getItemFromSaleItemId(registerSale, id);
        assertTrue("Varan finns inte med i listan över sålda varor", foundItem);
        assertTrue("Total Price not updated", registerSale.getTotalPrice() > 0);
        assertTrue("Total Price incorrect value", registerSale.getTotalPrice() == 1);
        assertTrue("Total Price both ==1 and ==2", registerSale.getTotalPrice() != 2);

        assertTrue("Register Sale incorrect size, expected 1", registerSale.getSoldItems().size() == 1);
        assertTrue("Item quantity incorrect, expected 1", registerSale.getSoldItems().get(0).getQuantity() == 1);

        registerSale = testRegister.registerItem(dto, quantity, registerSale);
        assertTrue("Register Sale incorrect size, expected 1", registerSale.getSoldItems().size() == 1);
        assertTrue("Item quantity incorrect, expected 1", registerSale.getSoldItems().get(0).getQuantity() == 2);
        assertTrue("Total Price incorrect value", registerSale.getTotalPrice() == 2);

        registerSale = testRegister.registerItem(dto2, quantity, registerSale);
        assertTrue("Register Sale incorrect size, expected 2", registerSale.getSoldItems().size() == 2);
        assertTrue("Total Price incorrect value", registerSale.getTotalPrice() == 3);

    }

}
