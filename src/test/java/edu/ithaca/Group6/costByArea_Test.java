package edu.ithaca.Group6;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class costByArea_Test {
    private costByArea areaMaterial;

    @BeforeEach
    void setup(){
        areaMaterial = new costByAreaImpl("Wood",1.00);
    }

    @Test
    public void calcAreaMeterTest(){
        areaMaterial = new costByAreaImpl("Wood",1.00);
        double areaFeetZero = 0;
        double areaFeetPos = 7;
        double areaFeetNeg = -7;

        assertEquals(0, areaMaterial.calcAreaMeter(areaFeetZero), "Did not calculate area with zero square feet");
        assertEquals(.6503,areaMaterial.calcAreaMeter(areaFeetPos),"Did not calculate area with positive square feet");
        assertThrows(IndexOutOfBoundsException.class,()->{areaMaterial.calcAreaMeter(areaFeetNeg);},"Did not throw exception with negative square feet");
    }

    @Test
    public void calcCostTest(){
        areaMaterial = new costByAreaImpl("Wood",1.00);
        double areaMetersZero = 0;
        double areaMetersPos = 7;
        double areaMetersNeg = -7;

        assertEquals(0,areaMaterial.calcCost(areaMetersZero),"Did not calculate cost for zero meters");
        assertEquals(7.00,areaMaterial.calcCost(areaMetersPos),"Did not calculate cost of positive meters");
        assertThrows(IndexOutOfBoundsException.class,()->{areaMaterial.calcCost(areaMetersNeg);},"Did not throw exception with negative square meters");
    }

    @Test
    public void setMaterialTest(){
        areaMaterial = new costByAreaImpl("Wood",1.00);
        String emptyString = "";
        String testMaterial = "Brick";

        areaMaterial.setMaterialName(testMaterial);
        assertEquals("Brick",areaMaterial.getMaterialName(),"Could not set material");

        assertThrows(NullPointerException.class,()->{areaMaterial.setMaterialName(emptyString);},"Did not throw exception for empty string");
    }

    @Test
    public void getMaterialTest(){
        areaMaterial = new costByAreaImpl("Wood",1.00);
        assertEquals("Wood",areaMaterial.getMaterialName(),"Could not retrieve name");
    }

    @Test
    public void setAreaCostTest(){
        areaMaterial = new costByAreaImpl("Wood",1.00);
        double positiveCost = 7.00;
        double zeroCost = 0;
        double negativeCost = -7.00;


        areaMaterial.setCost(positiveCost);
        assertEquals(positiveCost,areaMaterial.getCostPerSquareMeter(),"Could not change cost to be positive");

        areaMaterial.setCost(zeroCost);
        assertEquals(0,areaMaterial.getCostPerSquareMeter(),"Could not set to zero cost");

        assertThrows(IndexOutOfBoundsException.class,()->{areaMaterial.setCost(negativeCost);},"Did not throw exception with negative cost");
    }

    @Test
    public void getAreaCostTest(){
        areaMaterial = new costByAreaImpl("Wood",1.00);
        assertEquals(1.00,areaMaterial.getCostPerSquareMeter(),"Could not retrieve cost");
    }

}
