package model;
import java.util.*;  //For List to function

import intergration.ItemDescriptionDTO;

public class Sale {

	private List<Item> soldItems;

	private double totalPrice;

	private double totalVAT;

	private boolean itemFound;

	public Sale() 
	{
		
	}

	void addItemInfo(Item sold) 
	{
		soldItems.add(sold);
		itemMerger(sold);
		calculateRunningTotal();
	}

	/*
	 * This method merges any items with identical descriptions, ensuring only one of each type exists in the list
	 * 
	 * @param sold this object is the item which was added to the soldItems, 
	 * and which is to be checked for and potentially merged if another exists 
	 */
	private void itemMerger(Item soldItem) {
		for (Item item : this.soldItems)
		{
			if(item.getItemDescriptionDTO()==soldItem.getItemDescriptionDTO())
			{
				item.increaseQuantity(soldItem.getQuantity());
				this.soldItems.remove(soldItem);
				break;
			}
		}
	}

	/* Updates runningTotals to represent current soldItems list
	 * 
	 */
	private void calculateRunningTotal() {
		this.totalPrice=0;
		this.totalVAT=0;
		for (Item item : this.soldItems)
		{
			this.totalPrice+=item.getPriceForQuantity();
			this.totalVAT+=item.getPriceForQuantity() * item.getItemDescriptionDTO().getVATrate() / 100;
		}
	}

	/*Sets the boolean itemFound to false
	 * 
	 */
	public void setItemFoundFalse() {
		this.itemFound=false;
	}

	/* Returns the boolean itemFound
	 * 
	 * @return <code>itemFound</code>, 
	 */
	public boolean getItemFound()
	{return this.itemFound;}
	/* Returns the List<item> soldItems
	 * 
	 * @return <code>itemFound</code>, 
	 */
	public List<Item> getSoldItems()
	{return this.soldItems;}
}
