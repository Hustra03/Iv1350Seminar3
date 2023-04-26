package intergration;

import model.Discount;
import model.SaleInfo;

public class DatabaseHandler {

	private ExternalInventorySystem invSystem;

	private ExternalAccountingSystem accSystem;

	private DiscountDatabase discDatabase;

	private SaleInfo saleInfo;

	public DatabaseHandler DatabaseHandler() {
		this.discDatabase = new DiscountDatabase();
		this.accSystem = new ExternalAccountingSystem();
		this.invSystem = new ExternalInventorySystem();
		return null;
	}

	public ItemDescriptionDTO getItem(int itemId) {
		return null;
	}

	public Discount findDiscount(SaleInfo saleInfo, int customerId) {
		return null;
	}

	public void sendSaleInfo(SaleInfo saleInfo) {

	}

}
