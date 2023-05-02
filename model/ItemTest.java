package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import intergration.ItemDescriptionDTO;
import org.junit.Test;

public class ItemTest {

    /*
     * Tests that constructor creates an item
     */
    @Test
    public void ItemTest() {
		ItemDescriptionDTO dto= new ItemDescriptionDTO();
        Item item = new Item(dto,10);
        assertNotNull("Item Not Created",item);
	}
    /*
     * Tests that increaseQuantity changes quantity with specified amount
     */
    @Test
    public void increaseQuantityTest()
	{
        ItemDescriptionDTO dto= new ItemDescriptionDTO();
        Item item = new Item(dto,10);
        assertEquals("Quantity Not Equivilent",item.getQuantity(),10);
		item.increaseQuantity(10);
        assertEquals("Quantity Not Correctly Changed",item.getQuantity(),20);
	}

     /*
     * Tests that getQuantity returns correct quantity
     */
    @Test
    public void getQuantityTest()
	{
		ItemDescriptionDTO dto= new ItemDescriptionDTO();
        Item item = new Item(dto,10);
        assertEquals("Quantity Not Returned",item.getQuantity(),10);
	}

    /*
     * Tests that getItemDescriptionDTO returns correct ItemDescriptionDTO
     */
    @Test
	public void getItemDescriptionDTOTest()
	{
		ItemDescriptionDTO dto= new ItemDescriptionDTO();
        Item item = new Item(dto,10);
        assertEquals("Item Description Not Returned",item.getItemDescriptionDTO(),dto);
	}
}
