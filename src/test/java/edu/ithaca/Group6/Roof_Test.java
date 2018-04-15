package edu.ithaca.Group6;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

        assertFalse(testRoof.setSecondCornerCoordinates(negativeHeight),"Did not reject exception for negative height");
        assertFalse(testRoof.setSecondCornerCoordinates(posX,posY,negZ),"Did not reject for negative height");
        assertFalse(testRoof.setSecondCornerCoordinates(negX,negY,negZ),"Did not reject for negative height");
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
    @org.junit.jupiter.api.Test
    public void setInternalWallHeightTest(){
        testRoof = new RoofImpl();
        double double_dec = 0.5;
        testRoof.setHeight(double_dec);
        assertEquals(testRoof.getHeight(), 0.5, "set internal height failed");
        double_dec = 0.001;
        testRoof.setHeight(double_dec);
        assertEquals(testRoof.getHeight(), .001, "set internal height failed");
        double_dec = 10.1;
        testRoof.setHeight(double_dec);
        assertEquals(testRoof.getHeight(), 10.1, "set internal height failed");
        double_dec = 100.05;
        testRoof.setHeight(double_dec);
        assertEquals(testRoof.getHeight(), 100.05, "set internal height failed");
        double_dec = 45.34561;
        testRoof.setHeight(double_dec);
        assertEquals(testRoof.getHeight(), 45.34561, "set internal height failed");
        testRoof.setHeight(1);
        assertEquals(testRoof.getHeight(), 1, "set internal height failed");
        testRoof.setHeight(10);
        assertEquals( testRoof.getHeight(),10,"set internal wall height test failed");
        testRoof.setHeight(100);
        assertEquals( testRoof.getHeight(),100,"set internal wall height test failed");
        testRoof.setHeight(3242341);
        assertEquals( testRoof.getHeight(),3242341,"set internal wall height test failed");

    }

    @org.junit.jupiter.api.Test
    public void setInternalWallLengthTest(){
        testRoof = new RoofImpl();
        double double_dec = 0.5;
        testRoof.setLength(double_dec);
        assertEquals(testRoof.getLength(), 0.5, "set internal wall length test failed");
        double_dec = 0.001;
        testRoof.setLength(double_dec);
        assertEquals(testRoof.getLength(), .001, "set internal wall length test failed");
        double_dec = 10.1;
        testRoof.setLength(double_dec);
        assertEquals(testRoof.getLength(), 10.1, "set internal wall length test failed");
        double_dec = 100.05;
        testRoof.setLength(double_dec);
        assertEquals(testRoof.getLength(), 100.05, "set internal wall length test failed");
        double_dec = 45.34561;
        testRoof.setLength(double_dec);
        assertEquals(testRoof.getLength(), 45.34561, "set internal length test failed");
        testRoof.setLength(1);
        assertEquals(testRoof.getLength(),1,"set internal wall length test failed");
        testRoof.setLength(10);
        assertEquals(testRoof.getLength(),10,"set internal wall length test failed");
        testRoof.setLength(100);
        assertEquals(testRoof.getLength(),100,"set internal wall length test failed");
        testRoof.setLength(2342344);
        assertEquals(testRoof.getLength(),2342344,"set internal wall length test failed");



    }

    @org.junit.jupiter.api.Test
    public void setRoofWidthTest(){
        testRoof = new RoofImpl();
        double double_dec = 0.5;
        testRoof.setWidth(double_dec);
        assertEquals(double_dec, testRoof.getWidth(), "set roof width test failed");
        double_dec = 0.001;
        testRoof.setWidth(double_dec);
        assertEquals(double_dec, testRoof.getWidth(), "set roof width test failed");
        double_dec = 10.1;
        testRoof.setWidth(double_dec);
        assertEquals(double_dec, testRoof.getWidth(), "set roof width test failed");
        double_dec = 100.05;
        testRoof.setWidth(double_dec);
        assertEquals(double_dec, testRoof.getWidth(), "set roof width test failed");
        double_dec = 45.34561;
        testRoof.setWidth(double_dec);
        assertEquals(double_dec, testRoof.getWidth(), "set roof width test failed");
        int intVal = 1;
        testRoof.setWidth(intVal);
        assertEquals(intVal, testRoof.getWidth(), "set roof width test failed");
        intVal = 10;
        testRoof.setWidth(intVal);
        assertEquals(intVal, testRoof.getWidth(), "set roof width test failed");
        intVal = 100;
        testRoof.setWidth(intVal);
        assertEquals(intVal, testRoof.getWidth(), "set roof width test failed");
        intVal = 2342344;
        testRoof.setWidth(intVal);
        assertEquals(intVal, testRoof.getWidth(), "set roof width test failed");
    }

    @org.junit.jupiter.api.Test
    public void setRoofMaterialTest(){
        testRoof = new RoofImpl();
        MaterialByArea testMaterial = new ClayBrick();
        this.testRoof.setMaterial(testMaterial);
        assertEquals(testMaterial.getMaterialName(), testRoof.getMaterial().getMaterialName(), "set external wall material test failed");
        testMaterial = new Brick();
        this.testRoof.setMaterial(testMaterial);
        assertEquals(testMaterial.getMaterialName(), testRoof.getMaterial().getMaterialName(), "set external wall material test failed");
        testMaterial = new ConcreteBrick();
        this.testRoof.setMaterial(testMaterial);
        assertEquals(testMaterial.getMaterialName(), testRoof.getMaterial().getMaterialName(), "set external wall material test failed");
        testMaterial =  new TwoByFour();
        this.testRoof.setMaterial(testMaterial);
        assertEquals(testMaterial.getMaterialName(), testRoof.getMaterial().getMaterialName(), "set external wall material test failed");
        testMaterial = new TwoByThree();
        this.testRoof.setMaterial(testMaterial);
        assertEquals(testMaterial.getMaterialName(), testRoof.getMaterial().getMaterialName(), "set external wall material test failed");
        testMaterial = new Wood();
        this.testRoof.setMaterial(testMaterial);
        assertEquals(testMaterial.getMaterialName(), testRoof.getMaterial().getMaterialName(), "set external wall material test failed");
    }
}
