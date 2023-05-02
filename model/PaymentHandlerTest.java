package model;

import intergration.CustomerPaymentDTO;
import intergration.ItemDescriptionDTO;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PaymentHandlerTest {

    @Test
    public void handlePaymentTest() {
        PaymentHandler paymentHandler = new PaymentHandler();
        double price=200;
        ItemDescriptionDTO itemDescriptionDTO = new ItemDescriptionDTO(19, price, 19);
        Item item = new Item(itemDescriptionDTO, 1);
        Sale sale = new Sale(item);
        sale.calculateRunningTotal();
        assertEquals(false, sale.getTotalPrice() == 0);
        SaleInfo saleInfo = new SaleInfo(sale);
        assertEquals(true, saleInfo.getTotalPriceAfterDiscount() == price);
        int amountPayment = 10;
        saleInfo = paymentHandler.handlePayment(amountPayment, saleInfo);
        CustomerPaymentDTO customerPaymentDTO = new CustomerPaymentDTO(amountPayment,
        amountPayment - saleInfo.getTotalPriceAfterDiscount(), paymentHandler.getTime(), paymentHandler.getDate());
        assertEquals("Customer Payment Does Not Exist",true, saleInfo.getCustomerPaymentDTO() != null);
        assertEquals("Payment Amount Incorrect",true, saleInfo.getCustomerPaymentDTO().getPaymentAmount() == customerPaymentDTO.getPaymentAmount());
        assertEquals("Change Amount Incorrect",true, saleInfo.getCustomerPaymentDTO().getChange() == customerPaymentDTO.getChange());
        assertEquals("Time Amount Incorrect",true, saleInfo.getCustomerPaymentDTO().getTime() == customerPaymentDTO.getTime());
        assertEquals("Date Amount Incorrect",true, saleInfo.getCustomerPaymentDTO().getDate() == customerPaymentDTO.getDate());
    }
}
