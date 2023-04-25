package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import intergration.ItemDescriptionDTO;
import model.Item;

public class ItemTest {

    /*
     * Tests that constructor creates an item
     */
    @Test
    public void ItemTest() {
		ItemDescriptionDTO dto= new ItemDescriptionDTO();
        Item item = new Item(dto,10);
        assertNotNull(item);
	}
    /*
     * Tests that increaseQuantity changes quantity with specified amount
     */
    @Test
    public void increaseQuantityTest()
	{
        ItemDescriptionDTO dto= new ItemDescriptionDTO();
        Item item = new Item(dto,10);
        assertEquals(item.getQuantity(),10);
		item.increaseQuantity(10);
        assertEquals(item.getQuantity(),20);
	}

     /*
     * Tests that getQuantity returns correct quantity
     */
    @Test
    public void getQuantityTest()
	{
		ItemDescriptionDTO dto= new ItemDescriptionDTO();
        Item item = new Item(dto,10);
        assertEquals(item.getQuantity(),10);
	}

    /*
     * Tests that getItemDescriptionDTO returns correct ItemDescriptionDTO
     */
    @Test
	public void getItemDescriptionDTOTest()
	{
		ItemDescriptionDTO dto= new ItemDescriptionDTO();
        Item item = new Item(dto,10);
        assertEquals(item.getItemDescriptionDTO(),dto);
	}
}
