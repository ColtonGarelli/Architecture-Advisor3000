package edu.ithaca.Group6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MaterialByUnit_Test {
    private MaterialByUnit testMaterial;

    @BeforeEach
    void setup() {testMaterial = new Door();}

    @Test
    public void getterTest(){
        //Test the getters of the object
        double[] defaultPos = new double[]{0.0, 0.0, 0.0};
        assertEquals("Door", testMaterial.getMaterialName(), "Did not correctly get material name");
        assertEquals(900.00, testMaterial.getCostPerUnit(), "Did not correctly get cost per unit");
        assertEquals(3.0, testMaterial.getLength(), "Did not correctly get length");
        assertEquals(.15, testMaterial.getWidth(), "Did not correctly get width");
        assertEquals(6.67, testMaterial.getHeight(), "Did not correctly get height");
        assertEquals(0, testMaterial.getOrientation(), "Did not correctly get orientation");
        assertArrayEquals(defaultPos, testMaterial.getStartPoint(), "Did not correctly get start point");
    }

    @Test
    public void toStringTest(){
        //test that the material's data is outputted as a properly formatted string
        assertEquals("Door, $900.00, Length: 3.0ft, Width: 0.15ft, Height: 6.67ft", testMaterial.toString(), "Did not print a properly formatted string");
    }
}
