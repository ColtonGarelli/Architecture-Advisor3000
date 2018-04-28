package edu.ithaca.Group6;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileOutput_Test {
    FileOutputImpl testOut;
    BuildingImpl testBuilding;


    @Test
    public void testOutString(){
        testOut = new FileOutputImpl("test.txt");
        testBuilding = new BuildingImpl(2,3,4);
        BayWindow testWindow = new BayWindow();
        testBuilding.addWallFeature(0,testWindow);
        String buildingString = "[0,0,0]_[";
        assertEquals(buildingString,testOut.generateOutString(testBuilding),"Did not properly output a building string");
    }
}
