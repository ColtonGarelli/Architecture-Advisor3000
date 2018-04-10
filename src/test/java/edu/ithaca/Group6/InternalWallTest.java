package edu.ithaca.Group6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class InternalWallTest {
    Wall testWall;

    public InternalWallTest(){
        this.testWall = new InternalWall();

    }

    @Test
    public void setInternalWallHeightTest(){

        double double_dec = 0.5;
        testWall.setHeight(double_dec);
        assertEquals(testWall.getHeight(), 0.5, "set internal height failed");
        double_dec = 0.001;
        testWall.setHeight(double_dec);
        assertEquals(testWall.getHeight(), .001, "set internal height failed");
        double_dec = 10.1;
        testWall.setHeight(double_dec);
        assertEquals(testWall.getHeight(), 10.1, "set internal height failed");
        double_dec = 100.05;
        testWall.setHeight(double_dec);
        assertEquals(testWall.getHeight(), 100.05, "set internal height failed");
        double_dec = 45.34561;
        testWall.setHeight(double_dec);
        assertEquals(testWall.getHeight(), 45.34561, "set internal height failed");
        testWall.setHeight(1);
        assertEquals(testWall.getHeight(), 1, "set internal height failed");
        testWall.setHeight(10);
        assertEquals( testWall.getHeight(),10,"set internal wall height test failed");
        testWall.setHeight(100);
        assertEquals( testWall.getHeight(),100,"set internal wall height test failed");
        testWall.setHeight(3242341);
        assertEquals( testWall.getHeight(),3242341,"set internal wall height test failed");
    }
    @Test
    public void setInternalWallLengthTest(){
        double double_dec = 0.5;
        testWall.setLength(double_dec);
        assertEquals(testWall.getLength(), 0.5, "set internal wall length test failed");
        double_dec = 0.001;
        testWall.setLength(double_dec);
        assertEquals(testWall.getLength(), .001, "set internal wall length test failed");
        double_dec = 10.1;
        testWall.setLength(double_dec);
        assertEquals(testWall.getLength(), 10.1, "set internal wall length test failed");
        double_dec = 100.05;
        testWall.setLength(double_dec);
        assertEquals(testWall.getLength(), 100.05, "set internal wall length test failed");
        double_dec = 45.34561;
        testWall.setLength(double_dec);
        assertEquals(testWall.getLength(), 45.34561, "set internal length test failed");
        testWall.setLength(1);
        assertEquals(testWall.getLength(),1,"set internal wall length test failed");
        testWall.setLength(10);
        assertEquals(testWall.getLength(),10,"set internal wall length test failed");
        testWall.setLength(100);
        assertEquals(testWall.getLength(),100,"set internal wall length test failed");
        testWall.setLength(2342344);
        assertEquals(testWall.getLength(),2342344,"set internal wall length test failed");



    }

    @Test
    public void setInternalWallThicknessTest(){
        double double_dec = 0.5;
        testWall.setThickness(double_dec);
        assertEquals(testWall.getWidth(), 0.5, "set internal wall width test failed");
        double_dec = 0.001;
        testWall.setThickness(double_dec);
        assertEquals(testWall.getWidth(), .001, "set internal wall width test failed");
        double_dec = 10.1;
        testWall.setThickness(double_dec);
        assertEquals(testWall.getWidth(), 10.1, "set internal wall width test failed");
        double_dec = 100.05;
        testWall.setThickness(double_dec);
        assertEquals(testWall.getWidth(), 100.05, "set internal wall width test failed");
        double_dec = 45.34561;
        testWall.setThickness(double_dec);
        assertEquals(testWall.getWidth(), 45.34561, "set internal wall width test failed");
        testWall.setThickness(1);
        assertEquals(testWall.getWidth(),1,"set internal wall width test  failed");
        testWall.setThickness(10);
        assertEquals(testWall.getWidth(),10,"set internal wall width test failed");
        testWall.setThickness(100);
        assertEquals(testWall.getWidth(),100,"set internal wall width test failed");
        testWall.setThickness(2342344);
        assertEquals(testWall.getWidth(),2342344,"set internal wall width test failed");
    }

}
