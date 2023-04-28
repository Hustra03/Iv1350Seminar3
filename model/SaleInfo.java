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

	private Receipt receipt;

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

	SaleInfo updateSaleInfoPayment(CustomerPaymentDTO customerPayment) {
		return null;

	}

	/*
	 * Returns iscounted total price
	 * 
	 * @return discountTotalPrice represents the total price after every discount
	 * has been applied
	 */
	double getTotalPriceAfterDiscount() {
		return this.discountTotalPrice;
	}

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
				this.discountTotalPrice += item.getPriceForQuantity() * actualDiscount
						* item.getItemDescriptionDTO().getVATrate() / 100;
			}
		}
	}

	{
		discountTotalPrice = sale.getTotalPrice();
		discountTotalVAT = sale.getTotalVAT();
	}
	}

	public Sale getSale() {
		return this.sale;
	}

}
