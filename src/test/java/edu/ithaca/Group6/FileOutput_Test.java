package edu.ithaca.Group6;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileOutput_Test {
    FileOutputImpl testOut;
    BuildingImpl testBuilding;


    @Test
    public void testOutString(){
        testOut = new FileOutputImpl("test.txt");
        double xEdge = 2;
        double yEdge = 3;
        double heightIn = 4;
        double thickness = 0.2;
        MaterialByArea testMaterial1 = new Wood();
        testBuilding = new BuildingImpl(xEdge,yEdge,heightIn);
        double[] startPoint1 = {0,0,0};
        double[] startPoint2 = {0,yEdge,0};
        double[] startPoint3 = {xEdge,yEdge,0};
        double[] startPoint4 = {xEdge,0,0};
        ExternalWall wall1 = new ExternalWall(heightIn, yEdge, thickness, startPoint1, testMaterial1);
        ExternalWall wall2 = new ExternalWall(heightIn,-thickness,xEdge,startPoint2,testMaterial1);
        ExternalWall wall3 = new ExternalWall(heightIn,-yEdge,-thickness,startPoint3,testMaterial1);
        ExternalWall wall4 = new ExternalWall(heightIn,thickness,-xEdge,startPoint4,testMaterial1);
        testBuilding.addWall(wall1);
        testBuilding.addWall(wall2);
        testBuilding.addWall(wall3);
        testBuilding.addWall(wall4);
        BayWindow testWindow = new BayWindow();
        testBuilding.addWallFeature(0,testWindow);
        String buildingString = "W: [0.0,0.0,0.0]_["+thickness+","+yEdge+","+heightIn+"]_"+testMaterial1.toString()+"_"+testWindow.toString()+"_"+"\n"
                +"W: [0.0,"+yEdge+",0.0]_"+"["+xEdge+","+(yEdge-thickness)+","+heightIn+"]_"+testMaterial1.toString()+"_"+"\n"
                +"W: ["+xEdge+","+yEdge+",0.0]_"+"["+(xEdge-thickness)+",0.0,"+heightIn+"]_"+testMaterial1.toString()+"_"+"\n"
                +"W: ["+xEdge+",0.0,0.0]_"+"[0.0,"+thickness+","+heightIn+"]_"+testMaterial1.toString()+"_"+"\n"
                +"R: [0.0,0.0,"+heightIn+"]_"+"["+xEdge+","+yEdge+","+(heightIn+thickness)+"]_"+"\n";
        assertEquals(buildingString,testOut.generateOutString(testBuilding),"Did not properly output a building string");
        buildingString += "F: Brick_10.0\n";
        assertEquals(buildingString, testOut.generateOutString(testBuilding));

    }

    @Test
    public void testSaveFile(){
        testOut = new FileOutputImpl("test.txt");
        double xEdge = 2;
        double yEdge = 3;
        double heightIn = 4;
        double thickness = 0.2;
        MaterialByArea testMaterial1 = new Wood();
        testBuilding = new BuildingImpl(xEdge,yEdge,heightIn);
        double[] startPoint1 = {0,0,0};
        double[] startPoint2 = {0,yEdge,0};
        double[] startPoint3 = {xEdge,yEdge,0};
        double[] startPoint4 = {xEdge,0,0};
        ExternalWall wall1 = new ExternalWall(heightIn, yEdge, thickness, startPoint1, testMaterial1);
        ExternalWall wall2 = new ExternalWall(heightIn,-thickness,xEdge,startPoint2,testMaterial1);
        ExternalWall wall3 = new ExternalWall(heightIn,-yEdge,-thickness,startPoint3,testMaterial1);
        ExternalWall wall4 = new ExternalWall(heightIn,thickness,-xEdge,startPoint4,testMaterial1);
        testBuilding.addWall(wall1);
        testBuilding.addWall(wall2);
        testBuilding.addWall(wall3);
        testBuilding.addWall(wall4);
        BayWindow testWindow = new BayWindow();
        testBuilding.addWallFeature(0,testWindow);

        assertEquals(true,testOut.saveToFile(testOut.generateOutString(testBuilding)));
    }
}
