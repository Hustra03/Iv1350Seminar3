package model;

import intergration.CustomerPaymentDTO;
import intergration.ItemDescriptionDTO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PaymentHandlerTest {

    @Test
    public void handlePaymentTest() {
        PaymentHandler paymentHandler = new PaymentHandler();
        double price = 200;
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
                amountPayment - saleInfo.getTotalPriceAfterDiscount(), paymentHandler.getDateAndTime());
        assertNotNull("Customer Payment Does Not Exist", saleInfo.getCustomerPaymentDTO());
        assertTrue("Payment Amount Incorrect Value", saleInfo.getCustomerPaymentDTO().getPaymentAmount() == customerPaymentDTO.getPaymentAmount());
        assertTrue("Change Amount Incorrect Value",
                saleInfo.getCustomerPaymentDTO().getChange() == customerPaymentDTO.getChange());
        assertTrue("Date Amount Incorrect Value",
                saleInfo.getCustomerPaymentDTO().getDateAndTime() == customerPaymentDTO.getDateAndTime());
    }
}
