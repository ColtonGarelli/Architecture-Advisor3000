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

    }

    @Test
    public void getMaterialTest(){

    }

    @Test
    public void setAreaCostTest(){

    }

    @Test
    public void getAreaCostTest(){

    }

}
