package controller;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import intergration.DatabaseHandler;
import model.PaymentHandler;
import model.Register;
import model.Sale;
import model.Discount;
import model.SaleInfo;


public class ControllerTest {
  
	@Test
	public void ControllerCreateTest() {
		DatabaseHandler databaseHandler = new DatabaseHandler();
        Controller Testcontroller = new Controller(databaseHandler);
		assertNotNull(Testcontroller);
	}
	
    @Test
	public void startSaleTest() {
		DatabaseHandler databaseHandler = new DatabaseHandler();
        Controller Testcontroller = new Controller(databaseHandler);
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
