package view;

import controller.Controller;
import model.Receipt;
import model.Sale;
import model.SaleInfo;
import model.Item;
import java.util.Scanner; // Import the Scanner class

public class View {

	private Controller controller;

	/*
	 * Creates an object of View type
	 * 
	 * @param controller is the controller object the view object will utalize
	 */
	public View(Controller controller) {
		this.controller = controller;
	}

	/*
	 * This is the method called by main, and where the user interface is located
	 * 
	 */
	public void startSystem() {
		boolean endOperation = false;

		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		int level = 1;
		while (endOperation == false) {
			int i;
			System.out.println("Enter menu alternative");
			printMenu(level);
			i = myObj.nextInt();
			System.out.println("Option choosen is: " + i);
			switch (i) {
				case 1:
					level = optionOne(level);
					break;
				case 2:
					level = optionTwo(level);
					break;
			}

			System.out.println("");
		}

	}

	/*
	 * Handles menu and input/output for first menu option
	 */
	private int optionOne(int level) {
		Scanner myObj = new Scanner(System.in); // Create a Scanner object

		if (level == 1) {
			controller.startSale();
			System.out.println("Starting Sale");
			return 2;
		}

		if (level == 2) {
			System.out.println("Enter item identifyer");
			int itemId = myObj.nextInt();
			System.out.println("Item id is: " + itemId);

			System.out.println("Enter quantity");
			int quantity = myObj.nextInt();
			System.out.println("Quantity is: " + quantity);
			printSale(controller.registerItem(itemId, quantity));
			return 2;
		}

		if (level == 3) {
			return 4;
		}

		if (level == 4) {
			System.out.println("Enter amount payment");
			int amountPayment = myObj.nextInt();
			System.out.println("Amount payment is: " + amountPayment);
			printSaleInfo(controller.recivePayment(amountPayment));
			printReciept(controller.sendSaleInfo());
			return 4;
		}
		return 1;
	}

	/*
	 * Handles menu and input/output for second menu option
	 */
	private int optionTwo(int level) {
		if (level == 2) {
			SaleInfo saleInfo= controller.endSale();
			System.out.println("Total Price :" +saleInfo.getTotalPriceAfterDiscount() + " Total VAT" + saleInfo.getTotalVATAfterDiscount());
			return 3;
		}
		if (level == 3) {
			printSaleInfo(controller.getDiscount(0));
			return 4;
		}
		return 1;
	}

	private void printSale(Sale sale) {

		if (sale.getItemFound() == false) {
			System.out.println("Item Not Found");
		} 
		else {
			System.out.println("Sale Information : ");
			System.out.println("Item Information : ");
			int itemNumber =0;
			for (Item item : sale.getSoldItems()) {
				itemNumber+=1;
				printItem(item,itemNumber);
			}
			System.out.println("Total Price : " + sale.getTotalPrice());
			System.out.println("Total VAT : " + sale.getTotalVAT());
		}
	}

	private void printSaleInfo(SaleInfo saleInfo) {

	}


	private void printItem(Item item, int itemNumber) {
		System.out.print("Item number :" + itemNumber + " ||");
		System.out.print("ItemId :" + item.getItemDescriptionDTO().getItemId() + " ||");
		System.out.print("Name :"  + item.getItemDescriptionDTO().getItemId()+ " ||");
		System.out.print("Price :"  + item.getItemDescriptionDTO().getPrice()+ " ||");
		System.out.print("VATrate :"  + item.getItemDescriptionDTO().getItemId()+ " ||");
		System.out.print("Description :" + item.getItemDescriptionDTO().getItemId()+ " ||");
		System.out.println("");
	}

	private void printReciept(Receipt receipt) {

	}

	private void printMenu(int level) {

		if (level == 1) {
			System.out.println("1. Start Sale");
			System.out.println("2. Do Nothing");

		}
		if (level == 2) {
			System.out.println("1. Register New Item");
			System.out.println("2. Stop Registering Items");

		}
		if (level == 3) {
			System.out.println("1. No Discount");
			System.out.println("2. Register Discount");

		}
		if (level == 4) {
			System.out.println("1. End Sale");
			System.out.println("2. Restart Sale");
		}

	}

}
