package view;

import controller.Controller;
import model.Receipt;
import model.Sale;
import model.SaleInfo;
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
		int level = 0;
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

	private int optionOne(int level) {
		if (level == 1) {
			controller.startSale();
			System.out.println("Starting Sale");
			return 2;
		}

		if (level == 2) {
			printSale(controller.registerItem(0, 0));
			return 2;
		}

		if(level == 3)
		{
			return 4;
		}

		if (level == 4) {
			printSaleInfo(controller.recivePayment(0));
			printReciept(controller.sendSaleInfo());
			return 4;
		}
		return 1;
	}

	private int optionTwo(int level) {
		if (level == 2) {
			printSaleInfo(controller.endSale());
			return 3;
		}
		if (level == 3) {
			printSaleInfo(controller.getDiscount(0));
			return 4;
		}
		return 1;
	}

	private void printSale(Sale sale) {

	}

	private void printSaleInfo(SaleInfo saleInfo) {

	}

	private void printReciept(Receipt receipt) {

	}

	private void printMenu(int level) {

		if(level==1)
		{
			System.out.println("1. Start Sale");
			System.out.println("2. Do Nothing");

		}
		if(level==2)
		{
			System.out.println("1. Register New Item");
			System.out.println("2. Stop Registering Items");

		}
		if(level==3)
		{
			System.out.println("1. No Discount");
			System.out.println("2. Register Discount");

		}
		if(level==4)
		{
			System.out.println("1.");
			System.out.println("2.");
		}

	}

}
