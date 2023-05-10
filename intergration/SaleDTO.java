package intergration;
import model.Item;
import model.Sale;
import java.util.List;

public class SaleDTO {
    

	private List<Item> soldItems;

	private double totalPrice;

	private double totalVAT;

	private boolean itemFound;
    /*
	 * Creates a sale with empty attributes
	 * 
	 */
	public SaleDTO(Sale sale) {
		this.soldItems=sale.getSoldItems();
        this.totalPrice=sale.getTotalPrice();
        this.totalVAT=sale.getTotalVAT();
        this.itemFound=sale.getItemFound();
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
