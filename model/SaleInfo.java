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

	public SaleInfo(Sale sale, Discount noDiscount) {
		this.sale=sale;
		List<Discount> recordedDiscounts=new ArrayList<Discount>();
		recordedDiscounts.add(noDiscount);
		this.recordedDiscounts=recordedDiscounts;
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

	public Sale getSale()
	{return this.sale;}

}
