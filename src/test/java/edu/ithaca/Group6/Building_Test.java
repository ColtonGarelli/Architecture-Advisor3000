package edu.ithaca.Group6;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Building_Test {

    @Test
    void constructorTest(){
        //test default constructor
        Building building1 = new BuildingImpl();
        //test length
        double length1 = building1.getLength();
        assertEquals(0.0, length1, "Innacurate length - Default Constructor");
        //test width
        double width1 = building1.getWidth();
        assertEquals(0.0, width1, "Innacurate width - Default Constructor");
        //test height
        double height1 = building1.getHeight();
        assertEquals(0.0, height1, "Innacurate height - Default Constructor");
        //test external wall material
        String material1 = building1.getExtWallMaterial();
        assertEquals("drywall", material1, "Innacurate Material - Default Constructor");

        Building building2 = new BuildingImpl(80.0, 50.0, 10.0, "cement");
        //test length
        double length2 = building2.getLength();
        assertEquals(80.0, length2, "Innacurate length");
        //test width
        double width2 = building2.getWidth();
        assertEquals(50.0, width2, "Innacurate width");
        //test height
        double height2 = building2.getHeight();
        assertEquals(10.0, height2, "Innacurate height");
        //test external wall material
        String material2 = building2.getExtWallMaterial();
        assertEquals("cement", material2, "Innacurate Material");
    }

    @Test
    void settersTest(){
        Building building1 = new BuildingImpl();
        //test length setter
        building1.setLength(50.0);
        assertEquals(50.0, building1.getLength(), "Length not set");
        //test width setter
        building1.setWidth(50.0);
        assertEquals(50.0, building1.getWidth(), "Width not set");
        //test height setter
        building1.setHeight(50.0);
        assertEquals(50.0, building1.getHeight(), "Height not set");
        //test ext wall material set
        building1.setExtWallMaterial("cement");
        assertEquals("cement", building1.getExtWallMaterial(), "Material of Exterior Wall not set");
    }

    @Test
    void dimensionTest() {
        Building building1 = new BuildingImpl(60.0, 60.0, 12.0, "cement");
        //test square footage calculation
        double sqftg1 = building1.getSquareFootage();
        assertEquals(3600.0, sqftg1, "Innacurate calculation of square footage");
        //test perimeter calculation
        double perim1 = building1.getPerimeter();
        assertEquals(240.0, perim1, "Innaccurate calculation of perimeter");
    }

    @Test
    public void setWallDimensionsTest(){
       assertEquals(true,false,"set wall dimensions test failed");
    }

    @Test
    public void getWallDimensionTest(){
        assertEquals(true,false,"get wall dimensions test failed");
    }

    @Test
    public void setWallMaterialTest(){
        assertEquals(true,false,"set wall material test failed");

    }

    @Test
    public void getWallMaterialTest(){
        assertEquals(true,false,"set wall material test failed");

    }

    @Test
    public void getWallFeatureTest(){
        assertEquals(true,false,"get wall features test failed");
    }

    @Test
    public void addWallFeatureTest(){
        assertEquals(true,false,"add wall feature test failed");
    }

    @Test
    public void removeWallFeatureTest(){
        assertEquals(true,false,"remove wall features test failed");
    }

    void calcTotalCostTest(){
        Building building1 = new BuildingImpl(60.0, 60.0, 12.0, "cement");
        double totalCost1 = building1.calcTotalCost();
        assertEquals(15840.0, totalCost1, "Innacurate calculation of total cost");
    }
}
