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

	/* Creates an SaleInfo object based upon a sale with an empty discount list and calculates discountTotalPrice and discountTotalVAT
	 * @param Sale is the sale object this saleInfo describes and becomes the sale attribute
	 */
	public SaleInfo(Sale sale) {
		this.sale = sale;
		List<Discount> recordedDiscounts = new ArrayList<Discount>();
		this.recordedDiscounts = recordedDiscounts;
		calculateTotalPriceAndVATAfterDiscount();
	}

	/* Replaces customerId and recordedDiscount attributes with respective parameters and recalculates discountTotalPrice and discountTotalVAT
	 * @param recordedDiscounts represents the list of discounts which will apply to this sale
	 * @param customerId represents the customerId of the customer this sale is made for/by/to
	 */
	public void setDiscountAndCustomerId(List<Discount> recordedDiscounts, int customerId) {
		this.customerId = customerId;
		this.recordedDiscounts = recordedDiscounts;
		calculateTotalPriceAndVATAfterDiscount();
	}

	/* Replaces customerPayment with the respective attribute
	 * @param customerPayment is the CustomerPaymentDTO which this 
	 */
	void updateSaleInfoPayment(CustomerPaymentDTO customerPayment) {
		this.customerPayment = customerPayment;
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
				double actualDiscount = 1;
				for (Discount discount : recordedDiscounts) {
					if (discount.getApplicableId().contains(item.getItemDescriptionDTO().getItemId())) {
						
						actualDiscount *= (100-(discount.getDiscountPercent()) / 100);
					}
				}
				this.discountTotalPrice += item.getPriceForQuantity() * actualDiscount;
				this.discountTotalVAT += this.discountTotalPrice * item.getItemDescriptionDTO().getVATrate() / 100;
			}
		} else {
			discountTotalPrice = sale.getTotalPrice();
			discountTotalVAT = sale.getTotalVAT();
		}
	}

	/*
	 * Returns discounted total price
	 * 
	 * @return discountTotalPrice represents the total price after every discount
	 * has been applied
	 */
	public double getTotalPriceAfterDiscount() {
		return this.discountTotalPrice;
	}

	/*
	 * Returns total Value Added Tax after discount
	 * 
	 * @return discountetTotalVAT represents the total VAT after every discount has
	 * been applied
	 */
	public double getTotalVATAfterDiscount() {
		return this.discountTotalVAT;
	}
	/*
	 * Returns the sale object this class describes
	 * 
	 * @return this.sale represents the sale this saleInfo should describe
	 */
	public Sale getSale() {
		return this.sale;
	}

	/*
	 * Returns the customerPayment included in this object and for the sale it
	 * describes
	 * 
	 * @return this.customerPayment represents the payment made by the customer along with
	 * information about it
	 */
	public CustomerPaymentDTO getCustomerPaymentDTO() {
		return this.customerPayment;
	}

	/*
	 * Returns the customerId included in this object and for the sale it
	 * describes
	 * 
	 * @return this.customerId represents the customerId for the customer this sale is for
	 */
	public int getCustomerId() {
		return this.customerId;
	}
/*
	 * Returns the recordedDiscounts included in this object and for the sale it
	 * describes
	 * 
	 * @return this.recordedDiscounts list of applicable discounts applied to this sale
	 */
	public List<Discount> getRecordedDiscounts() {
		return this.recordedDiscounts;
	}

}
