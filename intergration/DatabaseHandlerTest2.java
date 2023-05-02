package intergration;

import model.Discount;
import model.Item;
import model.SaleInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import intergration.DatabaseHandler;
import static org.junit.Assert.*;

public class DatabaseHandlerTest2 {

    private SaleInfo testSale;
    int customerId;
    private List<ItemDescriptionDTO> inventoryItems;
    private List<Discount> everyDiscount;
    @Before
    public void setUp() throws Exception {
        List<Integer> testApplicableIds = new ArrayList<Integer>();
        List<Item> testApplicableItems = new ArrayList<Item>();
        int testDiscountPercent = 0;
        int testMinimumItemAmount = 0;
        int testMinimumTotalPrice = 0;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getItem() {

    }

    @Test
    public void findDiscount() {


    }

    @Test
    public void sendSaleInfo() {
    }
}