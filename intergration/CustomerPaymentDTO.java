package intergration;


import java.time.LocalDate;

public class CustomerPaymentDTO {

	private double paymentAmount;

	private double change;

	private LocalDate date;

	private long time;

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
	public CustomerPaymentDTO(int amountPayment, double change, long time, LocalDate date) {
		this.paymentAmount = amountPayment;
		this.change = change;
		this.time = time;
		this.date = date;
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
	 * Returns objects time
	 * 
	 * @return time represents time of payment
	 */
	public long getTime() {
		return this.time;
	}

	/*
	 * Returns objects date
	 * 
	 * @return date represents date of payment
	 */
	public LocalDate getDate() {
		return this.date;
	}
}
