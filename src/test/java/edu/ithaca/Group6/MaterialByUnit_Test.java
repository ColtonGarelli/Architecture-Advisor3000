package edu.ithaca.Group6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MaterialByUnit_Test {
    private MaterialByUnit testMaterial;
    private MaterialByUnit testMaterial2;

    @BeforeEach
    void setup() {
        testMaterial = new Door();
        testMaterial2 = new Door();
    }

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

    @Test
    public void setOrientationTest(){
        testMaterial.setOrientation(1);
        assertEquals(1, testMaterial.getOrientation(), "Did not correctly set orientation");
    }

    @Test
    public void setStartPointTest(){
        testMaterial.setStartPoint(1, 2, 3);
        assertEquals(1.0, testMaterial.getStartPoint()[0], "Start point x not set");
        assertEquals(2.0, testMaterial.getStartPoint()[1], "Start point y not set");
        assertEquals(3.0, testMaterial.getStartPoint()[2], "Start point z not set");
        double[] newPoint = new double[]{1, 2, 3};
        assertArrayEquals(newPoint, testMaterial.getStartPoint(), "Start point not properly set");
    }

    @Test
    public void getEndPointTest(){
        testMaterial.setStartPoint(0, 0, 0);
        double[] endPoint1 = testMaterial.getEndPoint();
        assertEquals(3.0, endPoint1[0], "x value of endpoint not properly set for horizontal object");
        assertEquals(0.15, endPoint1[1], "y value of endpoint not properly set for horizontal object");
        assertEquals(6.67, endPoint1[2], "z value of endpoint not properly set for horizontal object");
        testMaterial2.setOrientation(1);
        double[] endPoint2 = testMaterial2.getEndPoint();
        assertEquals(0.15, endPoint2[0], "x value of endpoint not properly set for vertical object");
        assertEquals(3.0, endPoint2[1], "y value of endpoint not properly set for vertical object");
        assertEquals(6.67, endPoint2[2], "z value of endpoint not properly set for vertical object");
    }
}
