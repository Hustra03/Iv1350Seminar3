package se.kth.iv1350.erikmichel.seminar3.controller;

import java.util.*; //For List to function

import se.kth.iv1350.erikmichel.seminar3.intergration.DatabaseHandler;
import se.kth.iv1350.erikmichel.seminar3.intergration.DiscountDTO;
import se.kth.iv1350.erikmichel.seminar3.model.PaymentHandler;
import se.kth.iv1350.erikmichel.seminar3.model.Register;
import se.kth.iv1350.erikmichel.seminar3.model.Sale;
import se.kth.iv1350.erikmichel.seminar3.model.SaleInfo;
import se.kth.iv1350.erikmichel.seminar3.intergration.ItemDescriptionDTO;
import se.kth.iv1350.erikmichel.seminar3.intergration.ItemLookUpException;
import se.kth.iv1350.erikmichel.seminar3.intergration.ReceiptDTO;
import se.kth.iv1350.erikmichel.seminar3.intergration.SaleDTO;
import se.kth.iv1350.erikmichel.seminar3.intergration.SaleInfoDTO;

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
		this.sale=null;
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
	 * @throws RegisterItemException if dbHandler can not find a specific item
	 */
	public SaleDTO registerItem(int itemId, int quantity) throws ItemLookUpException{
		ItemDescriptionDTO itemInfo = dbHandler.getItem(itemId);
		this.sale = register.registerItem(itemInfo, quantity, sale);
		
		return new SaleDTO(sale);
	}

	/*
	 * Ends sale and creates a SaleInfo based upon it
	 * 
	 */
	public SaleInfoDTO endSale() {
		this.saleInfo = new SaleInfo(sale);
		return new SaleInfoDTO(this.saleInfo);
	}

	/*
	 * Retrives the discount from database based on sale and customerId, and adds
	 * information to saleInfo
	 * 
	 * @param customerId is the id for the customer this sale belongs to
	 * 
	 */
	public SaleInfoDTO getDiscount(int customerId) {
		List<DiscountDTO> discountList = dbHandler.findDiscount(saleInfo, customerId);
		this.saleInfo.setDiscountAndCustomerId(discountList, customerId);
		return new SaleInfoDTO(this.saleInfo);
	}

	/*
	 * Updates saleInfo with information about customer payment
	 * 
	 * @amountPayment is the amount payed by customer for sale
	 */
	public SaleInfoDTO recivePayment(Double amountPayment) {
		this.saleInfo = paymentHandler.handlePayment(amountPayment, saleInfo);
		sendSaleInfo();
		this.register.increaseBalance(saleInfo.getCustomerPaymentDTO().getPaymentAmount());
		return new SaleInfoDTO(this.saleInfo);
	}

	/*
	 * Sends saleInfo to external systems and returns reciept
	 * 
	 */
	public ReceiptDTO sendSaleInfo() {
		ReceiptDTO receipt = new ReceiptDTO(saleInfo);
		this.dbHandler.sendSaleInfo(saleInfo, receipt);
		return receipt;
	}

	/* Returns sale from controller */
	public SaleDTO GetSale() {
		if(this.sale!=null)
		{return new SaleDTO(this.sale);}
		else
		{return null;}
	}

	/* Returns saleInfo from controller */
	public SaleInfoDTO GetSaleInfo() {
		return new SaleInfoDTO(saleInfo);
	}
}
