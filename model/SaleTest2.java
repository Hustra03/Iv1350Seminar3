package model;

import intergration.ItemDescriptionDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SaleTest2 {
    private Sale testSale2;
    private ItemDescriptionDTO itemDescriptionDTO2;
    private Item item3;
    private Item item4;
    @Before
    public void setUp() throws Exception {
        testSale2 = new Sale();
        itemDescriptionDTO2 = new ItemDescriptionDTO();
        item3 = new Item(itemDescriptionDTO2, 10);
        item4 = new Item(itemDescriptionDTO2, 20);
    }

    @After
    public void tearDown() throws Exception {
        testSale2 = null;
        itemDescriptionDTO2 = null;
        item3 = null;
        item4 = null;
    }

    @Test
    public void addItemInfoTest2() {
        assertEquals("SoldItems är INTE tom!",testSale2.getSoldItems().isEmpty(), true);
        testSale2.addItemInfo(item3);
        testSale2.addItemInfo(item4);
        assertEquals("SoldItems är tom men skulle innehålla Items", testSale2.getSoldItems().isEmpty(), false);
        assertEquals("SoldItem innehåller inte item3",testSale2.getSoldItems().contains(item3), true);
        assertEquals("SoldItem innehåller inte item4",testSale2.getSoldItems().contains(item4), true);
    }

    @Test
    public void itemMerger2() {
        assertEquals("Den nyskapade listan som ska vara tom är inte tom",testSale2.getSoldItems().isEmpty(), true);

        testSale2.addItemInfo(item3);
        testSale2.addItemInfo(item4);
        assertEquals("TestSale2 innehåller inte två Items som förväntat",testSale2.getSoldItems().size(), 2);
        assertEquals("TestSale2 har fel antal för den första varan",testSale2.getSoldItems().get(0).getQuantity(), 10);
        testSale2.itemMerger(item4);
        assertEquals("TestSale2 har inte lagt till den andra varan korrekt iom",testSale2.getSoldItems().size(), 1);
        assertEquals("Det totala antalet avviker från det förväntade (30)",testSale2.getSoldItems().get(0).getQuantity(), 30);

    }
}