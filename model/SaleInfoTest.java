package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import intergration.CustomerPaymentDTO;
import model.Discount;

public class SaleInfoTest {

    private SaleInfo saleInfo;

    @Before
    public void setUp() {
        Sale sale = new Sale();
        saleInfo=new SaleInfo(sale);
    }

    @After
    public void tearDown() {
        saleInfo=null;
    }

    @Test
    public void setDiscountAndCustomerIdTest() {
        int customerId=10;
        List<Discount> discountList=new ArrayList<Discount>();
        discountList.add(new Discount(customerId, null, null, customerId, customerId));
        
        saleInfo.setDiscountAndCustomerId(discountList, customerId);
        assertEquals(saleInfo.getCustomerId(),customerId);
        assertEquals(saleInfo.getRecordedDiscounts(),discountList);
    }

    @Test
    public void updateSaleInfoPaymentTest() {
    }

    @Test
    public void getTotalPriceAfterDiscountTest() {
    }

    @Test
    public void getTotalVATAfterDiscountTest() {
    }

    @Test
    public void calculateTotalPriceAndVATAfterDiscountTest() {
    }

    @Test
    public void getSaleTest() {
    }

    @Test
    public void getCustomerPaymentDTOTest() {
    }

    @Test
    public void findDiscountTest() {
    }
}
