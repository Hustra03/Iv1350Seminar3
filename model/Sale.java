package model;

import java.util.*; //For List to function

import intergration.ItemDescriptionDTO;

public class Sale {

	private List<Item> soldItems;

	private double totalPrice;

	private double totalVAT;

	private boolean itemFound;

	public Sale(Item firstItem) {
		List<Item> soldItems = new ArrayList<Item>();
		soldItems.add(firstItem);
		this.soldItems = soldItems;
	}

	public Sale() {
		List<Item> soldItems = new ArrayList<Item>();
		this.soldItems = soldItems;
	}

	void addItemInfo(Item sold) {
		soldItems.add(sold);
		setSoldItems(soldItems);
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
				if (item.getItemDescriptionDTO() == soldItem.getItemDescriptionDTO() && (soldItems.indexOf(item) != soldItems.indexOf(soldItem))) {
					item.increaseQuantity(soldItem.getQuantity());
					soldItems.remove(soldItems.lastIndexOf(soldItem));
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
	 * 
	 */
	public void setItemFoundFalse() {
		this.itemFound = false;
	}

	/*
	 * Returns the boolean itemFound
	 * 
	 * @return <code>itemFound</code>,
	 */
	public boolean getItemFound() {
		return this.itemFound;
	}

	/*
	 * Returns the List<item> soldItems
	 * 
	 * @return <code>soldItems</code>,
	 */
	public List<Item> getSoldItems() {
		return this.soldItems;
	}

	/*
	 * Changes the List<item> soldItems to parameter
	 * 
	 * @parameter <code>soldItems</code>,
	 */
	public void setSoldItems(List<Item> soldItems) {
		this.soldItems = soldItems;
	}

	/*
	 * Returns the double TotalPrice
	 * 
	 * @return <code>TotalPrice</code>,
	 */
	public double getTotalPrice() {
		return this.totalPrice;
	}

	/*
	 * Returns the double TotalVAT
	 * 
	 * @return <code>TotalVAT</code>,
	 */
	public double getTotalVAT() {
		return this.totalVAT;
	}
}
