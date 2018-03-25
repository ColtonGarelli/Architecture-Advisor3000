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
        boolean thrown = false;
        assertEquals(0, areaMaterial.calcAreaMeter(areaFeetZero), "Did not calculate area with zero square feet");
        assertEquals(.6503,areaMaterial.calcAreaMeter(areaFeetPos),"Did not calculate area with positive square feet");
        assertThrows(IndexOutOfBoundsException.class,()->{areaMaterial.calcAreaMeter(areaFeetNeg);},"Did not throw exception with negative square feet");
    }

    @Test
    public void calcCostTest(){

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
