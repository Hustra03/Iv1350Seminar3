package controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import intergration.DatabaseHandler;
import model.PaymentHandler;
import model.Register;
import model.Sale;
import model.Discount;
import model.SaleInfo;
import model.Receipt;

public class ControllerTest {
  
	@Test
	public void ControllerTest () {
		DatabaseHandler databaseHandler = new DatabaseHandler();
		int time = 0;
		int date = 0;
        Controller Testcontroller = new Controller(databaseHandler,time,date);
		assertNotNull(Testcontroller);
	}
	
    @Test
	public void startSaleTest() {
		DatabaseHandler databaseHandler = new DatabaseHandler();
		int time = 0;
		int date = 0;
        Controller Testcontroller = new Controller(databaseHandler,time,date);
        Testcontroller.startSale();
        assertNotNull(Testcontroller.GetSale());
	}

	public void registerItemTest() {
	}

	public SaleInfo endSaleTest() {
		return null;
	}

	public SaleInfo getDiscountTest(int customerId) {
		return null;
	}

	public SaleInfo recivePaymentTest(int amountPayment) {
		return null;
	}

	public void sendSaleInfoTest() {

	}

}
