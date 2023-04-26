package view;

import controller.Controller;

public class View {

	private Controller controller;

	public View(Controller controller) {
		this.controller=controller;
	}
	/* Starts system operation to begin startSale
	 * 
	 */
	public void StartSale()
	{
		controller.startSale();
	}
}
