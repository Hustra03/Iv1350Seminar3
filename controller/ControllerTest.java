package controller;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.After;

import intergration.DatabaseHandler;
import model.PaymentHandler;
import model.Register;
import model.Sale;
import model.Discount;
import model.SaleInfo;

public class ControllerTest {

	private Controller controller;

	@Before
	public void setUp() {
		DatabaseHandler databaseHandler = new DatabaseHandler();
		controller = new Controller(databaseHandler);
	}

	@After
	public void tearDown() {
		controller = null;
	}

	@Test
	public void ControllerCreateTest() {
		assertNotNull("Controller Not Created",controller);
	}

	@Test
	public void startSaleTest() {
		assertNull("Sale Not Started",controller.GetSale());
		controller.startSale();
		assertNotNull("Sale Not Started",controller.GetSale());
	}

	/*
	 * Below test needs an item in databaseHandler in order to function
	 */
	@Test
	public void registerItemTest() {
		int itemId=1;
		int quantity = 1;
		controller.startSale();
		Sale sale = controller.registerItem(itemId, quantity);
		assertNotNull("Item Not Registered", sale.getSoldItems());
		int registeredId=sale.getSoldItems().get(0).getItemDescriptionDTO().getItemId();
		assertTrue("Item id incorrectly registered",0!=registeredId);
		assertTrue("Wrong item id incorrect",itemId==registeredId);

	}

	@Test
	public void endSaleTest() {
		controller.startSale();
		Sale beforeSale=controller.GetSale();
		SaleInfo saleInfo = controller.endSale();
		int itemId=1;
		int quantity = 1;
		assertNotNull("Sale Not Ended", saleInfo.getSale());
		assertEquals("Sale Not Ended Correctly",saleInfo.getSale(),beforeSale);
		controller.startSale();
		controller.registerItem(itemId, quantity);
		saleInfo = controller.endSale();
		assertNotEquals("Sale returned after end incorrect",saleInfo.getSale(),beforeSale);
	}

	@Test
	public void getDiscountTest() {
		controller.startSale();
		int customerId=0;
		controller.endSale();
		SaleInfo saleInfo =controller.getDiscount(customerId);
		assertNotNull("Discount Not Found",saleInfo.getRecordedDiscounts());

	}

	@Test
	public void recivePaymentTest() {
		
		controller.startSale();
		int amountPayment=0;
		SaleInfo saleInfo=controller.endSale();
		saleInfo=controller.recivePayment(amountPayment);
		assertNotNull("Payment Not Recived",saleInfo.getCustomerPaymentDTO());
	}

	@Test
	public void sendSaleInfoTest() {

		controller.startSale();
		int amountPayment=0;
		SaleInfo saleInfo=controller.endSale();
		saleInfo=controller.recivePayment(amountPayment);
		controller.sendSaleInfo();
	}

}
