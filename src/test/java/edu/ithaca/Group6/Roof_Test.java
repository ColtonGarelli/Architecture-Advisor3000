package edu.ithaca.Group6;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Roof_Test {
    private Roof testRoof;

    @Test
    public void testSetCoordinates(){
        testRoof = new RoofImpl();
        testRoof.setFirstCornerCoordinates(0,0,0);
        testRoof.setSecondCornerCoordinates(1,2,3);
        double[] zeroCoords = {0,0,0};
        double[] endCoords = {1,2,3};
        double[] negativeLength = {2,-4,3};
        double[] negativeWidth = {-2,3,4};

        //should throw exception for negative height
        double[] negativeHeight = {1,2,-4};

        assertArrayEquals(zeroCoords,testRoof.getFirstCornerCoordinates(),0.01,"Did not get all zero");
        assertArrayEquals(endCoords,testRoof.getSecondCornerCoordinates(),0.01,"Did not get positive coordinates");

        testRoof.setFirstCornerCoordinates(negativeLength);
        testRoof.setSecondCornerCoordinates(negativeWidth);

        assertArrayEquals(negativeLength,testRoof.getFirstCornerCoordinates(),0.01,"Did not get with negative y");
        assertArrayEquals(negativeWidth, testRoof.getSecondCornerCoordinates(),0.01,"Did not get with negative x");

        assertThrows(IndexOutOfBoundsException.class,()->{testRoof.setSecondCornerCoordinates(negativeHeight);},"Did not throw exception for negative height");


    }

    @Test
    public void testGetCoordinates(){
        testRoof = new RoofImpl();
        double[] zeroCoords = {0,0,0};
        double[] endCoords = {1,2,3};

        assertArrayEquals(zeroCoords,testRoof.getFirstCornerCoordinates());
    }
}
