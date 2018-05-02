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

    @Test
    void calcTotalCostTest(){
        Building building1 = new BuildingImpl(60.0, 60.0, 12.0);
        MaterialByArea testMaterial1 = new Wood();
        MaterialByArea testMaterial2 = new TwoByFour();
        double[] startPoint1 = new double[]{0.0, 0.0, 0.0};
        double totalCost1 = building1.calcTotalCost();
        assertEquals(0, totalCost1, "Innacurate calculation of total cost - No Walls");
        ExternalWall wall1 = new ExternalWall(12, 5, 5, startPoint1, testMaterial1);
        building1.addWall(wall1);
        assertEquals(300, building1.calcTotalCost(), "Innacurate calculation of total cost - One Wall");
        double[] startPoint2 = new double[]{55.0, 0.0, 0.0};
        ExternalWall wall2 = new ExternalWall(12, 5, 5, startPoint2, testMaterial1);
        building1.addWall(wall2);
        assertEquals(600, building1.calcTotalCost(), "Innacurate calculation of total cost - Two Walls");
        double[] startPoint3 = new double[]{30.0, 0.0, 0.0};
        ExternalWall wall3 = new ExternalWall(12, 5, 5, startPoint3, testMaterial2);
        building1.addWall(wall3);
        assertEquals(1098, building1.calcTotalCost(), "Innacurate calculation of total cost - Walls of Different Materials");

        MaterialByUnit testDoor = new Door();
        building1.addWallFeature(0, testDoor, startPoint1);
        assertEquals(1998, building1.calcTotalCost(), "Innaccurate Calculation of total cost - One Feature in One Wall");
        MaterialByUnit testWindow = new PictureWindow();
        double[] startPoint4 = new double[]{0.0, 0.0, 10.0};
        building1.addWallFeature(0, testWindow, startPoint4);
        assertEquals(2250, building1.calcTotalCost(), "Innaccurate Calculation of total cost - Two Features in One Wall");
        building1.addWallFeature(0, testDoor, startPoint2);
        assertEquals(3150, building1.calcTotalCost(), "Innaccurate Calculation of total cost - Mulitple Features in Multiple Walls");
    }

//    @Test
//    void addWallTest(){
//        //setup
//        BuildingImpl building = new BuildingImpl(50.0, 50.0, 50.0);
//        Wood wood = new Wood();
//
//        //trying to add the first wall out of bounds (start point)
//        //x position out of bounds
//        double[] firstStartPointOutX = new double[]{51.0, 0.0, 0.0};
//        ExternalWall firstWallOutX = new ExternalWall(1.0, 1.0, 1.0, firstStartPointOutX, wood);
//        assertFalse(building.addWall(firstWallOutX), "Added a wall when the start point of the first wall x value was out of bounds");
//        //y position out of bounds
//        double[] firstStartPointOutY = new double[]{0.0, 51.0, 0.0};
//        ExternalWall firstWallOutY = new ExternalWall(1.0, 1.0, 1.0, firstStartPointOutY, wood);
//        assertFalse(building.addWall(firstWallOutY), "Added a wall when the start point of the first wall y value was out of bounds");
//        //z position out of bounds
//        double[] firstStartPointOutZ = new double[]{0.0, 0.0, 51.0};
//        ExternalWall firstWallOutZ = new ExternalWall(1.0, 1.0, 1.0, firstStartPointOutZ, wood);
//        assertFalse(building.addWall(firstWallOutZ), "Added a wall when the start point of the first wall z value was out of bounds");
//
//        //trying to add the first wall out of bounds (end point)
//        //x position out of bounds
//        double[] firstEndPointOut = new double[]{0.0, 0.0, 0.0};
//        firstWallOutX = new ExternalWall(1.0, 51.0, 1.0, firstEndPointOut, wood);
//        assertFalse(building.addWall(firstWallOutX), "Added a wall when the end point of the first wall x value was out of bounds");
//        //y position out of bounds
//        firstWallOutY = new ExternalWall(1.0, 1.0, 51.0, firstEndPointOut, wood);
//        assertFalse(building.addWall(firstWallOutY), "Added a wall when the end point of the first wall y value was out of bounds");
//        //z position out of bounds
//        firstWallOutZ = new ExternalWall(51.0, 1.0, 1.0, firstEndPointOut, wood);
//        assertFalse(building.addWall(firstWallOutZ), "Added a wall when the end point of the first wall z value was out of bounds");
//
//        //Testing for a wall starting somewhere within the building ending out of bounds
//        //x position out of bounds
//        double[] endPointOut = new double[]{25.0, 25.0, 25.0};
//        ExternalWall wallOutX = new ExternalWall(1.0, 26.0, 1.0, endPointOut, wood);
//        assertFalse(building.addWall(wallOutX), "Added a wall when the end point of the first wall x value was out of bounds");
//        //y position out of bounds
//        ExternalWall wallOutY = new ExternalWall(1.0, 1.0, 26.0, endPointOut, wood);
//        assertFalse(building.addWall(wallOutY), "Added a wall when the end point of the first wall y value was out of bounds");
//        //z position out of bounds
//        ExternalWall wallOutZ = new ExternalWall(26.0, 1.0, 1.0, endPointOut, wood);
//        assertFalse(building.addWall(wallOutZ), "Added a wall when the end point of the first wall z value was out of bounds");
//
//        //Adding the first wall
//        double[] startPoint = new double[]{10.0, 10.0, 10.0};
//        ExternalWall wall1 = new ExternalWall(30.0, 30.0, 30.0, startPoint, wood);
//        boolean added = building.addWall(wall1);
//        double[] endPoint = new double[]{40.0, 40.0, 40.0};
//        assertTrue(added, "Wall not added");
//        assertEquals(30.0, wall1.getLength(), "Wall length not properly set when adding");
//        assertEquals(30.0, wall1.getThickness(), "Wall width not properly set when adding");
//        assertEquals(30.0, wall1.getHeight(), "Wall height not properly set when adding");
//        assertArrayEquals(startPoint, wall1.getBottomCoordinates(), "Wall start point not properly set when adding");
//        assertEquals(wood, wall1.getMaterial(), "Wall material not properly set when adding");
//        assertArrayEquals(endPoint, building.walls[0].getTopCoordinates(), "Wall end point not properly set when adding");

