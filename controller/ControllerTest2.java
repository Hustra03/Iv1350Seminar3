package controller;

import intergration.DatabaseHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ControllerTest2 {

    private DatabaseHandler dbHandler2;
    private Controller testcontroller2;

    @Before
    public void setUp() throws Exception {
        this.dbHandler2 = new DatabaseHandler();
        int time = 0;
        int date = 0;
        testcontroller2 = new Controller(dbHandler2,time,date);
        testcontroller2.startSale();

    }

    @After
    public void tearDown() throws Exception {
        testcontroller2 = null;
        dbHandler2 = null;
    }

    /**
    *   Testar att skapa ett objekt av Controllern
     */
    @Test
    public void ControllerCreateTest2() {


        assertNotNull("Resultatet ska innehålla ett objekt av typen Controller!", testcontroller2);
    }

    @Test
    public void StartSale2() {
        testcontroller2.startSale();

        assertNotNull("Controllern har inte fått tillbaka Sale!",testcontroller2.GetSale());
    }
}