package model;

import intergration.CustomerPaymentDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

public class PaymentHandler {

	private CustomerPaymentDTO customerPayment;

	private LocalDate date;
	private long time;



	public PaymentHandler() {
	}

	public SaleInfo handlePayment(int amountPayment, SaleInfo saleInfo) {
		double totalPrice = saleInfo.getTotalPriceAfterDiscount();
		updateTimeAndDate();
		this.customerPayment= new CustomerPaymentDTO(amountPayment,amountPayment-totalPrice,time,date);
		saleInfo.updateSaleInfoPayment(customerPayment);
		return saleInfo;
	}

	private void updateTimeAndDate() {

		this.time = System.currentTimeMillis();
		this.date = java.time.LocalDate.now();
	}

}
