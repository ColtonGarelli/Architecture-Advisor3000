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
}
