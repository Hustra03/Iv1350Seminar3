package intergration;
import java.util.*; //For List to function
import model.SaleInfo;


class ExternalInventorySystem { //skall vara paketprivat enligt DM, därmed minskas det publika gränsnittet

	private List<ItemDescriptionDTO> completeItemList;

	ExternalInventorySystem ExternalInventorySystem() {
		return null;
	}

	ItemDescriptionDTO findItem(int itemId) {
			// method implementation goes here
			// ...
			// create and return a foundItem object
			ItemDescriptionDTO foundItem = completeItemList.get(itemId);
    return foundItem;
	}
	void reciveSaleInfo(SaleInfo saleInfo) {

	}

}
