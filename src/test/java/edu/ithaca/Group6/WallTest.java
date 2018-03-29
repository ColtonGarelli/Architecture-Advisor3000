package edu.ithaca.Group6;
import org.junit.jupiter.api.Test;
import edu.ithaca.Group6.Wall;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallTest {
    @Test
    public void setWallHeightTest(){
        Wall testWall = new Wall();
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
    public void setWallWidthTest(){

        Wall testWall = new Wall();
        double double_dec = 0.5;
        testWall.setWidth(double_dec);
        assertEquals(testWall.getWidth(), 0.5, "set height failed");
        double_dec = 0.001;
        testWall.setWidth(double_dec);
        assertEquals(testWall.getWidth(), .001, "set height failed");
        double_dec = 10.1;
        testWall.setWidth(double_dec);
        assertEquals(testWall.getWidth(), 10.1, "set height failed");
        double_dec = 100.05;
        testWall.setWidth(double_dec);
        assertEquals(testWall.getWidth(), 100.05, "set height failed");
        double_dec = 45.34561;
        testWall.setWidth(double_dec);
        assertEquals(testWall.getWidth(), 45.34561, "set height failed");
        testWall.setWidth(1);
        assertEquals(testWall.getWidth(),1,"set wall width test failed");
        testWall.setWidth(10);
        assertEquals(testWall.getWidth(),10,"set wall width test failed");
        testWall.setWidth(100);
        assertEquals(testWall.getWidth(),100,"set wall width test failed");
        testWall.setWidth(2342344);
        assertEquals(testWall.getWidth(),2342344,"set wall width test failed");
    }

    @Test
    public void setWallMaterialTest(){
        Wall testWall = new Wall();
        
        assertEquals(true,false,"set wall material test failed");
        assertEquals(true,false,"set wall material test failed");
        assertEquals(true,false,"set wall material test failed");
        assertEquals(true,false,"set wall material test failed");

    }

    @Test
    public void getWallFeatureTest(){

        assertEquals(true,false,"get wall features test failed");
        assertEquals(true,false,"get wall features test failed");
        assertEquals(true,false,"get wall features test failed");
        assertEquals(true,false,"get wall features test failed");
    }

    @Test
    public void addWallFeatureTest(){
        assertEquals(true,false,"add wall feature test failed");
        assertEquals(true,false,"add window test failed");
        assertEquals(true,false,"add door test failed");

    }

    @Test
    public void removeWallFeatureTest(){

        assertEquals(true,false,"remove wall features test failed");
        assertEquals(true,false,"remove wall features test failed");
        assertEquals(true,false,"remove wall features test failed");

    }



}
