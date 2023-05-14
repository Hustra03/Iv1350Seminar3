package se.kth.iv1350.erikmichel.seminar3.intergration;

import se.kth.iv1350.erikmichel.seminar3.model.Item;
import se.kth.iv1350.erikmichel.seminar3.model.Register;
import se.kth.iv1350.erikmichel.seminar3.model.SaleInfo;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {

	private List<ItemDescriptionDTO> inventoryItems;

	private List<DiscountDTO> everyDiscount;

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
	public ItemDescriptionDTO getItem(int itemId) throws ItemLookUpException {

		for (ItemDescriptionDTO foundItem : inventoryItems) {

			if (foundItem.getItemId() == itemId) {
				return foundItem;
			}

		}
		throw new ItemLookUpException(
				"Item Not Found In Database, refer to list created in database contructor for full list of itemid which should be valid",
				itemId);
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
	public List<DiscountDTO> findDiscount(SaleInfo saleInfo, int customerId) {

		List<DiscountDTO> discountList = new ArrayList<DiscountDTO>();
		for (DiscountDTO discount : everyDiscount) {
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

	public void sendSaleInfo(SaleInfo saleInfo, ReceiptDTO receipt) {

	}

	/*
	 * Creates the inventoryItems list along with each item
	 * 
	 * @return inventoryItems the list of items which the system can add to the sale
	 */
	private List<ItemDescriptionDTO> createInventoryList() {

		List<ItemDescriptionDTO> inventoryItems;
		inventoryItems = new ArrayList<ItemDescriptionDTO>();
		ItemDescriptionDTO DTO = new ItemDescriptionDTO(0, "Apple", 1, 0, "A number of Apple(s)");
		inventoryItems.add(DTO);
		DTO = new ItemDescriptionDTO(1, "Banana", 10, 10, "A bunch of Banana(s)");
		inventoryItems.add(DTO);
		DTO = new ItemDescriptionDTO(2, "Citrus", 30, 15, "A flock of Citrus");
		inventoryItems.add(DTO);
		DTO = new ItemDescriptionDTO(3, "Bread", 50, 20, "LoafBread");
		inventoryItems.add(DTO);
		DTO = new ItemDescriptionDTO(4, "Milk", 100, 50, "Milk Carton");
		inventoryItems.add(DTO);
		DTO = new ItemDescriptionDTO(5, "Butter", 25, 10, "ButterStick Knockback 2");
		inventoryItems.add(DTO);
		return inventoryItems;
	}

	/*
	 * Creates the everyDiscount list along with each discount
	 * 
	 * @return everyDiscount the list of discount which the system can add to the
	 * sale
	 */
	private List<DiscountDTO> createEveryDiscount() {

		List<Integer> applicableIds = new ArrayList<Integer>();
		applicableIds.add(1);
		applicableIds.add(2);
		applicableIds.add(3);
		List<Integer> applicableItemsId = new ArrayList<Integer>();
		applicableIds.add(1);
		int discountPercent = 0;
		int minimumItemAmount = 0;
		int minimumTotalPrice = 0;

		DiscountDTO discount = new DiscountDTO(discountPercent, applicableIds, applicableItemsId, minimumItemAmount,
				minimumTotalPrice);
		List<DiscountDTO> everyDiscount = new ArrayList<DiscountDTO>();
		everyDiscount.add(discount);

		return everyDiscount;
	}

}
