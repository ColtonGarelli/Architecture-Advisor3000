package edu.ithaca.Group6;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.lang.Math;

public class ExternalWallTest {
    Wall testWall;

    public ExternalWallTest(){
        this.testWall = new ExternalWall();
    }

    @Test
    public void setExternalWallHeightTest(){

        double double_dec = 0.5;
        testWall.setHeight(double_dec);
        assertEquals(testWall.getHeight(), 0.5, "set height failed");
        double_dec = 0.001;
        testWall.setHeight(double_dec);
        assertEquals(testWall.getHeight(), .001, "set height failed");
        double_dec = 10.1;
        testWall.setHeight(double_dec);
        assertEquals(testWall.getHeight(), 10.1, "set height failed");
        double_dec = 100.05;
        testWall.setHeight(double_dec);
        assertEquals(testWall.getHeight(), 100.05, "set height failed");
        double_dec = 45.34561;
        testWall.setHeight(double_dec);
        assertEquals(testWall.getHeight(), 45.34561, "set height failed");
        testWall.setHeight(1);
        assertEquals(testWall.getHeight(), 1, "set height failed");
        testWall.setHeight(10);
        assertEquals( testWall.getHeight(),10,"set wall height test failed");
        testWall.setHeight(100);
        assertEquals( testWall.getHeight(),100,"set wall height test failed");
        testWall.setHeight(3242341);
        assertEquals( testWall.getHeight(),3242341,"set wall height test failed");
    }
    @Test
    public void setExternalWallLengthTest(){
        double double_dec = 0.5;
        testWall.setLength(double_dec);
        assertEquals(testWall.getLength(), 0.5, "set wall length test failed");
        double_dec = 0.001;
        testWall.setLength(double_dec);
        assertEquals(testWall.getLength(), .001, "set wall length test failed");
        double_dec = 10.1;
        testWall.setLength(double_dec);
        assertEquals(testWall.getLength(), 10.1, "set wall length test failed");
        double_dec = 100.05;
        testWall.setLength(double_dec);
        assertEquals(testWall.getLength(), 100.05, "set wall length test failed");
        double_dec = 45.34561;
        testWall.setLength(double_dec);
        assertEquals(testWall.getLength(), 45.34561, "set length test failed");
        testWall.setLength(1);
        assertEquals(testWall.getLength(),1,"set wall length test failed");
        testWall.setLength(10);
        assertEquals(testWall.getLength(),10,"set wall length test failed");
        testWall.setLength(100);
        assertEquals(testWall.getLength(),100,"set wall length test failed");
        testWall.setLength(2342344);
        assertEquals(testWall.getLength(),2342344,"set wall length test failed");



    }

    @Test
    public void setExternalWallThicknessTest(){
        double double_dec = 0.5;
        testWall.setThickness(double_dec);
        assertEquals(testWall.getThickness(), 0.5, "set wall width test failed");
        double_dec = 0.001;
        testWall.setThickness(double_dec);
        assertEquals(testWall.getThickness(), .001, "set wall width test failed");
        double_dec = 10.1;
        testWall.setThickness(double_dec);
        assertEquals(testWall.getThickness(), 10.1, "set wall width test failed");
        double_dec = 100.05;
        testWall.setThickness(double_dec);
        assertEquals(testWall.getThickness(), 100.05, "set wall width test failed");
        double_dec = 45.34561;
        testWall.setThickness(double_dec);
        assertEquals(testWall.getThickness(), 45.34561, "set wall width test failed");
        testWall.setThickness(1);
        assertEquals(testWall.getThickness(),1,"set wall width test  failed");
        testWall.setThickness(10);
        assertEquals(testWall.getThickness(),10,"set wall width test failed");
        testWall.setThickness(100);
        assertEquals(testWall.getThickness(),100,"set wall width test failed");
        testWall.setThickness(2342344);
        assertEquals(testWall.getThickness(),2342344,"set wall width test failed");
    }


