import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Before;

public class ShopTest {

    ResaleShop testShop;
    Computer initialComputer;
    Computer testComputer;

    @Before
    public void setUp() {
        this.testShop = new ResaleShop();
        this.initialComputer = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        this.testComputer = new Computer("2030 MacBook Pro", "AMD", 500, 40, "Bye Sierra", 2030, 200000);
    }
    @Test
    public void testSetPrice(){
        int updatePrice = 2000;
        initialComputer.setPrice(updatePrice);
        int actualPrice = initialComputer.price;
        assertEquals(updatePrice, actualPrice);
    }

    @Test
    public void testSetOS(){
        String newOS = "INTERNET";
        initialComputer.setOS(newOS);
        String updatedOS = initialComputer.operatingSystem;
        assertEquals(newOS, updatedOS); 
    }
    
    @Test
    public void testGetYear(){
        int YearMade = initialComputer.yearMade;
        assertEquals(YearMade, initialComputer.yearMade);
    }

    @Test
    public void testBuy(){
        ArrayList<Computer> correctList = new ArrayList<>();
        correctList.add(initialComputer);
        correctList.add(testComputer);
        testShop.buy(testComputer);
        ArrayList<Computer> inventoryList = testShop.inventory;
        assertEquals(correctList, inventoryList);
    }

    @Test
    public void testComputerAlreadyThereSell(){
        testShop.sell(initialComputer);
        ArrayList<Computer> inventoryList = testShop.inventory;
        boolean isitthere = inventoryList.contains(initialComputer);
        assertFalse(isitthere);
    }

    @Test
    public void testComputerIsNotThereSell(){
        boolean blah = true;
        try {
            testShop.sell(testComputer);
        } catch (Exception e) {
            blah = false;
        }
        assertFalse(blah);
    }
    @Test
    public void testDoesLoopStopInPrintInventory(){
        boolean outBoundLoop = true;
        try {
            testShop.printInventory();
        } catch (Exception e) {
            outBoundLoop = false;
        }
        assertTrue(outBoundLoop);
    }

    @Test
    public void testPrintInventory(){
        
    }
    }

