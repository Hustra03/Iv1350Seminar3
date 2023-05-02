package view;

import controller.Controller;
import model.Receipt;
import model.Sale;
import model.SaleInfo;

public class View {

	private Controller controller;

	public View(Controller controller) {
		this.controller = controller;
	}

	public void startSystem() {
		boolean endOperation = true;

		while (endOperation == true) {
			int i = 0;
			int level = 0;
			switch (i) {
				case 1:
					optionOne(level);
					break;
				case 2:
					optionOne(level);
					break;
			}
		}

	}

	private void optionOne(int i) {
		if (i == 1) {
			controller.startSale();
		}

		if (i == 2) {
			printSale(controller.registerItem(0, 0));
		}

		if (i == 4) {
			printSaleInfo(controller.recivePayment(0));
			printReciept(controller.sendSaleInfo());
		}
	}

	private void optionTwo(int i) {
		if (i == 2) {
			printSaleInfo(controller.endSale());
		}
		if (i == 3) {
			printSaleInfo(controller.getDiscount(0));
		}
	}

	private void printSale(Sale sale) {

	}

	private void printSaleInfo(SaleInfo saleInfo) {

	}

	private void printReciept(Receipt receipt) {

	}

}
