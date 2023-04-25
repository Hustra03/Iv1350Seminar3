package model;

import intergration.ItemDescriptionDTO;

public class Item {

	private ItemDescriptionDTO item;

	private int quantity;

	/* Creates an object of item class
	 * @param foundItem this itemDescriptionDTO contains all information about one instance of this object
	 * @param quantity represents how many of this item exists
	 */
	public Item(ItemDescriptionDTO foundItem, int quantity) {
		this.item=foundItem;
		this.quantity=quantity;
	}

	/* Increases quantity with specified amount
	 * @param amountChange represents how much <code>quantity</code> will increase
	 */
	public void increaseQuantity(int amountChange)
	{
		this.quantity = this.quantity+amountChange;
	}

	/* Returns this specific items quantity
	 * @return this.quantity returns the amount of items represented by int <code>quantity</code>
	 */
	public int getQuantity()
	{
		return this.quantity;
	}

	/* Returns this specific items itemDescriptionDTO
	 * @return this.item returns the information about the item represented by itemDescriptionDTO <code>item</code>
	 */
	public ItemDescriptionDTO getItemDescriptionDTO()
	{
		return this.item;
	}

	/* Returns this specific items itemDescriptionDTO
	 * @return quantityPrice returns the information about the price for a quantity of items 
	 */
	public double getPriceForQuantity()
	{
		double quantityPrice = this.quantity*this.getItemDescriptionDTO().getPrice();
		return quantityPrice;
	}
}
