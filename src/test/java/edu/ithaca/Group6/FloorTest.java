package edu.ithaca.Group6;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class FloorTest {

    @Test
    void constructorTest(){
        Floor testFloor = new FloorImpl(20, new Brick());
        assertEquals(testFloor.getHeight(), 20, "Floor constructor test failed");
        assertEquals(testFloor.getMaterial(), new Brick(), "Floor constructor test failed");
        Floor testFloor2 = new FloorImpl(20, new ConcreteBrick());
        assertEquals(testFloor2.getHeight(), 20, "Floor constructor test failed");
        assertEquals(testFloor2.getMaterial(), new ConcreteBrick(), "Floor constructor test failed");


    }
    @Test
    void settersTest(){
        Floor testFloor = new FloorImpl(20, new Brick());
        testFloor.setHeight(30);
        testFloor.setMaterial(new TwoByThree());
        assertEquals(testFloor.getHeight(), 30, "Floor constructor test failed");
        assertEquals(testFloor.getMaterial(), new TwoByThree(), "Floor constructor test failed");
        testFloor.setHeight(100);
        testFloor.setMaterial(new Wood());
        assertEquals(testFloor.getHeight(), 100, "Floor constructor test failed");
        assertEquals(testFloor.getMaterial(), new Wood(), "Floor constructor test failed");

    }

}
