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

	private DatabaseHandler dbHandler;

	private PaymentHandler paymentHandler;

	private Register register;

	private Sale sale;

	private SaleInfo saleInfo;

	/*
	 * Creates a new object of the Controller class
	 * 
	 * @param dbHandler represents the <code>DatabaseHandler</code> responsible for
	 * handling external system access
	 * 
	 * @param time represents the time of sale initializatin
	 * 
	 * @param date represents the time of sale initializatin
	 */
	public Controller(DatabaseHandler dbHandler) {
		this.dbHandler = dbHandler;
		this.paymentHandler = new PaymentHandler();
		this.register = new Register();
	}

	/*
	 * Creates a new object of the Sale class in controller
	 */
	public void startSale() {

		this.sale = new Sale();
	}

	/*
	 * Tells other classes to register an item to sale
	 * 
	 * @param itemId represents the id of the item which should be registered
	 * 
	 * @param quantity represents the quantity of the above item to register
	 * 
	 * @return represents the sale items are registered to
	 */
	public Sale registerItem(int itemId, int quantity) {
		ItemDescriptionDTO itemInfo = dbHandler.getItem(itemId);
		this.sale = register.registerItem(itemInfo, quantity, sale);
		return this.sale;
	}

	/*
	 * Ends sale and creates a SaleInfo based upon it
	 * 
	 */
	public SaleInfo endSale() {
		this.saleInfo = new SaleInfo(sale);
		return saleInfo;
	}

	/*
	 * Retrives the discount from database based on sale and customerId, and adds
	 * information to saleInfo
	 * 
	 * 
	 */
	public SaleInfo getDiscount(int customerId) {
		List<Discount> discountList = dbHandler.findDiscount(saleInfo, customerId);
		this.saleInfo.setDiscountAndCustomerId(discountList, customerId);
		return this.saleInfo;
	}

	/*
	 * Updates saleInfo with information about customer payment
	 * 
	 */
	public SaleInfo recivePayment(int amountPayment) {
		this.saleInfo = paymentHandler.handlePayment(amountPayment, saleInfo);
		sendSaleInfo();
		this.register.increaseBalance(saleInfo.getCustomerPaymentDTO().getPaymentAmount());
		return this.saleInfo;
	}

	/*
	 * Sends saleInfo to external systems and returns reciept
	 * 
	 */
	public Receipt sendSaleInfo() {
		Receipt receipt = new Receipt(saleInfo);
		this.dbHandler.sendSaleInfo(saleInfo, receipt);
		return receipt;
	}

	/* Returns sale from controller */
	public Sale GetSale() {
		return this.sale;
	}
	/* Returns saleInfo from controller */
	public SaleInfo GetSaleInfo() {
		return this.saleInfo;
	}
}
