package se.kth.iv1350.erikmichel.seminar3.intergration;


import java.time.LocalDateTime;

public class CustomerPaymentDTO {

	private double paymentAmount;

	private double change;

	private String dateAndTime;


	/*
	 * Creates an empty CustomerPaymentDTO object
	 * 
	 */
	public CustomerPaymentDTO() {

	}

	/*
	 * Creates an CustomerPaymentDTO object with parameter attributes
	 * 
	 * @param amountPayment represents the amount of payment given to
	 * 
	 * @param change represents the diffrence in totalPrice and amountPayment
	 * 
	 * @param time represents time of payment
	 * 
	 * @param date represents date of payment
	 */
	public CustomerPaymentDTO(double amountPayment, double change, String dateAndTime) {
		this.paymentAmount = amountPayment;
		this.change = change;
		this.dateAndTime = dateAndTime;
	}

	/*
	 * Returns objects paymentAmount
	 * 
	 * @return paymentAmount represents the amount of payment given to
	 */
	public double getPaymentAmount() {
		return this.paymentAmount;
	}

	/*
	 * Returns objects change
	 * 
	 * @return change represents the diffrence in totalPrice and amountPayment
	 */
	public double getChange() {
		return this.change;
	}


	/*
	 * Returns objects date
	 * 
	 * @return date represents date of payment
	 */
	public String getDateAndTime() {
		return this.dateAndTime;
	}
}
