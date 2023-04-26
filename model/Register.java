package model;

import intergration.ExternalInventorySystem;
import intergration.ItemDescriptionDTO;
import model.Item;
import model.Sale;

public class Register {

	private Sale sale;

	/*
	 * Creates a new empty object of the Register class
	 * 
	 */
	public Register() {
	}

	/*
	 * Registers ,or adds information about, a specified item to a sale
	 * 
	 * @param foundItem is the ItemDescriptionDTO fetched from
	 * ExternalInventoryDatabase by DatabaseHandler, in turn fetched by Controller
	 * 
	 * @param quantity specifies how many of this item should be added to the sale
	 * 
	 * @param saleIn is the sale the item should be added to
	 * 
	 * @return sale is the sale the item has been added to
	 */
	public Sale registerItem(ItemDescriptionDTO foundItem, int quantity, Sale saleIn) {

		this.sale = saleIn;
		if (foundItem != null) {
			Item foundActualItem = new Item(foundItem, quantity);
			sale.addItemInfo(foundActualItem);
			sale.itemMerger(foundActualItem);
			sale.calculateRunningTotal();
		}
		return sale;
	}

	/*
	 * Returns sale attribute
	 * 
	 * @param this.sale is the attribute sale, representing the sale currently being
	 * operated on by register
	 */
	public Sale getSale() {
		return this.sale;
	}

}
