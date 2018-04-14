package edu.ithaca.Group6;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Roof_Test {
    private Roof testRoof;

    @Test
    public void testSetCoordinates(){
        testRoof = new RoofImpl();
        double posX = 2;
        double posY = 3;
        double posZ = 4;

        double negX = -4;
        double negY = -3;
        double negZ = -2;
        testRoof.setFirstCornerCoordinates(0,0,0);
        testRoof.setSecondCornerCoordinates(posX,posY,posZ);
        double[] zeroCoords = {0,0,0};
        double[] endCoords = {posX,posY,posZ};

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
        assertThrows(IndexOutOfBoundsException.class,()->{testRoof.setSecondCornerCoordinates(posX,posY,negZ);},"Did not throw exception for negative height");
        assertThrows(IndexOutOfBoundsException.class,()->{testRoof.setSecondCornerCoordinates(negX,negY,negZ);},"Did not throw exception for negative height");
    }

    @Test
    public void testGetCoordinates(){
        testRoof = new RoofImpl();
        double posX = 2;
        double posY = 3;
        double posZ = 4;

        double negX = -4;
        double negY = -3;
        double negZ = -2;
        double[] zeroCoords = {0,0,0};
        double[] endCoords = {posX,posY,posZ};

        testRoof.setSecondCornerCoordinates(endCoords);

        assertArrayEquals(zeroCoords,testRoof.getFirstCornerCoordinates(),"Did not get first coords");
        assertArrayEquals(endCoords,testRoof.getSecondCornerCoordinates(),"Did not get second coords");
    }
}
