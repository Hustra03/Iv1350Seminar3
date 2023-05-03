package intergration;

import model.Discount;
import model.Item;
import model.Receipt;
import model.SaleInfo;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {

	private List<ItemDescriptionDTO> inventoryItems;

	private List<Discount> everyDiscount;

	/*
	 * Creates a new object of the DatabaseHandler class, along with the list
	 * containing item information and discounts, representing the information which
	 * would be fetched from external systems, or rather a list containing a few
	 * objects of the same type.
	 * 
	 */
	public DatabaseHandler() {
		this.inventoryItems = createInventoryList();
		this.everyDiscount = createEveryDiscount();

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
					if (discount.getApplicableItemId().contains(item.getItemDescriptionDTO().getItemId())) {
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

	/*
	 * Below method would send saleInfo to external systems, but these are not
	 * included thus it is an empty method which would interact with these
	 * 
	 */

	public void sendSaleInfo(SaleInfo saleInfo, Receipt receipt) {

	}

	/*
	 * Creates the inventoryItems list along with each item
	 * 
	 * @return inventoryItems the list of items which the system can add to the sale
	 */
	private List<ItemDescriptionDTO> createInventoryList() {

		List<ItemDescriptionDTO> inventoryItems;
		inventoryItems = new ArrayList<ItemDescriptionDTO>();
		ItemDescriptionDTO DTO = new ItemDescriptionDTO(0, "Item 1", 1, 0, "Apple");
		inventoryItems.add(DTO);
		DTO = new ItemDescriptionDTO(1, "Item 2", 10, 10, "Banana");
		inventoryItems.add(DTO);
		DTO = new ItemDescriptionDTO(2, "Item 3", 30, 15, "Citrus");
		inventoryItems.add(DTO);
		DTO = new ItemDescriptionDTO(3, "Item 4", 50, 20, "Bred");
		inventoryItems.add(DTO);
		DTO = new ItemDescriptionDTO(4, "Item 5", 100, 50, "Milk");
		inventoryItems.add(DTO);
		DTO = new ItemDescriptionDTO(5, "Item 6", 25, 10, "Butter");
		inventoryItems.add(DTO);
		return inventoryItems;
	}

	/*
	 * Creates the everyDiscount list along with each discount
	 * 
	 * @return everyDiscount the list of discount which the system can add to the
	 * sale
	 */
	private List<Discount> createEveryDiscount() {

		List<Integer> applicableIds = new ArrayList<Integer>();
		List<Integer> applicableItemsId = new ArrayList<Integer>();
		int discountPercent = 0;
		int minimumItemAmount = 0;
		int minimumTotalPrice = 0;

		Discount discount = new Discount(discountPercent, applicableIds, applicableItemsId, minimumItemAmount,
				minimumTotalPrice);
		List<Discount> everyDiscount = new ArrayList<Discount>();
		everyDiscount.add(discount);

		return everyDiscount;
	}

}