    @Test
    public void setExternalWallMaterialTest(){
        MaterialByArea testMaterial = new ClayBrick();
        this.testWall.setMaterial(testMaterial);
        assertEquals(testMaterial.getMaterialName(), testWall.getMaterial().getMaterialName(), "set external wall material test failed");
        testMaterial = new Brick();
        this.testWall.setMaterial(testMaterial);
        assertEquals(testMaterial.getMaterialName(), testWall.getMaterial().getMaterialName(), "set external wall material test failed");
        testMaterial = new ConcreteBrick();
        this.testWall.setMaterial(testMaterial);
        assertEquals(testMaterial.getMaterialName(), testWall.getMaterial().getMaterialName(), "set external wall material test failed");
        testMaterial =  new TwoByFour();
        this.testWall.setMaterial(testMaterial);
        assertEquals(testMaterial.getMaterialName(), testWall.getMaterial().getMaterialName(), "set external wall material test failed");
        testMaterial = new TwoByThree();
        this.testWall.setMaterial(testMaterial);
        assertEquals(testMaterial.getMaterialName(), testWall.getMaterial().getMaterialName(), "set external wall material test failed");
        testMaterial = new Wood();
        this.testWall.setMaterial(testMaterial);
        assertEquals(testMaterial.getMaterialName(), testWall.getMaterial().getMaterialName(), "set external wall material test failed");
    }

    @Test
    public void getExternalWallFeatureTest(){
        MaterialByUnit testDoor = new Door();
        testWall.addFeature(testDoor);
        assertEquals(testDoor,testWall.getFeature(0),"get wall features test failed");
        testWall.addFeature(testDoor);
        testWall.addFeature(testDoor);
        testWall.addFeature(testDoor);
        testWall.addFeature(testDoor);
        for (int i=0; i<15; i++){
            testWall.addFeature(testDoor);

        }
        for(int i = 0; i<testWall.getFeatureListSize(); i++){
             assertEquals(testDoor, testWall.getFeature(i),"get wall features test failed");
        }
    }

