package edu.ithaca.Group6;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MaterialByArea_Test {
    private MaterialByArea areaMaterial;

    @BeforeEach
    void setup(){
        areaMaterial = new Wood();
    }

    @Test
    public void calcAreaMeterTest(){
        areaMaterial = new Wood();
        double areaFeetZero = 0;
        double areaFeetPos = 7;
        double areaFeetNeg = -7;
        double deltaFactor = 0.002; //how far off the doubles can be

        assertEquals(0, areaMaterial.calcAreaMeter(areaFeetZero), deltaFactor, "Did not calculate area with zero square feet");
        assertEquals(.6503,areaMaterial.calcAreaMeter(areaFeetPos), deltaFactor, "Did not calculate area with positive square feet");
        assertThrows(IndexOutOfBoundsException.class,()->{areaMaterial.calcAreaMeter(areaFeetNeg);},"Did not throw exception with negative square feet");
    }

    @Test
    public void calcCostTest(){
        areaMaterial = new Wood();
        double areaMetersZero = 0;
        double areaMetersPos = 7;
        double areaMetersNeg = -7;
        double deltaFactor = 0.005; //how far off the doubles can be

        assertEquals(0,areaMaterial.calcCost(areaMetersZero),deltaFactor,"Did not calculate cost for zero meters");
        assertEquals(7.00,areaMaterial.calcCost(areaMetersPos),deltaFactor,"Did not calculate cost of positive meters");
        assertThrows(IndexOutOfBoundsException.class,()->{areaMaterial.calcCost(areaMetersNeg);},"Did not throw exception with negative square meters");
    }

    @Test
    public void setMaterialTest(){
        areaMaterial = new Wood();
        String emptyString = "";
        String testMaterial = "Brick";

        areaMaterial.setMaterialName(testMaterial);
        assertEquals("Brick",areaMaterial.getMaterialName(),"Could not set material");

        assertThrows(NullPointerException.class,()->{areaMaterial.setMaterialName(emptyString);},"Did not throw exception for empty string");
    }

    @Test
    public void getMaterialTest(){
        areaMaterial = new Wood();
        assertEquals("Wood",areaMaterial.getMaterialName(),"Could not retrieve name");
    }

    @Test
    public void setAreaCostTest(){
        areaMaterial = new Wood();
        double positiveCost = 7.00;
        double zeroCost = 0;
        double negativeCost = -7.00;


        areaMaterial.setCost(positiveCost);
        assertEquals(positiveCost,areaMaterial.getCostPerSquareFoot(),"Could not change cost to be positive");

        areaMaterial.setCost(zeroCost);
        assertEquals(0,areaMaterial.getCostPerSquareFoot(),"Could not set to zero cost");

        assertThrows(IndexOutOfBoundsException.class,()->{areaMaterial.setCost(negativeCost);},"Did not throw exception with negative cost");
    }

    @Test
    public void getAreaCostTest(){
        areaMaterial = new Wood();
        assertEquals(1.00,areaMaterial.getCostPerSquareFoot(),"Could not retrieve cost");
    }

    @Test
    public void toStringTest(){
        areaMaterial = new Wood();
        String desiredString = "Wood : $1.00 per square foot";
        assertEquals(desiredString,areaMaterial.toString(),"Did not properly do toString");
        areaMaterial = new Brick();
        String desiredString2 = "Brick : $142.34 per square foot";
        assertEquals(desiredString2,areaMaterial.toString(),"Did not toString properly for long decimal");
    }
}
