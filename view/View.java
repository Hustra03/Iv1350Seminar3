package view;

import controller.Controller;

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
			controller.registerItem(0, 0);
		}

		if (i == 4) {
			controller.recivePayment(0);
			controller.sendSaleInfo();
		}
	}

	private void optionTwo(int i) {
		if (i == 2) {
			controller.endSale();
		}
		if (i == 3) {
			controller.getDiscount(0);
		}
	}

}
