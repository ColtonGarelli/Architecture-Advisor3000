package edu.ithaca.Group6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaterialByUnit_Test {
    private MaterialByUnit testMaterial;

    @BeforeEach
    void setup() {testMaterial = new Door();}

    @Test
    public void getterTest(){
        //Test the getters of the object
        assertEquals("Door", testMaterial.getMaterialName(), "Did not correctly get material name");
        assertEquals(900.00, testMaterial.getCostPerUnit(), "Did not correctly get cost per unit");
        assertEquals(3.0, testMaterial.getLength(), "Did not correctly get length");
        assertEquals(6.67, testMaterial.getHeight(), "Did not correctly get height");
    }
}
