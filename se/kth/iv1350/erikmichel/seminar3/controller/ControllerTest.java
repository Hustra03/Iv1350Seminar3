package se.kth.iv1350.erikmichel.seminar3.controller;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.After;

import se.kth.iv1350.erikmichel.seminar3.intergration.DatabaseHandler;
import se.kth.iv1350.erikmichel.seminar3.intergration.SaleDTO;
import se.kth.iv1350.erikmichel.seminar3.intergration.SaleInfoDTO;
import se.kth.iv1350.erikmichel.seminar3.model.Sale;

public class ControllerTest {

	private Controller contr;

	@Before
	public void setUp() {
		DatabaseHandler dbHandler = new DatabaseHandler();
		contr = new Controller(dbHandler);
	}

	@After
	public void tearDown() {
		contr = null;
	}

	@Test
	public void ControllerCreateTest() {
		assertNotNull("Controller Not Created", contr);
	}

	@Test
	public void startSaleTest() {
		assertNull("Sale Not Started", contr.GetSale());
		contr.startSale();
		assertNotNull("Sale Not Started", contr.GetSale());
	}

	/*
	 * Below test needs an item in databaseHandler in order to function
	 */
	@Test
	public void registerItemTest() {
		int itemId=1;
		int quantity = 1;
		contr.startSale();
		assertTrue("Sold Items has item before registration ", contr.GetSale().getSoldItems().isEmpty());
		SaleDTO sale = contr.registerItem(itemId, quantity);
		assertNotNull("Item Not Registered", sale.getSoldItems());
		int registeredId=sale.getSoldItems().get(0).getItemDescriptionDTO().getItemId();
		assertTrue("Item id incorrectly registered",0!=registeredId);
		assertTrue("Wrong item id",itemId==registeredId);

	}

	@Test
	public void endSaleTest() {
		contr.startSale();
		Sale beforeSale= contr.GetSale();
		SaleInfoDTO saleInfo = contr.endSale();
		int itemId=1;
		int quantity = 1;
		assertNotNull("Sale Not Ended", saleInfo.getSale());
		assertEquals("Sale Changed By Being Ended",saleInfo.getSale().getSoldItems(),beforeSale.getSoldItems());
		contr.startSale();
		contr.registerItem(itemId, quantity);
		saleInfo = contr.endSale();
		assertNotEquals("Sale returned after end incorrect",saleInfo.getSale(),beforeSale);
	}

	@Test
	public void getDiscountTest() {
		contr.startSale();
		int customerId=0;
		contr.endSale();
		SaleInfoDTO saleInfo = contr.getDiscount(customerId);
		assertNotNull("Discount Not Found",saleInfo.getRecordedDiscounts());

	}

	@Test
	public void recivePaymentTest() {
		
		contr.startSale();
		double amountPayment = 0;
		SaleInfoDTO saleInfo = contr.endSale();
		saleInfo = contr.recivePayment(amountPayment);
		assertNotNull("Payment Not Recived",saleInfo.getCustomerPaymentDTO());
	}

	@Test
	public void sendSaleInfoTest() {

		contr.startSale();
		double amountPayment=0;
		contr.endSale();
		contr.recivePayment(amountPayment);
		contr.sendSaleInfo();
	}

}
