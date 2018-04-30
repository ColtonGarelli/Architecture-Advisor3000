package edu.ithaca.Group6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FileInput_Test {
    FileInput testIn;
    Building testBuilding;

//    @Test
//    public void testGenerateInString(){
//
//    }

    @Test
    public void testLoad(){
        testIn = new FileInputImpl("bork.txt");
        testBuilding = new BuildingImpl();
        double[] zeroCoords = {0,0,0};
        try {
            testBuilding = testIn.loadFromFile();
            assertEquals(zeroCoords,testBuilding.getWall(0).getBottomCoordinates(), "Did not properly build first wall");
        }catch(Exception e){
            e.printStackTrace();
        }

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