    @Test
    public void setExteriorWallDimensionsTest(){
        boolean setCheck;
        double[] test_dimensions = new double[3];
        test_dimensions[0] = 1;
        test_dimensions[1] = 2;
        test_dimensions[2] = 3;
        setCheck = this.testWall.setTopCoordinates(test_dimensions[0],test_dimensions[1], test_dimensions[2]);
        assertEquals(test_dimensions[0], testWall.getTopCoordinates()[0], "set Interior Wall dimensions test fail");
        assertEquals(test_dimensions[1], testWall.getTopCoordinates()[1], "set Interior Wall dimensions test fail");
        assertEquals(test_dimensions[2], testWall.getTopCoordinates()[2], "set Interior Wall dimensions test fail");

        test_dimensions[0] = 10;
        test_dimensions[1] = 25;
        test_dimensions[2] = 2;
        setCheck = this.testWall.setTopCoordinates(test_dimensions[0],test_dimensions[1], test_dimensions[2]);
        assertEquals(test_dimensions[0], testWall.getTopCoordinates()[0], "set Interior Wall dimensions test fail");
        assertEquals(test_dimensions[1], testWall.getTopCoordinates()[1], "set Interior Wall dimensions test fail");
        assertEquals(test_dimensions[2], testWall.getTopCoordinates()[2], "set Interior Wall dimensions test fail");

        test_dimensions[0] = 45;
        test_dimensions[1] = 20;
        test_dimensions[2] = 1;
        setCheck = this.testWall.setTopCoordinates(test_dimensions[0],test_dimensions[1], test_dimensions[2]);
        assertEquals(test_dimensions[0], testWall.getTopCoordinates()[0], "set Interior Wall dimensions test fail");
        assertEquals(test_dimensions[1], testWall.getTopCoordinates()[1], "set Interior Wall dimensions test fail");
        assertEquals(test_dimensions[2], testWall.getTopCoordinates()[2], "set Interior Wall dimensions test fail");

        test_dimensions[0] = 0;
        test_dimensions[1] = 2;
        test_dimensions[2] = 3;
        setCheck = this.testWall.setTopCoordinates(test_dimensions[0],test_dimensions[1], test_dimensions[2]);
        assertTrue(setCheck);
        Assertions.assertNotEquals(test_dimensions, testWall.getTopCoordinates(), "set Interior Wall dimensions test fail");

        test_dimensions[0] = 1;
        test_dimensions[1] = -2;
        test_dimensions[2] = 3;
        setCheck = this.testWall.setTopCoordinates(test_dimensions[0],test_dimensions[1], test_dimensions[2]);
        Assertions.assertFalse(setCheck);
        Assertions.assertNotEquals(test_dimensions, testWall.getTopCoordinates(), "set Interior Wall dimensions test fail");

        test_dimensions[0] = 1;
        test_dimensions[1] = 2;
        test_dimensions[2] = 0;
        setCheck = this.testWall.setTopCoordinates(test_dimensions[0],test_dimensions[1], test_dimensions[2]);
        assertTrue(setCheck);
        Assertions.assertNotEquals(test_dimensions, testWall.getTopCoordinates(), "set Interior Wall dimensions test fail");



        test_dimensions[0] = 1;
        test_dimensions[1] = 2;
        test_dimensions[2] = 3;
        setCheck = this.testWall.setBottomCoordinates(test_dimensions[0],test_dimensions[1], test_dimensions[2]);
        assertEquals(test_dimensions[0], testWall.getBottomCoordinates()[0], "set Interior Wall dimensions test fail");
        assertEquals(test_dimensions[1], testWall.getBottomCoordinates()[1], "set Interior Wall dimensions test fail");
        assertEquals(test_dimensions[2], testWall.getBottomCoordinates()[2], "set Interior Wall dimensions test fail");

        test_dimensions[0] = 10;
        test_dimensions[1] = 25;
        test_dimensions[2] = 2;
        setCheck = this.testWall.setBottomCoordinates(test_dimensions[0],test_dimensions[1], test_dimensions[2]);
        assertEquals(test_dimensions[0], testWall.getBottomCoordinates()[0], "set Interior Wall dimensions test fail");
        assertEquals(test_dimensions[1], testWall.getBottomCoordinates()[1], "set Interior Wall dimensions test fail");
        assertEquals(test_dimensions[2], testWall.getBottomCoordinates()[2], "set Interior Wall dimensions test fail");

        test_dimensions[0] = 45;
        test_dimensions[1] = 20;
        test_dimensions[2] = 1;
        setCheck = this.testWall.setBottomCoordinates(test_dimensions[0],test_dimensions[1], test_dimensions[2]);
        assertEquals(test_dimensions[0], testWall.getBottomCoordinates()[0], "set Interior Wall dimensions test fail");
        assertEquals(test_dimensions[1], testWall.getBottomCoordinates()[1], "set Interior Wall dimensions test fail");
        assertEquals(test_dimensions[2], testWall.getBottomCoordinates()[2], "set Interior Wall dimensions test fail");

        test_dimensions[0] = 0;
        test_dimensions[1] = 2;
        test_dimensions[2] = 3;
        setCheck = this.testWall.setBottomCoordinates(test_dimensions[0],test_dimensions[1], test_dimensions[2]);
        assertTrue(setCheck);
        Assertions.assertNotEquals(test_dimensions, testWall.getBottomCoordinates(), "set Interior Wall dimensions test fail");

        test_dimensions[0] = 1;
        test_dimensions[1] = -2;
        test_dimensions[2] = 3;
        setCheck = this.testWall.setBottomCoordinates(test_dimensions[0],test_dimensions[1], test_dimensions[2]);
        Assertions.assertFalse(setCheck);
        Assertions.assertNotEquals(test_dimensions, testWall.getBottomCoordinates(), "set Interior Wall dimensions test fail");

        test_dimensions[0] = 1;
        test_dimensions[1] = 2;
        test_dimensions[2] = 0;
        setCheck = this.testWall.setBottomCoordinates(test_dimensions[0],test_dimensions[1], test_dimensions[2]);
        assertTrue(setCheck);
        Assertions.assertNotEquals(test_dimensions, testWall.getBottomCoordinates(), "set Interior Wall dimensions test fail");

    }

