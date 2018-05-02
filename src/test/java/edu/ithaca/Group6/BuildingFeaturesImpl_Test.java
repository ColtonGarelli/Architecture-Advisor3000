package edu.ithaca.Group6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BuildingFeaturesImpl_Test {
    @Test
    public void setCeilingLengthTest(){
//        assertEquals(true, false);
    }

    @Test
    public void stairsCalcCostTest(){
        Wood wood = new Wood();
        Stairs stairs = new Stairs(10, 16, 10, 3, wood);
        assertEquals(160, stairs.getCost(), "Did not properly calculate cost of stairs");
    }

}
