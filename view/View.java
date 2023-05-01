package view;

import controller.Controller;

public class View {

	private Controller controller;

	public View(Controller controller) {
		this.controller = controller;
	}

	/*
	 * Starts system operation to start Sale
	 * 
	 */
	public void StartSale() {
		controller.startSale();
	}

	/*
	 * Starts system operation to register an item
	 * 
	 */
	public void registerItem() {
		controller.registerItem(0, 0);
	}

	/*
	 * Starts system operation to stop registering items, or end while loop
	 * 
	 */
	public void endSale() {
		controller.endSale();
	}

	/*
	 * Starts system operation to get and apply discount to sale
	 * 
	 */
	public void getDiscount() {
		controller.getDiscount(0);
	}

	public void recivePaymentAndSendSaleInfo() {
		controller.recivePayment(0);
		controller.sendSaleInfo();
	}
}
