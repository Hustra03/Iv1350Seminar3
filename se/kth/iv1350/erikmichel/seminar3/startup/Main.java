package se.kth.iv1350.erikmichel.seminar3.startup;

import se.kth.iv1350.erikmichael.seminar3.view.View;

import se.kth.iv1350.erikmichael.seminar3.controller.Controller;
import se.kth.iv1350.erikmichael.seminar3.intergration.DatabaseHandler;
import se.kth.iv1350.erikmichel.seminar3.controller.Controller;
import se.kth.iv1350.erikmichel.seminar3.intergration.DatabaseHandler;

public class Main {

	public static void main(String[] args) {

		while (true) {
			DatabaseHandler dbHandler = new DatabaseHandler();
			Controller controller = new Controller(dbHandler);
			View view = new View(controller);
			view.startSystem();
		}
	}

}
