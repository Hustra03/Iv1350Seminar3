package startup;

import view.View;

import javax.xml.crypto.Data;

import controller.Controller;
import intergration.DatabaseHandler;

public class Main {

	public void main(String[] args) {

		DatabaseHandler dbHandler = new DatabaseHandler();
		Controller controller = new Controller(dbHandler, 0, 0);
		View view = new View(controller);

	}

}
