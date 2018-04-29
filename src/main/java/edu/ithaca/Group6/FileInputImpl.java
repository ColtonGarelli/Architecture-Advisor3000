package edu.ithaca.Group6;

import java.io.*;

public class FileInputImpl implements FileInput {
    private String fileInName;
    private BufferedReader inReader;
    private File inFile;

    public FileInputImpl(String inputFileStr){
        this.fileInName = inputFileStr;
        generateInStream();
    }

    @Override
    public void generateInStream() {
        try{
            this.inFile = new File(this.fileInName);
            this.inReader = new BufferedReader(new FileReader(this.inFile));

            if(!inFile.exists()){
                inFile.createNewFile();
            }
        }catch(IOException e){
            //what happens when invalid file name if the client doesn't set it?
            System.out.println("Ooof!");
        }
    }

    @Override
    public String generateInString(File inFile) {
        return null;
    }

    @Override
    public Building loadFromFile() {
        String line;
        Building returnBuilding = new BuildingImpl();
        try {
            while (this.inReader.ready()){
                line = this.inReader.readLine();
                if(line.charAt(0)=='W'){
                    ExternalWall newWall = buildWall(line);
                    returnBuilding.addWall(newWall);
                }else if(line.charAt(0)=='R'){
                    Roof newRoof = buildRoof(line);
                    returnBuilding.setRoof(newRoof);
                }else{
                    System.err.println("File invalid format.");
                }
            }
            return returnBuilding;
        }catch(IOException e){
            System.out.println("Ooof!");
        }
        return null;
    }

    private ExternalWall buildWall(String wallString){
        return null;
    }

    private Roof buildRoof(String roofString){
        return null;
    }
}
