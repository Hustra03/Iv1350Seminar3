package intergration;

import model.Discount;
import model.SaleInfo;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {

	private ExternalInventorySystem invSystem;

	private ExternalAccountingSystem accSystem;

	private DiscountDatabase discDatabase;
	
	private List<ItemDescriptionDTO> inventoryItems;

	private List<Discount> everyDiscount;

	private SaleInfo saleInfo;

	/* Creates a new object of the DatabaseHandler class
	 * 
	 */
	public DatabaseHandler DatabaseHandler() {
		this.discDatabase = new DiscountDatabase();
		this.accSystem = new ExternalAccountingSystem();
		this.invSystem = new ExternalInventorySystem();

		List<ItemDescriptionDTO> inventoryItemsTemp= new ArrayList<ItemDescriptionDTO>();
		ItemDescriptionDTO tempDTO = new ItemDescriptionDTO(0, "name", 0, 0, "description");
		inventoryItemsTemp.add (tempDTO);
		this.inventoryItems=inventoryItemsTemp;

	    List<Discount> everyDiscountTemp=new ArrayList<Discount>();
		Discount tempDiscount = new Discount(0, 0, saleInfo);
		everyDiscountTemp.add (tempDiscount);
		this.everyDiscount=everyDiscountTemp;

		return null;
	}

	/* Returns the first item whose id matches the specified parameter
	 * @param itemId this is the id which the database should be searched for
	 * @return foundItem this is the itemDescriptionDTO returned to controller
	 */
	public ItemDescriptionDTO getItem(int itemId) {
		//ItemDescriptionDTO foundItem = new ItemDescriptionDTO();
		/* kod för att hitta item

		findItem.invSystem
		*
		*/


		// ItemDescriptionDTO foundItem = inventory.get(itemId);
		for (ItemDescriptionDTO foundItem : inventoryItems) {
			if(foundItem.getItemId()==itemId)
			{
				return foundItem;
			}	
		}
		ItemDescriptionDTO foundItem = new ItemDescriptionDTO();
		return foundItem;
	}

	public Discount findDiscount(SaleInfo saleInfo, int customerId) {
		return null;
	}

	public void sendSaleInfo(SaleInfo saleInfo) {

	}

}
