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
			System.out.println("");
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
			System.out.println("Quantity increase is: " + quantity);
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
			System.out.println("Total Price :" +saleInfo.getTotalPriceAfterDiscount() + "|| Total VAT : " + saleInfo.getTotalVATAfterDiscount());
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
			System.out.println("Identifyer was invalid");
		} 
		else {
			System.out.println("Sale Information : ");
			System.out.print("[");	
			int itemNumber =0;
			for (Item item : sale.getSoldItems()) {
				System.out.println("Item Information : ");
				itemNumber+=1;
				printItem(item,itemNumber);
			}
			System.out.println("]");
			System.out.println("Total Price : " + sale.getTotalPrice());
			System.out.println("Total VAT : " + sale.getTotalVAT());
		}
	}

	private void printSaleInfo(SaleInfo saleInfo) {

		printSale(saleInfo.getSale());
		System.out.println("Change : " + saleInfo.getCustomerPaymentDTO().getChange());
		System.out.println("Discounted total price : " + saleInfo.getTotalPriceAfterDiscount());
		System.out.println("Discounted total VAT : " + saleInfo.getTotalVATAfterDiscount());
		System.out.println("Customer id : " + saleInfo.getCustomerId());
		
	}


	private void printItem(Item item, int itemNumber) {
		System.out.println("{");
		System.out.print("Item number :" + itemNumber + " ||");
		System.out.print("ItemId :" + item.getItemDescriptionDTO().getItemId() + " ||");
		System.out.print("Item Quantity :" + item.getQuantity() + " ||");
		System.out.print("Name :"  + item.getItemDescriptionDTO().getName()+ " ||");
		System.out.print("Price :"  + item.getItemDescriptionDTO().getPrice()+ " ||");
		System.out.print("VATrate :"  + item.getItemDescriptionDTO().getVATrate()+ "% ||");
		System.out.print("Description :" + item.getItemDescriptionDTO().getDescription()+ " ||");
		System.out.println("");
		System.out.print("}");
	}

	private void printReciept(Receipt receipt) {
		System.out.println("Reciept info :");
		System.out.print("Time :"+receipt.getTime()+"||");
		System.out.print("Date :"+receipt.getDate()+"||");
		System.out.print("Total Price :" + receipt.getTotalPrice()+"||");
		System.out.print("Total VAT :"+receipt.getTotalVAT()+"||");
		System.out.print("Total Payment :" + receipt.getTotalPayment()+ "||");
		System.out.print("Total Change :" + receipt.getTotalChange()+"||" );
		System.out.println("");
		System.out.println("Items sold:");
		int itemNumber=1;
		for (Item item : receipt.getSoldItems()) {
			printItem(item,itemNumber);
		}


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
