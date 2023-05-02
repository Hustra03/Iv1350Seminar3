package controller;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
		controller.startSale();
		assertNotNull("Sale Not Started",controller.GetSale());
	}

	/*
	 * Below test needs an item in databaseHandler in order to function
	 */
	@Test
	public void registerItemTest() {
		int itemId=0;
		int quantity = 1;
		controller.startSale();
		Sale beforeSale=controller.GetSale();
		Sale sale = controller.registerItem(itemId, quantity);
		assertEquals("Item Not Registered",true,sale.getSoldItems().get(0).getItemDescriptionDTO()!=beforeSale.getSoldItems().get(0).getItemDescriptionDTO());
	}

	@Test
	public void endSaleTest() {
		controller.startSale();
		Sale beforeSale=controller.GetSale();
		SaleInfo saleInfo =controller.endSale();
		assertEquals("Sale Not Ended Correctly",true,saleInfo.getSale()==beforeSale);
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
