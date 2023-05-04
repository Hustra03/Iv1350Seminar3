package intergration;


import java.time.LocalDateTime;

public class CustomerPaymentDTO {

	private double paymentAmount;

	private double change;

	private LocalDateTime dateAndTime;


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
	public CustomerPaymentDTO(int amountPayment, double change, LocalDateTime dateAndTime) {
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
	public LocalDateTime getDate() {
		return this.dateAndTime;
	}
}
