package edu.ithaca.Group6;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class FloorTest {

    @Test
    void constructorTest(){
        Floor testFloor = new FloorImpl(20, new Brick());
        assertEquals(testFloor.getHeight(), 20, "Floor constructor test failed");
        assertEquals(testFloor.getMaterial().getClass(), new Brick().getClass(), "Floor constructor test failed");
        Floor testFloor2 = new FloorImpl(20, new ConcreteBrick());
        assertEquals(testFloor2.getHeight(), 20, "Floor constructor test failed");
        assertEquals(testFloor2.getMaterial().getClass(), new ConcreteBrick().getClass(), "Floor constructor test failed");


    }
    @Test
    void settersTest(){
        Floor testFloor = new FloorImpl(20, new Brick());
        testFloor.setHeight(30);
        testFloor.setMaterial(new TwoByThree());
        assertEquals(testFloor.getHeight(), 30, "Floor constructor test failed");
        assertEquals(testFloor.getMaterial().getClass(), new TwoByThree().getClass(), "Floor constructor test failed");
        testFloor.setHeight(100);
        testFloor.setMaterial(new Wood());
        assertEquals(testFloor.getHeight(), 100, "Floor constructor test failed");
        assertEquals(testFloor.getMaterial().getClass(), new Wood().getClass(), "Floor constructor test failed");

    }
    @Test
    void floorToStringTest(){
        Floor testFloor = new FloorImpl(10, new Brick());
        String testString = testFloor.floorOutString();
        String actualString = "F: 10.0_Brick : $142.34 per square foot_\n";
        assertEquals(actualString,testString);
    }

}
