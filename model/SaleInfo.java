package model;

import intergration.CustomerPaymentDTO;
import java.util.ArrayList;
import java.util.List;

public class SaleInfo {

	private Sale sale;

	private List<Discount> recordedDiscounts;

	private CustomerPaymentDTO customerPayment;

	private double discountTotalPrice;

	private double discountTotalVAT;

	private int customerId;

	public SaleInfo(Sale sale) {
		this.sale = sale;
		List<Discount> recordedDiscounts = new ArrayList<Discount>();
		this.recordedDiscounts = recordedDiscounts;
		calculateTotalPriceAndVATAfterDiscount();
	}

	public void setDiscountAndCustomerId(List<Discount> recordedDiscounts, int customerId) {
		this.customerId = customerId;
		this.recordedDiscounts = recordedDiscounts;
		calculateTotalPriceAndVATAfterDiscount();
	}

	void updateSaleInfoPayment(CustomerPaymentDTO customerPayment) {
		this.customerPayment = customerPayment;
	}

	/*
	 * Returns discounted total price
	 * 
	 * @return discountTotalPrice represents the total price after every discount
	 * has been applied
	 */
	double getTotalPriceAfterDiscount() {
		return this.discountTotalPrice;
	}

	/*
	 * Returns total Value Added Tax after discount
	 * 
	 * @return discountetTotalVAT represents the total VAT after every discount has
	 * been applied
	 */
	double getTotalVATAfterDiscount() {
		return this.discountTotalVAT;
	}

	/*
	 * This method updates discountTotalPrice and discountTotalVAT for sale based on
	 * current discount
	 * 
	 */
	private void calculateTotalPriceAndVATAfterDiscount() {
		if (!recordedDiscounts.isEmpty()) {
			List<Item> soldItems = sale.getSoldItems();
			this.discountTotalPrice = 0;
			this.discountTotalVAT = 0;
			for (Item item : soldItems) {
				double actualDiscount = 0;
				for (Discount discount : recordedDiscounts) {
					if (discount.getApplicableId().contains(item.getItemDescriptionDTO().getItemId())) {
						if (actualDiscount == 0) {
							actualDiscount += discount.getDiscountPercent() / 100;
						}
					} else {
						actualDiscount *= discount.getDiscountPercent() / 100;
					}
				}
				this.discountTotalPrice += item.getPriceForQuantity() * actualDiscount;
				this.discountTotalVAT += item.getPriceForQuantity() * actualDiscount
						* item.getItemDescriptionDTO().getVATrate() / 100;
			}
		}
	}

	{
		discountTotalPrice = sale.getTotalPrice();
		discountTotalVAT = sale.getTotalVAT();
	}

	/*
	 * Returns the sale object this class describes
	 * 
	 * @this.sale represents the sale this saleInfo should describe
	 */
	public Sale getSale() {
		return this.sale;
	}

	/*
	 * Returns the customerPayment included in this object and for the sale it
	 * describes
	 * 
	 * @this.customerPayment represents the payment made by the customer along with
	 * information about it
	 */
	public CustomerPaymentDTO getCustomerPaymentDTO() {
		return this.customerPayment;
	}

}
