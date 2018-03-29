package edu.ithaca.Group6;
import org.junit.jupiter.api.Test;
import edu.ithaca.Group6.Wall;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallTest {
    @Test
    public void setWallHeightTest(){
        Wall testWall = new Wall();
        testWall.setHeight(-100);
        assertEquals( testWall.getHeight(),false,"set wall height test failed");
        testWall.setHeight(-1);
        assertEquals( testWall.getHeight(),false,"set wall height test failed");
        testWall.setHeight(0);
        assertEquals( testWall.getHeight(),false,"set wall height test failed");
        testWall.setHeight(10);
        assertEquals( testWall.getHeight(),true,"set wall height test failed");
        testWall.setHeight(100);
        assertEquals( testWall.getHeight(),true,"set wall height test failed");
        testWall.setHeight(3242341);
        assertEquals( testWall.getHeight(),true,"set wall height test failed");
    }

    @Test
    public void setWallWidthTest(){

        Wall testWall = new Wall();
        testWall.setWidth(-100);
        assertEquals(testWall.getWidth(),false,"get wall width test failed");
        testWall.setWidth(-1);
        assertEquals(testWall.getWidth(),false,"get wall width test failed");
        testWall.setWidth(0);
        assertEquals(testWall.getWidth(),false,"get wall width test failed");
        testWall.setWidth(10);
        assertEquals(testWall.getWidth(),true,"get wall width test failed");
        testWall.setWidth(100);
        assertEquals(testWall.getWidth(),true,"get wall width test failed");
        testWall.setWidth(2342344);
        assertEquals(testWall.getWidth(),true,"get wall width test failed");
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
