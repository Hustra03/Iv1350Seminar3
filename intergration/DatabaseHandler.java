package intergration;

import model.Discount;
import model.Item;
import model.SaleInfo;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {

	private List<ItemDescriptionDTO> inventoryItems;

	private List<Discount> everyDiscount;

	/*
	 * Creates a new object of the DatabaseHandler class
	 * 
	 */
	public DatabaseHandler() {
		List<ItemDescriptionDTO> inventoryItems;	 
		inventoryItems= new ArrayList<ItemDescriptionDTO>();
		ItemDescriptionDTO DTO = new ItemDescriptionDTO(0, "name", 0, 0, "description");
		inventoryItems.add(DTO);

		this.inventoryItems=inventoryItems;

		List<Integer> applicableIds = new ArrayList<Integer>();
		List<Item> applicableItems = new ArrayList<Item>();
		int discountPercent = 0;
		int minimumItemAmount = 0;
		int minimumTotalPrice = 0;

		Discount discount = new Discount(discountPercent, applicableIds, applicableItems, minimumItemAmount, minimumTotalPrice);
		List<Discount> everyDiscount = new ArrayList<Discount>();	 
		everyDiscount.add(discount);
		this.everyDiscount=everyDiscount;

	}

	/*
	 * Returns the first item whose id matches the specified parameter
	 * 
	 * @param itemId this is the id which the database should be searched for
	 * 
	 * @return foundItem this is the itemDescriptionDTO returned to controller
	 */
	public ItemDescriptionDTO getItem(int itemId) {
		// ItemDescriptionDTO foundItem = new ItemDescriptionDTO();
		/*
		 * kod för att hitta item
		 * 
		 * findItem.invSystem
		 *
		 */

		// ItemDescriptionDTO foundItem = inventory.get(itemId);
		for (ItemDescriptionDTO foundItem : inventoryItems) {
			if (foundItem.getItemId() == itemId) {
				return foundItem;
			}
		}
		return null;
	}

	/*
	 * Returns the applicable discounts for the sale
	 * 
	 * @param saleInfo contains information about this sale
	 * 
	 * @param customerId the id for this customer
	 * 
	 * @return discountList the list of applicable discounts
	 */
	public List<Discount> findDiscount(SaleInfo saleInfo, int customerId) {

		List<Discount> discountList = new ArrayList<Discount>();
		for (Discount discount : everyDiscount) {
			if (discount.getApplicableId().contains(customerId)) {

				for (Item item : saleInfo.getSale().getSoldItems()) {
					if (discount.getApplicableItems().contains(item)) {
						if (saleInfo.getSale().getSoldItems().size() > discount.getMinimumItemAmount()) {
							if (saleInfo.getSale().getTotalPrice() > discount.getMinimumTotalPrice()) {
								discountList.add(discount);
							}
						}

					}
				}

			}
		}
		return discountList;
	}

	/* Below method would send saleInfo to external systems, but these are not included thus it is an empty method
	 * 
	 */
	public void sendSaleInfo(SaleInfo saleInfo) {

	}

}
