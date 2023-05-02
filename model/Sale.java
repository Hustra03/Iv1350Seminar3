package model;

import java.util.ArrayList;
import java.util.List;

public class Sale {

	private List<Item> soldItems;

	private double totalPrice;

	private double totalVAT;

	private boolean itemFound;

	/*
	 * Creates a sale with null attributes execpt soldItems
	 * 
	 * @param firstItem represents the item added to list soldItems at sale
	 * creations
	 */
	public Sale(Item firstItem) {
		List<Item> soldItems;
		soldItems = new ArrayList<Item>();
		soldItems.add(firstItem);
		this.soldItems = soldItems;
		calculateRunningTotal();
		this.itemFound=false;
	}

	/*
	 * Creates a sale with null attributes
	 * 
	 */
	public Sale() {
		List<Item> soldItems = new ArrayList<Item>();
		this.soldItems = soldItems;
		calculateRunningTotal();
		this.itemFound=false;
	}

	/*
	 * Adds a new item to Sale and sets item found to true
	 * 
	 * @param sold represents the item to be added to sale
	 */
	void addItemInfo(Item sold) {
		this.soldItems.add(sold);
		this.itemFound = true;
	}

	/*
	 * This method merges any items with identical descriptions, ensuring only one
	 * of each type exists in the list
	 * 
	 * @param sold this object is the item which was added to the soldItems,
	 * and which is to be checked for and potentially merged if another exists
	 */
	// Update below to pricate, needs package for testing
	void itemMerger(Item soldItem) {
		if (soldItems.size() > 1 && soldItems.contains(soldItem)) {
			for (Item item : this.soldItems) {
				if ((item.getItemDescriptionDTO().getItemId() == soldItem.getItemDescriptionDTO().getItemId())
						&& (soldItems.indexOf(item) != soldItems.lastIndexOf(soldItem))) {
					item.increaseQuantity(soldItem.getQuantity());
					this.soldItems.remove(soldItems.lastIndexOf(soldItem));
					break;
				}
			}
		}
	}

	/*
	 * Updates runningTotals to represent current soldItems list
	 * 
	 */
	// Update below to pricate, needs package for testing
	void calculateRunningTotal() {
		this.totalPrice = 0;
		this.totalVAT = 0;
		for (Item item : this.soldItems) {
			this.totalPrice += item.getPriceForQuantity();
			this.totalVAT += item.getPriceForQuantity() * item.getItemDescriptionDTO().getVATrate() / 100;
		}
	}

	/*
	 * Sets the boolean itemFound to false
	 */
	public void setItemFoundFalse() {
		this.itemFound = false;
	}

	/*
	 * Returns the boolean itemFound to false
	 * 
	 * @return itemFound returns the bool representing if an item was found last
	 * registering attempt
	 */
	public boolean getItemFound() {
		return this.itemFound;
	}

	/*
	 * Returns the list of sold items
	 * 
	 * @return <code>soldItems</code>, represents the list of items sold in sale
	 */
	public List<Item> getSoldItems() {
		return this.soldItems;
	}

	/*
	 * Changes the List<item> soldItems to parameter
	 * 
	 * @parameter <code>soldItems</code>, represents the new list of items to be
	 * sold in sale
	 */
	public void setSoldItems(List<Item> soldItems) {
		this.soldItems = soldItems;
	}

	/*
	 * Returns the double TotalPrice
	 * 
	 * @return <code>TotalPrice</code>, represents the total price of sale
	 */
	public double getTotalPrice() {
		return this.totalPrice;
	}

	/*
	 * Returns the double TotalVAT
	 * 
	 * @return <code>TotalVAT</code>, represents the total value of VAT
	 */
	public double getTotalVAT() {
		return this.totalVAT;
	}
}
