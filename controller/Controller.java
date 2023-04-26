package controller;

import intergration.DatabaseHandler;
import model.PaymentHandler;
import model.Register;
import model.Sale;
import model.Discount;
import model.SaleInfo;
import model.Receipt;

public class Controller {

	private DatabaseHandler databaseHandler;

	private PaymentHandler paymentHandler;

	private Register register;

	private Sale sale;

	private Discount discount;

	private SaleInfo saleInfo;

	private Receipt receipt;

	
	/*
	 * 
	 */
	public Controller (DatabaseHandler dbHandler, int time, int date) {
		this.databaseHandler=databaseHandler;
		this.paymentHandler = new PaymentHandler();
		this.register = new Register();
	}
	
	/*
	 * Creates a new object of the Sale class
	 */
	public void startSale() {
		
		this.sale = new Sale();
	}

	public Sale registerItem(int itemId, int quantity) {
		return null;
	}

	public SaleInfo endSale() {
		return null;
	}

	public SaleInfo getDiscount(int customerId) {
		return null;
	}

	public SaleInfo recivePayment(int amountPayment) {
		return null;
	}

	public void sendSaleInfo() {

	}
	
	public Sale GetSale()
	{return this.sale;}
}
