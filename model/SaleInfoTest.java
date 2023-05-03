package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import intergration.CustomerPaymentDTO;
import intergration.ItemDescriptionDTO;
import model.Discount;

public class SaleInfoTest {

    private SaleInfo saleInfo;
    private List<Discount> discountList;
    private int customerId;

    @Before
    public void setUp() {
        Sale sale = new Sale();
        saleInfo = new SaleInfo(sale);
        customerId = 10;
        discountList = new ArrayList<Discount>();
		List<Integer> applicableIds = new ArrayList<Integer>();
        applicableIds.add(1);
        applicableIds.add(2);
        applicableIds.add(3);

		List<Integer> applicableItems = new ArrayList<Integer>();
        applicableItems.add(1);
        applicableItems.add(2);
        applicableItems.add(3);

        int discountPercent=20;
        int minimumItemAmount=0;
        int minimumTotalPrice=0;

        discountList.add(new Discount(discountPercent, applicableIds, applicableItems, minimumItemAmount, minimumTotalPrice));
        saleInfo.setDiscountAndCustomerId(discountList, customerId);
    }

    @After
    public void tearDown() {
        saleInfo = null;
        customerId=0;
        discountList=null;
    }

    @Test
    public void setDiscountAndCustomerIdTest() {
        assertEquals("Customer Id Incorrect", saleInfo.getCustomerId(), customerId);
        assertEquals("Discount List Incorrect", saleInfo.getRecordedDiscounts(), discountList);
    }

    @Test
    public void updateSaleInfoPaymentTest() {
        int amountPayment = 10;
        int amountChange = 5;
        long time = System.currentTimeMillis();
        LocalDate date = java.time.LocalDate.now();
        CustomerPaymentDTO payment = new CustomerPaymentDTO(amountPayment, amountChange, time, date);
        saleInfo.updateSaleInfoPayment(payment);
        assertTrue("AmountPayment incorrect", payment.getPaymentAmount() == amountPayment);
        assertTrue("AmountChange incorrect", payment.getChange() == amountChange);
        assertEquals("Time incorrect", time, payment.getTime());
        assertEquals("Date incorrect", date, payment.getDate());

    }

    @Test
    public void calculateTotalPriceAndVATAfterDiscountTest() {
        
        Sale sale = new Sale();
        int itemId=1;
        ItemDescriptionDTO itemDTO = new ItemDescriptionDTO(itemId, "name", 12, 12, "null");
        Register testRegister = new Register();
        sale = testRegister.registerItem(itemDTO, 10, sale); 
        saleInfo = new SaleInfo(sale);
        saleInfo.setDiscountAndCustomerId(discountList, itemId);
        
    }

    @Test
    public void getTotalPriceAfterDiscountTest() {
    }

    @Test
    public void getTotalVATAfterDiscountTest() {
    }

    @Test
    public void getSaleTest() {
    }

    @Test
    public void getCustomerPaymentDTOTest() {
    }

    @Test
    public void getCustomerIdTest() {
    }

    @Test
    public void getRecordedDiscountsTest() {
    }

}
