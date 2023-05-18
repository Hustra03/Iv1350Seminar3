package se.kth.iv1350.erikmichel.seminar3.intergration;

import se.kth.iv1350.erikmichel.seminar3.model.Sale;
import se.kth.iv1350.erikmichel.seminar3.model.SaleInfo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class DatabaseHandlerTest {
    private DatabaseHandler databaseHandler;

    @Before
    public void setUp() {
        databaseHandler = DatabaseHandler.getDatabaseHandler();
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
            fail("Threw exception with a valid id");
        }

        //New part of test, specifically for exceptions
        try {
            assertNotNull("Item Not Found", databaseHandler.getItem(1241124));
            fail("Exception not thrown when expected");
       } catch (ItemLookUpException e) {
        assertTrue("Something Is Wrong With Assertions", true);
       }//
       
    }

    @Test
    public void findDiscountTest() {
        Sale sale = new Sale();
        SaleInfo saleInfo = new SaleInfo(sale);
        assertNotNull("Discount Not Found", databaseHandler.findDiscount(saleInfo, 0));
    }
}
