package model;

import intergration.CustomerPaymentDTO;

public class SaleInfo {

	private Sale sale;

	private Discount recordedDiscounts;

	private CustomerPaymentDTO customerPayment;

	private double discountTotalPrice;

	private double discountTotalVAT;

	private Receipt receipt;

	public SaleInfo SaleInfo(Sale sale, Discount noDiscount) {
		return null;
	}

	public SaleInfo setDiscountAndCustomerId(Discount discountList, int customerId) {
		return null;
	}

	SaleInfo updateSaleInfoPayment(CustomerPaymentDTO customerPayment) {
		return null;
	 
	}

	int getTotalPriceAfterDiscount() {
		return 0;
	}

	private SaleInfo calculateTotalPriceAndVATAfterDiscount(Sale sale, Discount recordedDiscount) {
		return null;
	}

}
