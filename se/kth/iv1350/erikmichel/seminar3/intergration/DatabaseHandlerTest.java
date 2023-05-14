package se.kth.iv1350.erikmichel.seminar3.intergration;

import se.kth.iv1350.erikmichel.seminar3.model.Sale;
import se.kth.iv1350.erikmichel.seminar3.model.SaleInfo;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class DatabaseHandlerTest {
    private DatabaseHandler databaseHandler;

    @Before
    public void setUp() {
        databaseHandler = new DatabaseHandler();
    }

    @After
    public void tearDown() {
        databaseHandler = null;
    }

    @Test
    public void getItemTest() {
        try {
             assertNotNull("Item Not Found", databaseHandler.getItem(0));
        } catch (Exception e) {
        }
       
    }

    @Test
    public void findDiscountTest() {
        Sale sale = new Sale();
        SaleInfo saleInfo = new SaleInfo(sale);
        assertNotNull("Discount Not Found", databaseHandler.findDiscount(saleInfo, 0));
    }
}
