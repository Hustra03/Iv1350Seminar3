package model;

import intergration.CustomerPaymentDTO;
import intergration.ItemDescriptionDTO;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PaymentHandlerTest {
    
    @Test
    public void handlePaymentTest() 
    {
        PaymentHandler paymentHandler = new PaymentHandler();
        ItemDescriptionDTO itemDescriptionDTO = new ItemDescriptionDTO(19,191,19);
        Item item = new Item(itemDescriptionDTO, 1);
        Sale sale = new Sale(item);
        sale.calculateRunningTotal();
        assertEquals(sale.getTotalPrice()==0,false);
        SaleInfo saleInfo=new SaleInfo(sale);
        paymentHandler.handlePayment(10, saleInfo);
        CustomerPaymentDTO customerPaymentDTO=new CustomerPaymentDTO(10, 10, paymentHandler.getTime(), paymentHandler.getDate());
        assertEquals(saleInfo.getCustomerPaymentDTO()==customerPaymentDTO,true);
    }
}
