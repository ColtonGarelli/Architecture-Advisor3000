package edu.ithaca.Group6;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Roof_Test {
    private Roof testRoof;

    @Test
    public void testSetCoordinates(){
        testRoof = new RoofImpl();
        testRoof.setFirstCornerCoordinates(0,0,0);
        testRoof.setSecondCornerCoordinates(1,2,3);



    }

    @Test
    public void testGetCoordinates(){
        testRoof = new RoofImpl();
        double[] zeroCoords = {0,0,0};
        double[] endCoords = {1,2,3};

        assertArrayEquals(zeroCoords,testRoof.getFirstCornerCoordinates());
    }
}
