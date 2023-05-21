package se.kth.iv1350.erikmichel.seminar3.startup;

import se.kth.iv1350.erikmichel.seminar3.view.View;


import se.kth.iv1350.erikmichel.seminar3.controller.Controller;
import se.kth.iv1350.erikmichel.seminar3.intergration.DatabaseHandler;

public class Main {

	public static void main(String[] args) {

		
			DatabaseHandler dbHandler = DatabaseHandler.getDatabaseHandler();
			Controller controller = new Controller(dbHandler);
			View view = new View(controller);
			view.startSystem();
		
	}

}
