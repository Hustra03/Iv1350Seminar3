package model;


import java.util.ArrayList;
import java.util.List;

public class Discount {

	private int discountPercent;

	private List<Integer> applicableIds;

	private List<Item> applicableItems;

	private int minimumItemAmount;

	private int minimumTotalPrice;

	public Discount(int discountPercent,  List<Integer> applicableId, List<Item> applicableItems,int minimumItemAmount,int minimumTotalPrice ) {
		this.discountPercent=discountPercent;
		this.applicableIds=applicableId;
		this.applicableItems = applicableItems;
		this.minimumItemAmount=minimumItemAmount;
		this.minimumTotalPrice=minimumTotalPrice;
	}

	public Discount() {
		this.discountPercent=0;
	}

	/* Returns the discount percent
	 * @return discountPercent percentage discount of this discount
	 */
	public int getDiscountPercent() {
		return this.discountPercent;
	}
	/* Returns the list of applicable ids for this discount
	 * @return applicableIds is the list of applicable ids
	 */
	public List<Integer> getApplicableId() {
		return this.applicableIds;
	}
	/* Returns the discount this discount operates on
	 * @return saleInfo contains information about this discount
	 */
	public  List<Item> getApplicableItems() {
		return this.applicableItems;
	}
	public int getMinimumItemAmount() {
		return this.minimumItemAmount;
	}
	public int getMinimumTotalPrice() {
		return this.minimumTotalPrice;
	}

	
}
