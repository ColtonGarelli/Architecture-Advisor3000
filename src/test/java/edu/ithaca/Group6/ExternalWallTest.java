package edu.ithaca.Group6;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(testWall.getWidth(), 0.5, "set wall width test failed");
        double_dec = 0.001;
        testWall.setThickness(double_dec);
        assertEquals(testWall.getWidth(), .001, "set wall width test failed");
        double_dec = 10.1;
        testWall.setThickness(double_dec);
        assertEquals(testWall.getWidth(), 10.1, "set wall width test failed");
        double_dec = 100.05;
        testWall.setThickness(double_dec);
        assertEquals(testWall.getWidth(), 100.05, "set wall width test failed");
        double_dec = 45.34561;
        testWall.setThickness(double_dec);
        assertEquals(testWall.getWidth(), 45.34561, "set wall width test failed");
        testWall.setThickness(1);
        assertEquals(testWall.getWidth(),1,"set wall width test  failed");
        testWall.setThickness(10);
        assertEquals(testWall.getWidth(),10,"set wall width test failed");
        testWall.setThickness(100);
        assertEquals(testWall.getWidth(),100,"set wall width test failed");
        testWall.setThickness(2342344);
        assertEquals(testWall.getWidth(),2342344,"set wall width test failed");
    }


    @Test
    public void setExternalWallMaterialTest(){
        MaterialByArea testMaterial = new ClayBrick();
        this.testWall.setMaterial(testMaterial);


    }

    @Test
    public void getExternalWallFeatureTest(){
        MaterialByUnit testDoor = new Door();
        MaterialByUnit testBrick = new Door();
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
    public void removeExternalWallFeatureTest(){

//         assertEquals(true,false,"remove wall features test failed");
//         assertEquals(true,false,"remove wall features test failed");
//         assertEquals(true,false,"remove wall features test failed");

    }

    @Test
    public void changeWallLength(){

    }



}
