package edu.ithaca.Group6;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputImpl implements FileOutput {
    private String fileOutName;
    private FileOutputStream outputStream;
    private File outFile;

    public FileOutputImpl(String outputFileStr){
        this.fileOutName = outputFileStr;
        generateOutStream();
    }

    @Override
    public void generateOutStream() {
        try{
            this.outFile = new File(this.fileOutName);
            this.outputStream = new FileOutputStream(this.outFile);

            if(!outFile.exists()){
                outFile.createNewFile();
            }
        }catch(IOException e){
            //what happens when invalid file name if the client doesn't set it?
            System.out.println("Ooof!");
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

    @Override
    public boolean saveToFile(String outStr) {
        try{
            byte[] fileInBytes = outStr.getBytes();
            this.outputStream.write(fileInBytes);
            this.outputStream.flush();
            this.outputStream.close();
            return true;
        }catch(IOException e){
            System.out.println("Ooof!");
        }finally{
            try{
                if(this.outputStream != null){
                    this.outputStream.close();
                }
            }catch(IOException e){
                System.out.println("Ooof!");
            }
        }
        return false;
    }
}
