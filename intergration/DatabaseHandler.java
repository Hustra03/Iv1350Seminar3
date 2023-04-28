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
		//ItemDescriptionDTO foundItem = new ItemDescriptionDTO();
		/* kod för att hitta item

		findItem.invSystem
		*
		*/


		// ItemDescriptionDTO foundItem = inventory.get(itemId);

		return;
	}

	public Discount findDiscount(SaleInfo saleInfo, int customerId) {
		return null;
	}

	public void sendSaleInfo(SaleInfo saleInfo) {

	}

}
