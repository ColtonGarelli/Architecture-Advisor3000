package edu.ithaca.Group6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FileInput_Test {
    FileInput testIn;
    Building testBuilding;

    @Test
    public void testLoad(){
        testIn = new FileInputImpl("bork.txt");
        testBuilding = new BuildingImpl();
        MaterialByArea testMaterial = new Wood();
        //wall 1
        double[] bottomCoords = {0,0,0};
        double[] topCoords = {0.2,3,4};
        //roof
        double[] firstCoords = {0,0,4};
        double[] secondCoords = {2,3,4.2};
        testBuilding = testIn.loadFromFile();
        //wall 1
        assertArrayEquals(bottomCoords,testBuilding.getWall(0).getBottomCoordinates(), "Did not properly build first wall");
        assertArrayEquals(topCoords,testBuilding.getWall(0).getTopCoordinates(),"Did not get top coordinates");
        assertEquals(testMaterial.toString(),testBuilding.getWall(0).getMaterial().toString(),"Didn't get wall material");
        //roof
        assertArrayEquals(firstCoords,testBuilding.getRoof().getFirstCornerCoordinates(),"Didn't get roof start coords");
        assertArrayEquals(secondCoords,testBuilding.getRoof().getSecondCornerCoordinates(),"Didn't get roof end coords");
        //wall 4
        double[] bottomCoords2 = {2,0,0};
        double[] topCoords2 = {0,0.2,4};
        //wall 4
        assertArrayEquals(bottomCoords2,testBuilding.getWall(3).getBottomCoordinates(), "Did not properly build first wall");
        assertArrayEquals(topCoords2,testBuilding.getWall(3).getTopCoordinates(),"Did not get top coordinates");
        assertEquals(testMaterial.toString(),testBuilding.getWall(3).getMaterial().toString(),"Didn't get wall material");

    }
    @Test
    public void testBuildRoof(){
        testIn = new FileInputImpl("bork.txt");
        Roof testRoof = ((FileInputImpl) testIn).buildRoof("R: [0.0,0.0,4.0]_[2.0,3.0,4.2]_");
        double[] firstCoords = {0,0,4};
        double[] secondCoords = {2,3,4.2};

        assertArrayEquals(firstCoords,testRoof.getFirstCornerCoordinates(),"didn't get first corner coords");
        assertArrayEquals(secondCoords,testRoof.getSecondCornerCoordinates(),"didn't get second corner coords");
    }

    @Test
    public void testBuildWall(){
        testIn = new FileInputImpl("bork.txt");
        String wallString = "W: [0.0,0.0,0.0]_[0.2,3.0,4.0]_Wood : $1.00 per square foot_Bay Window : $1198.66, Length: 6.13ft, Width: 1.00ft, Height: 5.08ft_";
        Wall testWall = ((FileInputImpl) testIn).buildWall(wallString);
        double[] bottomCoords = {0,0,0};
        double[] topCoords = {0.2,3,4};
        MaterialByArea testMaterial = new Wood();
        MaterialByUnit testFeature = new BayWindow();
        assertArrayEquals(bottomCoords,testWall.getBottomCoordinates(),"Didn't get bottom wall coords");
        assertArrayEquals(topCoords,testWall.getTopCoordinates(),"Didn't get top wall coords");

        assertEquals(testMaterial.toString(),testWall.getMaterial().toString(),"Didn't get proper material");

        assertEquals(testFeature.toString(),testWall.getFeature(0).toString(),"Didn't get proper feature");

        wallString = "W: [0.0,3.0,0.0]_[2.0,2.8,4.0]_Wood : $1.00 per square foot_";
        testWall = ((FileInputImpl) testIn).buildWall(wallString);
        double[] newBottomCoords = {0,3,0};
        double[] newTopCoords = {2,2.8,4};

        assertArrayEquals(newBottomCoords,testWall.getBottomCoordinates(),"Didn't get bottom coords 2");
        assertArrayEquals(newTopCoords, testWall.getTopCoordinates(),"Didn't get top coords 2");

        assertEquals(testMaterial.toString(),testWall.getMaterial().toString(),"Didn't get wall material 2");


    }
}