//        //Test for overlapping walls
//        //Case 1: start point of new wall is within existing wall
//        //x value
//        double[] startPoint2 = new double[]{15.0, 0.0, 0.0};
//        ExternalWall wall2 = new ExternalWall(41.0, 30.0, 41.0, startPoint2, wood);
//        assertFalse(building.addWall(wall2), "Added wall whose start point overlaps exising wall in x position");
//        //y value
//        double[] startPoint3 = new double[]{0.0, 15.0, 0.0};
//        ExternalWall wall3 = new ExternalWall(41.0, 41.0, 30.0, startPoint3, wood);
//        assertFalse(building.addWall(wall3), "Added wall whose start point overlaps exising wall in y position");
//        //z value
//        double[] startPoint4 = new double[]{0.0, 0.0, 15.0};
//        ExternalWall wall4 = new ExternalWall(30.0, 41.0, 41.0, startPoint4, wood);
//        assertFalse(building.addWall(wall4), "Added wall whose start point overlaps exising wall in z position");
//        //Case 2: End point of new wall is within existing wall
//        //x value
//        double[] startPoint5 = new double[]{0.0, 0.0, 0.0};
//        ExternalWall wall5 = new ExternalWall(5.0, 15.0, 5.0, startPoint5, wood);
//        assertFalse(building.addWall(wall5), "Added wall whose end point overlaps exising wall in x position");
//        //y value
//        ExternalWall wall6 = new ExternalWall(5.0, 5.0, 15.0, startPoint5, wood);
//        assertFalse(building.addWall(wall6), "Added wall whose end point overlaps exising wall in y position");
//        //z value
//        ExternalWall wall7 = new ExternalWall(15.0, 5.0, 5.0, startPoint5, wood);
//        assertFalse(building.addWall(wall7), "Added wall whose end point overlaps exising wall in z position");
//        //Case 3: New wall overlaps existing wall, regardless of start or end point
//        //Partial overlap
//        ExternalWall wall8 = new ExternalWall(11, 50, 11, startPoint5, wood);
//        assertFalse(building.addWall(wall8), "Added wall which overlaps an existing wall");
//        //Whole overlap
//        ExternalWall wall9 = new ExternalWall(50, 50, 50, startPoint5, wood);
//        assertFalse(building.addWall(wall9), "Added new wall which encompasses an existing wall");
//        //Case 4: New wall is directly adjacent to existing wall
//        //Corner
//        double[] startPoint6 = new double[]{0, 0, 0};
//        ExternalWall wall10 = new ExternalWall(10, 10, 10, startPoint6, wood);
//        assertTrue(building.addWall(wall10), "Did not add a new wall which was touching the corner of an existing wall");
//        //edge
//        for(int y = 0; y < building.walls.length; y++){
//            //System.out.println("Wall " + y + ": ");
//            //System.out.println("Start: [" + building.walls[y].getBottomCoordinates()[0] + ", " + building.walls[y].getBottomCoordinates()[1] + ", " + building.walls[y].getBottomCoordinates()[2] + "]");
//            //System.out.println("End: [" + building.walls[y].getTopCoordinates()[0] + ", " + building.walls[y].getTopCoordinates()[1] + ", " + building.walls[y].getTopCoordinates()[2] + "]");
//        }
//        double[] startPoint7 = new double[]{0.0, 0.0, 40.0};
//        ExternalWall wall11 = new ExternalWall(10, 50, 10, startPoint7, wood);
//        //System.out.println("Wall 2: ");
//        //System.out.println("Start: [" + wall11.getBottomCoordinates()[0] + ", " + wall11.getBottomCoordinates()[1] + ", " + wall11.getBottomCoordinates()[2] + "]");
//        //System.out.println("End: [" + wall11.getTopCoordinates()[0] + ", " + wall11.getTopCoordinates()[1] + ", " + wall11.getTopCoordinates()[2] + "]");
//        assertTrue(building.addWall(wall11), "Did not add a new wall which was touching the edge of an existing wall");
//        //side
//        double[] startPoint8 = new double[]{0, 40.0, 0};
//        ExternalWall wall12 = new ExternalWall(50, 50, 10, startPoint8, wood);
//        System.out.println("Wall 2: ");
//        System.out.println("Start: [" + wall12.getBottomCoordinates()[0] + ", " + wall12.getBottomCoordinates()[1] + ", " + wall12.getBottomCoordinates()[2] + "]");
//        System.out.println("End: [" + wall12.getTopCoordinates()[0] + ", " + wall12.getTopCoordinates()[1] + ", " + wall12.getTopCoordinates()[2] + "]");
//        assertTrue(building.addWall(wall12), "Did not add a new wall which was touching the side of an existing wall");
//    }

    @Test
    public void testSetRoof(){
        double length = 9.3;
        double width = 8.2;
        double height = 7.2;
        double roofThickness = 0.2;
        Roof testRoof = new RoofImpl(width,length,height,roofThickness);
        Building testBuilding = new BuildingImpl();
        double delta = 0.01; //allows for some double discrepancy

        testBuilding.setRoof(testRoof);

        assertEquals(width,testBuilding.getRoof().getWidth(),delta,"Did not properly set roof");
        assertEquals(length,testBuilding.getRoof().getLength(),delta,"Did not properly set roof");
        assertEquals(height,testBuilding.getRoof().getHeight(),delta,"Did not properly set roof");

    }

    @Test void testSetWallMaterial(){
        ExternalWall testWall = new ExternalWall();
        ExternalWall testWall2 = new ExternalWall();
        Building testBuilding = new BuildingImpl();
        MaterialByArea testMaterial = new Wood();
        MaterialByArea testMaterial2 = new Brick();

        testBuilding.addWall(testWall);
        testBuilding.addWall(testWall2);

        assertTrue(testBuilding.setWallMaterial(0,testMaterial));
        assertTrue(testBuilding.setWallMaterial(1,testMaterial2));

        assertEquals(testMaterial,testBuilding.getWall(0).getMaterial());
        assertEquals(testMaterial2,testBuilding.getWall(1).getMaterial());
    }

    @Test
    void addRemoveFloorTest(){
        Building testBuilding = new BuildingImpl();
        testBuilding.addFloor(new FloorImpl(10, new Brick()));
        testBuilding.addFloor(new FloorImpl(20, new ConcreteBrick()));
        testBuilding.addFloor(new FloorImpl(45, newMaterial1));
        MaterialByArea testMaterial = new ConcreteBrick();
        MaterialByArea testMaterial2 = new Brick();
        assertEquals(testBuilding.getFloor(2).getMaterial().getMaterialName(), newMaterial1.getMaterialName());
        assertEquals(testBuilding.getFloor(1).getMaterial().getMaterialName(), testMaterial.getMaterialName());
        assertEquals(testBuilding.getFloor(0).getMaterial().getMaterialName(), testMaterial2.getMaterialName());
        testBuilding.removeFloor(2);
//        assertThrows(testBuilding.getFloor(2).getMaterial().getMaterialName(), new IndexOutOfBoundsException().getMessage());
        assertEquals(testBuilding.getFloor(1).getMaterial().getMaterialName(), testMaterial.getMaterialName());
        testBuilding.removeFloor(0);
        assertEquals(testBuilding.getFloor(0).getMaterial().getMaterialName(), testMaterial.getMaterialName());

    }



}
