package edu.ithaca.Group6;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Building_Test {
    private MaterialByArea newMaterial1;
    private MaterialByArea newMaterial2;

    @BeforeEach
    void setup() {
        newMaterial1 = new ClayBrick();
        newMaterial2 = new Wood();
    }

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

        Building building2 = new BuildingImpl(80.0, 50.0, 10.0);
        //test length
        double length2 = building2.getLength();
        assertEquals(80.0, length2, "Innacurate length");
        //test width
        double width2 = building2.getWidth();
        assertEquals(50.0, width2, "Innacurate width");
        //test height
        double height2 = building2.getHeight();
        assertEquals(10.0, height2, "Innacurate height");
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
    }

    @Test
    void dimensionTest() {
        Building building1 = new BuildingImpl(60.0, 60.0, 12.0);
        //test square footage calculation
        double sqftg1 = building1.getSquareFootage();
        assertEquals(3600.0, sqftg1, "Innacurate calculation of square footage");
        //test perimeter calculation
        double perim1 = building1.getPerimeter();
        assertEquals(240.0, perim1, "Innaccurate calculation of perimeter");
    }

    /**@Test
    void calcTotalCostTest(){
        Building building1 = new BuildingImpl(60.0, 60.0, 12.0);
        double totalCost1 = building1.calcTotalCost();
        assertEquals(115.2, totalCost1, "Innacurate calculation of total cost");
    }*/

    @Test
    void addWallTest(){
        //setup
        BuildingImpl building = new BuildingImpl(50.0, 50.0, 50.0);
        Wood wood = new Wood();

        //trying to add the first wall out of bounds (start point)
        //x position out of bounds
        double[] firstStartPointOutX = new double[]{51.0, 0.0, 0.0};
        InternalWall firstWallOutX = new InternalWall(1.0, 1.0, 1.0, firstStartPointOutX, wood);
        assertFalse(building.addWall(firstWallOutX), "Added a wall when the start point of the first wall x value was out of bounds");
        //y position out of bounds
        double[] firstStartPointOutY = new double[]{0.0, 51.0, 0.0};
        InternalWall firstWallOutY = new InternalWall(1.0, 1.0, 1.0, firstStartPointOutY, wood);
        assertFalse(building.addWall(firstWallOutY), "Added a wall when the start point of the first wall y value was out of bounds");
        //z position out of bounds
        double[] firstStartPointOutZ = new double[]{0.0, 0.0, 51.0};
        InternalWall firstWallOutZ = new InternalWall(1.0, 1.0, 1.0, firstStartPointOutZ, wood);
        assertFalse(building.addWall(firstWallOutZ), "Added a wall when the start point of the first wall x value was out of bounds");

        //trying to add the first wall out of bounds (end point)
        //x position out of bounds
        double[] firstEndPointOut = new double[]{0.0, 0.0, 0.0};
        firstWallOutX = new InternalWall(1.0, 51.0, 1.0, firstEndPointOut, wood);
        assertFalse(building.addWall(firstWallOutX), "Added a wall when the end point of the first wall x value was out of bounds");
        //y position out of bounds
        firstWallOutY = new InternalWall(1.0, 1.0, 51.0, firstEndPointOut, wood);
        assertFalse(building.addWall(firstWallOutY), "Added a wall when the end point of the first wall y value was out of bounds");
        //z position out of bounds
        firstWallOutZ = new InternalWall(51.0, 1.0, 1.0, firstEndPointOut, wood);
        assertFalse(building.addWall(firstWallOutZ), "Added a wall when the end point of the first wall x value was out of bounds");

        //Testing for a wall starting somewhere within the building ending out of bounds
        //x position out of bounds
        double[] endPointOut = new double[]{25.0, 25.0, 25.0};
        InternalWall wallOutX = new InternalWall(1.0, 26.0, 1.0, endPointOut, wood);
        assertFalse(building.addWall(wallOutX), "Added a wall when the end point of the first wall x value was out of bounds");
        //y position out of bounds
        InternalWall wallOutY = new InternalWall(1.0, 1.0, 26.0, endPointOut, wood);
        assertFalse(building.addWall(wallOutY), "Added a wall when the end point of the first wall y value was out of bounds");
        //z position out of bounds
        InternalWall wallOutZ = new InternalWall(26.0, 1.0, 1.0, endPointOut, wood);
        assertFalse(building.addWall(wallOutZ), "Added a wall when the end point of the first wall x value was out of bounds");

        //Adding the first wall
        double[] startPoint = new double[]{10.0, 10.0, 10.0};
        InternalWall wall1 = new InternalWall(30.0, 30.0, 30.0, startPoint, wood);
        boolean added = building.addWall(wall1);
        double[] endPoint = new double[]{40.0, 40.0, 40.0};
        System.out.println(wall1.getBottomLeftOutsideCoordinates()[0]);
        assertTrue(added, "Wall not added");
        assertEquals(30.0, wall1.getLength(), "Wall length not properly set when adding");
        assertEquals(30.0, wall1.getThickness(), "Wall width not properly set when adding");
        assertEquals(30.0, wall1.getHeight(), "Wall height not properly set when adding");
        assertArrayEquals(startPoint, wall1.getBottomLeftOutsideCoordinates(), "Wall start point not properly set when adding");
        assertEquals(wood, wall1.getMaterial(), "Wall material not properly set when adding");
        assertArrayEquals(endPoint, building.walls[0].getTopRightInsideCoordinates(), "Wall end point not properly set when adding");

        //Test for overlapping walls
        //Case 1: start point of new wall is within existing wall
        //x value
        double[] startPoint2 = new double[]{15.0, 0.0, 0.0};
        InternalWall wall2 = new InternalWall(30.0, 41.0, 41.0, startPoint2, wood);
        assertFalse(building.addWall(wall2), "Added wall whose start point overlaps exising wall in x position");
        //y value
        double[] startPoint3 = new double[]{0.0, 15.0, 0.0};
        InternalWall wall3 = new InternalWall(41.0, 30.0, 41.0, startPoint3, wood);
        assertFalse(building.addWall(wall3), "Added wall whose start point overlaps exising wall in y position");
        //z value
        double[] startPoint4 = new double[]{0.0, 0.0, 15.0};
        InternalWall wall4 = new InternalWall(41.0, 41.0, 30.0, startPoint4, wood);
        assertFalse(building.addWall(wall4), "Added wall whose start point overlaps exising wall in z position");
    }
}
