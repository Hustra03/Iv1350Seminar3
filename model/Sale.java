package model;

import intergration.ItemDescriptionDTO;

public class Sale {

	private ItemDescriptionDTO soldItems;

	private double totalPrice;

	private double totalVAT;

	private boolean itemFound;

	public Sale Sale() {
		return null;
	}

	Sale addItemInfo(Item sold) {
		return null;
	}

	private Item itemMerger(Item sold, Item soldItems) {
		return null;
	}

	private Sale calculateRunningTotal(Item soldItems) {
		return null;
	}

	public void setItemFoundFalse(Sale sale) {
		return null;
	}

	public boolean getItemFound()
	{return this.itemFound;}
}
