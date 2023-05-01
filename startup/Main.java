package startup;

import view.View;

import controller.Controller;
import intergration.DatabaseHandler;

public class Main {

	public static void main(String[] args) {

		DatabaseHandler dbHandler = new DatabaseHandler();
		Controller controller = new Controller(dbHandler);
		View view = new View(controller);
		/*
		Denna stämmer inte med Domaän modellen. Startsale ska komma från View när någon trycker på en knapp.
		view.StartSale()
		Detta ska komma från View.
		 */
		view.StartSale();
		boolean endSale=true;
		while(endSale==true)
		{
			int i=0;
			switch(i)
			{
				case 1:
				view.registerItem();
				break;
				case 2:
				view.endSale();
				endSale=false;
				break;
			}
		}
		boolean customerWantsDiscount=true;
		if(customerWantsDiscount==true)
		{
			view.getDiscount();
		}
		view.recivePaymentAndSendSaleInfo();
	}

}
