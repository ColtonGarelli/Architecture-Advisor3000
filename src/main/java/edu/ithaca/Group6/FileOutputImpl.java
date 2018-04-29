package edu.ithaca.Group6;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileOutputImpl implements FileOutput {
    private String fileOutName;
    private FileOutputStream outputStream;

    public FileOutputImpl(String outputFileStr){
        this.fileOutName = outputFileStr;
        generateOutStream();
    }

    @Override
    public void generateOutStream() {
        try{
            this.outputStream = new FileOutputStream(fileOutName);
        }catch(FileNotFoundException e){
            //what happens when invalid file name if the client doesn't set it?
        }
    }

    @Override
    public String generateOutString(Building buildingToOutput) {
        String buildString = "";
        for(int i = 0; i < buildingToOutput.getWallAmount(); i++) {
            buildString += buildingToOutput.getWall(i).outString();
        }
        buildString += "R: " + buildingToOutput.getRoof().getFirstCornerCoordString() + "_";
        buildString += buildingToOutput.getRoof().getSecondCornerCoordString() + "_" +"\n";
        return buildString;
    }
}
