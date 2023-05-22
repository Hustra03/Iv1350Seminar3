package se.kth.iv1350.erikmichel.seminar3.model;

import se.kth.iv1350.erikmichel.seminar3.intergration.CustomerPaymentDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.text.DateFormatter;

import java.util.ArrayList;

public class PaymentHandler {

	private CustomerPaymentDTO customerPayment;

	private String dateAndTime;
	private double totalRevenue;
	private List<TotalRevenueObserver> totalRevenueObservers = new ArrayList<>();

	public PaymentHandler() {
	}

	/*
	 * Updates saleInfo with information about the payment and notifies observers
	 * 
	 * @param amountPayment represent the size of the payment
	 * 
	 * @param saleInfo contains information about the same, such as totalPrice
	 * 
	 * @return saleInfo represents the updated information about the sale,
	 * specifically with information in customerPayment
	 */
	public SaleInfo handlePayment(Double amountPayment, SaleInfo saleInfo) {
		double totalPrice = saleInfo.getTotalPriceAfterDiscount();
		updateDateAndTime();
		this.customerPayment = new CustomerPaymentDTO(amountPayment, amountPayment - totalPrice, dateAndTime);
		saleInfo.updateSaleInfoPayment(customerPayment);
		totalRevenue+=amountPayment;
		notifyObservers();
		return saleInfo;
	}

	/*
	 * Notifies observers of current total revenue
	 */
	private void notifyObservers() {
		for (TotalRevenueObserver obs : totalRevenueObservers) {
			obs.totalRevenueUpdate(totalRevenue);
		}
	}

	/*
	 * Adds new total revenue observer to lis of observers
	 */
	public void addTotalRevenueObserver(TotalRevenueObserver obs) {
		totalRevenueObservers.add(obs);
	}

	/*
	 * Updates time and date with information from system
	 * 
	 */
	private void updateDateAndTime() {

		LocalDateTime dateAndTimeValue = java.time.LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		this.dateAndTime = dateAndTimeValue.format(myFormatObj);
	}

	/*
	 * Returns date and time of last update
	 * 
	 * @return dateAndTime is an object which contains information about time and
	 * date
	 */
	public String getDateAndTime() {
		return this.dateAndTime;
	}

}
