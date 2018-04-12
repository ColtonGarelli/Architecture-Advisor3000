package edu.ithaca.Group6;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileOutput_Test {
    FileOutputImpl testOut;
    BuildingImpl testBuilding;


    @Test
    public void testOutString(){
        assertEquals(true,testOut.generateOutString(testBuilding),"Did not properly output a building string");
    }
}
