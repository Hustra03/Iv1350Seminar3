package model;

import org.junit.Test;

import intergration.ItemDescriptionDTO;

import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class RegisterTest {

    private Register testRegister;
    private Sale testSale;
    private Sale registerSale;
    private ItemDescriptionDTO dto;
    private ItemDescriptionDTO dto2;
    private int id;
    private int quantity;


    @Before
    public void setUp() {
        id = 2;
        testSale = new Sale();
        testRegister = new Register();
        dto = new ItemDescriptionDTO(id, 1, 2);
        dto2 = new ItemDescriptionDTO(id + 1, 1, 2);

        quantity = 1;
        registerSale = testRegister.registerItem(dto, quantity, testSale);
    }

    @After
    public void tearDown() {
        testRegister = null;
        testSale=null;
        registerSale=null;
        dto=null;
        dto2=null;
        id=0;
        quantity=0;
    }

    @Test
    public void registerItemTotalPriceTest() {
        assertNotNull(registerSale);
        assertEquals(registerSale.getSoldItems().isEmpty(), false);
        boolean foundItem = registerSale.getItemFromSaleItemId(registerSale, id);
        assertTrue("Item doesnt exist in the list of sold items", foundItem);
        assertTrue("Total Price not updated", registerSale.getTotalPrice() > 0);
        assertTrue("Total Price incorrect value", registerSale.getTotalPrice() == 1);
        assertTrue("Total Price both ==1 and ==2", registerSale.getTotalPrice() != 2);
        registerSale = testRegister.registerItem(dto, quantity, registerSale);
        assertTrue("Total Price incorrect value", registerSale.getTotalPrice() == 2);
        registerSale = testRegister.registerItem(dto2, quantity, registerSale);
        assertTrue("Total Price incorrect value", registerSale.getTotalPrice() == 3);

    }

    @Test
    public void registerItemSoldItemsTest() {
        assertFalse(registerSale.getSoldItems().isEmpty());
        assertTrue("Register Sale incorrect size, expected 1", registerSale.getSoldItems().size() == 1);
        assertTrue("Item quantity incorrect, expected 1", registerSale.getSoldItems().get(0).getQuantity() == 1);
        registerSale = testRegister.registerItem(dto, quantity, registerSale);
        assertTrue("Register Sale incorrect size, expected 1", registerSale.getSoldItems().size() == 1);
        assertTrue("Item quantity incorrect, expected 1", registerSale.getSoldItems().get(0).getQuantity() == 2);
        registerSale = testRegister.registerItem(dto2, quantity, registerSale);
        assertTrue("Register Sale incorrect size, expected 2", registerSale.getSoldItems().size() == 2);
    }
}
