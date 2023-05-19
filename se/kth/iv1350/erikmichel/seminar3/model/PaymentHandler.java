package se.kth.iv1350.erikmichel.seminar3.model;

import se.kth.iv1350.erikmichel.seminar3.intergration.CustomerPaymentDTO;
import se.kth.iv1350.erikmichel.seminar3.view.TotalRevenueFileOutput;
import se.kth.iv1350.erikmichel.seminar3.view.TotalRevenueView;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class PaymentHandler {

	private CustomerPaymentDTO customerPayment;

	private LocalDateTime dateAndTime;
	private double totalRevenue;
	private List<TotalRevenueObserver> totalRevenueObservers = new ArrayList<>();

	public PaymentHandler() {
		
		totalRevenueObservers.add(new TotalRevenueView());
		totalRevenueObservers.add(new TotalRevenueFileOutput());
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

		this.dateAndTime = java.time.LocalDateTime.now();
	}

	/*
	 * Returns date and time of last update
	 * 
	 * @return dateAndTime is an object which contains information about time and
	 * date
	 */
	public LocalDateTime getDateAndTime() {
		return this.dateAndTime;
	}

}
