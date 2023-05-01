package model;

import intergration.CustomerPaymentDTO;

import java.time.LocalDate;

public class PaymentHandler {

	private CustomerPaymentDTO customerPayment;

	private LocalDate date;
	private long time;

	public PaymentHandler() {
	}

	/*
	 * Updates saleInfo with information about the payment
	 * 
	 * @param amountPayment represent the size of the payment
	 * 
	 * @param saleInfo contains information about the same, such as totalPrice
	 * 
	 * @return saleInfo represents the updated information about the sale,
	 * specifically with information in customerPayment
	 */
	public SaleInfo handlePayment(int amountPayment, SaleInfo saleInfo) {
		double totalPrice = saleInfo.getTotalPriceAfterDiscount();
		updateTimeAndDate();
		this.customerPayment = new CustomerPaymentDTO(amountPayment, amountPayment - totalPrice, time, date);
		saleInfo.updateSaleInfoPayment(customerPayment);
		return saleInfo;
	}

	/*
	 * Updates time and date with information from system
	 * 
	 */
	private void updateTimeAndDate() {

		this.time = System.currentTimeMillis();
		this.date = java.time.LocalDate.now();
	}

	public LocalDate getDate() {
		return this.date;
	}

	public long getTime() {
		return this.time;
	}

}
