package se.kth.iv1350.erikmichel.seminar3.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import se.kth.iv1350.erikmichel.seminar3.intergration.CustomerPaymentDTO;
import se.kth.iv1350.erikmichel.seminar3.intergration.DiscountDTO;
import se.kth.iv1350.erikmichel.seminar3.intergration.ItemDescriptionDTO;

public class SaleInfoTest {

    private SaleInfo saleInfo;
    private List<DiscountDTO> discountList;
    private int customerId;
    private DiscountInterface discountInterface;

    @Before
    public void setUp() {
        Sale sale = new Sale();
        this.discountInterface = new OriginalDiscountCalculation();
        saleInfo = new SaleInfo(sale,discountInterface);
        customerId = 10;
        discountList = new ArrayList<DiscountDTO>();
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

        discountList.add(new DiscountDTO(discountPercent, applicableIds, applicableItems, minimumItemAmount, minimumTotalPrice));
        saleInfo.setDiscountAndCustomerId(discountList, customerId);
    }

    @After
    public void tearDown() {
        saleInfo = null;
        customerId=0;
        discountList=null;
        discountInterface=null;
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
        LocalDateTime dateAndTime = java.time.LocalDateTime.now();
        CustomerPaymentDTO payment = new CustomerPaymentDTO(amountPayment, amountChange,dateAndTime);
        saleInfo.updateSaleInfoPayment(payment);
        assertTrue("AmountPayment incorrect", payment.getPaymentAmount() == amountPayment);
        assertTrue("AmountChange incorrect", payment.getChange() == amountChange);
        assertEquals("Date and Time incorrect", dateAndTime, payment.getDateAndTime());

    }

    @Test
    public void calculateTotalPriceAndVATAfterDiscountTest() {
        
        Sale sale = new Sale();
        int itemId=1;
        double price = 12;
        int Vatrate=12;
        ItemDescriptionDTO itemDTO = new ItemDescriptionDTO(itemId, "name", price, Vatrate, "null");
        Register testRegister = new Register();
        int quantity = 10;
        sale = testRegister.registerItem(itemDTO, quantity, sale); 
        saleInfo = new SaleInfo(sale,discountInterface);
        saleInfo.setDiscountAndCustomerId(discountList, itemId);
        assertTrue("RecordedDiscounts does not exist", saleInfo.getRecordedDiscounts() != null);
        assertTrue("RecordedDiscounts size incorrect", saleInfo.getRecordedDiscounts().size() ==1);
        assertTrue("RecordedDiscounts percentage incorrect", saleInfo.getRecordedDiscounts().get(0).getDiscountPercent() ==20);
        assertTrue("Discounted total price not initialized",saleInfo.getTotalPriceAfterDiscount()!=0);
        assertTrue("Discounted total price not discounted",saleInfo.getTotalPriceAfterDiscount()!=price);
        double expectedPrice = price*0.8*quantity;
        assertTrue("Discounted total price to high, currently : " + saleInfo.getTotalPriceAfterDiscount() +" | Should be :" + expectedPrice,saleInfo.getTotalPriceAfterDiscount()>=expectedPrice-0.001);
        assertTrue("Discounted total price to low, currently : " + saleInfo.getTotalPriceAfterDiscount() +" | Should be :" + expectedPrice,saleInfo.getTotalPriceAfterDiscount()<=expectedPrice+0.001);
    }
}
