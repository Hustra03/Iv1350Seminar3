package model;

import intergration.ExternalInventorySystem;
import intergration.ItemDescriptionDTO;
import model.Item;
import model.Sale;

public class Register {

	private Sale sale;

	/* Creates a new empty object of the Register class
	 * 
	 */
	public Register() 
	{
	}

	/* Registers ,or adds information about, a specified item to a sale
	 * @param foundItem
	 * @param quantity
	 * @param saleIn
	 * @return sale
	 */
	public Sale registerItem(ItemDescriptionDTO foundItem, int quantity, Sale saleIn) {
		this.sale = saleIn;
		Item foundActualItem = new Item(foundItem, quantity);
		sale.addItemInfo(foundActualItem);
		sale.itemMerger(foundActualItem);
		sale.calculateRunningTotal();
		return sale;
	}

	/* Returns sale attribute
	 * @param this.sale is the attribute sale, representing the sale currently being operated on by register
	 */
	public Sale getSale()
	{
		return this.sale;
	}

}
