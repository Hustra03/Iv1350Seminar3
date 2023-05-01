package model;


import java.time.LocalDate;

import java.util.*; //For List to function

public class Receipt {

	private long time;

	private LocalDate date;

	private List<Item> soldItems;

	private double totalPrice;

	private double totalVAT;

	private double totalPayment;

	private double totalChange;

	public Receipt(SaleInfo saleInfo) {
		this.time = saleInfo.getCustomerPaymentDTO().getTime();
		this.date = saleInfo.getCustomerPaymentDTO().getDate();
		this.soldItems = saleInfo.getSale().getSoldItems();
		this.totalPrice = saleInfo.getTotalPriceAfterDiscount();
		this.totalVAT = saleInfo.getTotalVATAfterDiscount();
		this.totalPayment = saleInfo.getCustomerPaymentDTO().getPaymentAmount();
		this.totalChange = saleInfo.getCustomerPaymentDTO().getChange();
	}

}
