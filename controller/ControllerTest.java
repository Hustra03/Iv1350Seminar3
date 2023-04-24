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
    

	public ControllerTest Controller(DatabaseHandler dbHandler, int time, int date) {
		return null;
	}

    @Test
	public void startSaleTest() {
        Controller Testcontroller = new Controller();
        Testcontroller.startSale();
        assertNotNull(Testcontroller.GetSale());
	}

	public Sale registerItemTest(int itemId, int quantity) {
		return null;
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
