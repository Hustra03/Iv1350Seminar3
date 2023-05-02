package startup;

import view.View;

import controller.Controller;
import intergration.DatabaseHandler;

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
