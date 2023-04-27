package controller;

import java.util.*; //For List to function


import intergration.DatabaseHandler;
import model.PaymentHandler;
import model.Register;
import model.Sale;
import model.Discount;
import model.SaleInfo;
import model.Receipt;
import intergration.ItemDescriptionDTO;

public class Controller {

	private DatabaseHandler databaseHandler;

	private PaymentHandler paymentHandler;

	private Register register;

	private Sale sale;

	private SaleInfo saleInfo;

	private Receipt receipt;

	
	/* Creates a new object of the Controller class
	 * @param dbHandler represents the <code>DatabaseHandler</code> responsible for handling external system access
	 * @param time represents the time of sale initializatin
	 * @param date represents the time of sale initializatin
	 */
	public Controller (DatabaseHandler dbHandler, int time, int date) {
		this.databaseHandler=dbHandler;
		this.paymentHandler = new PaymentHandler();
		this.register = new Register();
	}
	
	/*
	 * Creates a new object of the Sale class in controller
	 */
	public void startSale() {
		
		this.sale = new Sale();
	}

	/* Tells other classes to register an item to sale
	 * @param itemId represents the id of the item which should be registered
	 * @param quantity represents the quantity of the above item to register
	 * @return represents the sale items are registered to
	 */
	public Sale registerItem(int itemId, int quantity) {
		ItemDescriptionDTO itemInfo= databaseHandler.getItem(itemId);
		register.registerItem(itemInfo, quantity, sale);
		return sale;
	}

	/* Ends sale and creates a SaleInfo based upon it
	 * 
	 */
	public SaleInfo endSale() {
		
		List<Discount> noDiscount = new ArrayList<Discount>();
		Discount discount=new Discount();
		noDiscount.add(0, discount);
		SaleInfo saleInfo = new SaleInfo();
		return saleInfo;
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