    @Test
    public void testCalcArea(){
        double[] test_dimensions = new double[3];
        test_dimensions[0] = 2;
        test_dimensions[1] = 2;
        test_dimensions[2] = 2;
        this.testWall.setLength(test_dimensions[0]);
        this.testWall.setThickness(test_dimensions[1]);
        this.testWall.setHeight(test_dimensions[2]);
        assertEquals(8, this.testWall.getArea(), "Did not correctly calculate area");
        test_dimensions[0] = 3;
        test_dimensions[1] = 2;
        test_dimensions[2] = 2;
        this.testWall.setLength(test_dimensions[0]);
        this.testWall.setThickness(test_dimensions[1]);
        this.testWall.setHeight(test_dimensions[2]);
        assertEquals(12, this.testWall.getArea(), "Did not correctly calculate area - x");
        test_dimensions[0] = 2;
        test_dimensions[1] = 3;
        test_dimensions[2] = 2;
        this.testWall.setLength(test_dimensions[0]);
        this.testWall.setThickness(test_dimensions[1]);
        this.testWall.setHeight(test_dimensions[2]);
        assertEquals(12, this.testWall.getArea(), "Did not correctly calculate area - y");
        test_dimensions[0] = 2;
        test_dimensions[1] = 2;
        test_dimensions[2] = 3;
        this.testWall.setLength(test_dimensions[0]);
        this.testWall.setThickness(test_dimensions[1]);
        this.testWall.setHeight(test_dimensions[2]);
        assertEquals(12, this.testWall.getArea(), "Did not correctly calculate area - z");
    }

    @Test
    public void testCalcCost(){
        this.testWall.setLength(2);
        this.testWall.setThickness(2);
        this.testWall.setHeight(2);
        MaterialByArea testMaterial = new Wood();
        this.testWall.setMaterial(testMaterial);
        assertEquals(8.0, this.testWall.calcCost(), "Did not correctly calculate cost");
        testMaterial = new TwoByFour();
        this.testWall.setMaterial(testMaterial);
        assertEquals(13.28, this.testWall.calcCost(), "Did not correctly calculate cost - Two-By-Four");
    }

    @Test
    public void testAddFeature(){
        MaterialByUnit testDoor = new SlidingDoor();
        MaterialByUnit testWindow = new PictureWindow();

        assertTrue(this.testWall.addFeature(testDoor),"Did not properly add door");
        assertTrue(this.testWall.addFeature(testWindow),"Did not add window");
        assertTrue(this.testWall.addFeature(testDoor),"Did not add a second door");

        assertEquals(testDoor,this.testWall.getFeature(0),"Did not get door");
        assertEquals(testWindow,this.testWall.getFeature(1),"Did not get window");
        assertEquals(testDoor,this.testWall.getFeature(2),"Did not get second door");
    }

    @Test
    public void testRemoveFeature(){
        MaterialByUnit testDoor = new SlidingDoor();
        MaterialByUnit testWindow = new PictureWindow();
        this.testWall.addFeature(testDoor);
        this.testWall.addFeature(testWindow);

        assertFalse(this.testWall.removeFeature(this.testWall.getFeatureListSize()),"Removed improper index");

        assertTrue(this.testWall.removeFeature(0),"Did not remove door");
        assertTrue(this.testWall.removeFeature(0),"Did not remove window");

        assertFalse(this.testWall.removeFeature(this.testWall.getFeatureListSize()),"Removed nonexistent feature");
        assertFalse(this.testWall.removeFeature(-1),"Removed improper index");
    }

    @Test
    void testCalcCorrection(){
        ExternalWall testWall = new ExternalWall();
        ExternalWall testWall2 = new ExternalWall();
        //1.00
        testWall.setMaterial(new Wood());
        //142.34231564
        testWall2.setMaterial(new Brick());
        testWall.setLength(50);
        testWall.setHeight(60);
        testWall.setThickness(.5);
        double wall1Cost = 50*60*.5;
        wall1Cost = wall1Cost-(.5*.5)/2;
        testWall2.setLength(30);
        testWall2.setHeight(60);
        testWall2.setThickness(.5);
        double wall2Cost = 30*60*.5;
        wall2Cost =wall2Cost-(.5*.5)/2;
        wall2Cost = wall2Cost*142.34231564;
        assertEquals(Math.round(wall1Cost), Math.round(testWall.calcCost()), "Wall cost was not corrected for overlap");
        assertEquals(Math.round(wall2Cost), Math.round(testWall2.calcCost()), "Wall cost was not corrected for overlap");

    }

}
