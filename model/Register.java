package model;

import intergration.ExternalInventorySystem;
import intergration.ItemDescriptionDTO;
import model.Item;
import model.Sale;

public class Register {

	private Sale sale;

	private ExternalInventorySystem externalInventorySystem;

	private Item item;

	public Register() 
	{
	}

	public Sale registerItem(ItemDescriptionDTO foundItem, int quantity, Sale sale) {
		Item foundActualItem = new Item(foundItem, quantity);
		sale.addItem(foundActualItem);
		return sale;
	}

}
