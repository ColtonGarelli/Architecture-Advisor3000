package edu.ithaca.Group6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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

    public ExternalWall buildWall(String wallString){
        wallString = wallString.substring(3);
        String[] stringBreakdown = wallString.split("\\_");
        ExternalWall wallToReturn = new ExternalWall();
        //splits into pieces of strings based on the delimiter "_"
        String firstCoordStr = stringBreakdown[0].substring(1,stringBreakdown[0].length()-1);
        String[] firstCoordBreakdown = firstCoordStr.split("\\,");
        String secondCoordStr = stringBreakdown[1].substring(1,stringBreakdown[1].length()-1);
        String[] secondCoordBreakdown = secondCoordStr.split("\\,");
        try{
            double firstX = Double.parseDouble(firstCoordBreakdown[0]);
            double firstY = Double.parseDouble(firstCoordBreakdown[1]);
            double firstZ = Double.parseDouble(firstCoordBreakdown[2]);

            double secondX = Double.parseDouble(secondCoordBreakdown[0]);
            double secondY = Double.parseDouble(secondCoordBreakdown[1]);
            double secondZ = Double.parseDouble(secondCoordBreakdown[2]);

            //try to build coordinates and dimensions off of file
            wallToReturn.setBottomCoordinates(firstX,firstY,firstZ);
            wallToReturn.setTopCoordinates(secondX,secondY,secondZ);
            wallToReturn.setHeight(secondZ-firstZ);

            if(Math.abs(secondX-firstX) > Math.abs(secondY-firstY)){
                wallToReturn.setLength(Math.abs(secondX-firstX));
                wallToReturn.setThickness(Math.abs(secondY-firstY));
            }else{
                wallToReturn.setLength(Math.abs(secondY-firstY));
                wallToReturn.setThickness(Math.abs(secondX-firstX));
            }
        }catch(NumberFormatException e){
            return null;
        }
        //sets the wall material type
        String materialTypeStr = stringBreakdown[2];
        MaterialByArea materialType = buildMaterialByArea(materialTypeStr);
        wallToReturn.setMaterial(materialType);

        //now any features, starts at 3 b/c the coordinates, wall material are stored first
        if(stringBreakdown.length > 3 ) {
            for (int i = 3; i < stringBreakdown.length; i++) {
                String materialByUnitStr = stringBreakdown[i];
                MaterialByUnit wallFeature = buildMaterialByUnit(materialByUnitStr);
                wallToReturn.addFeature(wallFeature);
            }
        }
        return wallToReturn;
    }

    public Roof buildRoof(String roofString){
        roofString = roofString.substring(3);
        String[] stringBreakdown = roofString.split("\\_");
        Roof roofToReturn = new RoofImpl();
        //splits into pieces of strings based on the delimiter "_"
        String firstCoordStr = stringBreakdown[0].substring(1,stringBreakdown[0].length()-1);
        String[] firstCoordBreakdown = firstCoordStr.split("\\,");
        String secondCoordStr = stringBreakdown[1].substring(1,stringBreakdown[1].length()-1);
        String[] secondCoordBreakdown = secondCoordStr.split("\\,");
        try{
            double firstX = Double.parseDouble(firstCoordBreakdown[0]);
            double firstY = Double.parseDouble(firstCoordBreakdown[1]);
            double firstZ = Double.parseDouble(firstCoordBreakdown[2]);

            double secondX = Double.parseDouble(secondCoordBreakdown[0]);
            double secondY = Double.parseDouble(secondCoordBreakdown[1]);
            double secondZ = Double.parseDouble(secondCoordBreakdown[2]);

            //try to build coordinates and dimensions off of file
            roofToReturn.setFirstCornerCoordinates(firstX,firstY,firstZ);
            roofToReturn.setSecondCornerCoordinates(secondX,secondY,secondZ);
        }catch(NumberFormatException e){
            return null;
        }
        return roofToReturn;
    }

    public MaterialByArea buildMaterialByArea(String materialByAreaString){
        String[] breakdownStr = materialByAreaString.split("\\:");
        String materialName = breakdownStr[0].substring(0,breakdownStr[0].length()-1);
        if(materialName.equals("Wood")){
            return new Wood();
        }else if(materialName.equals("Brick")){
            return new Brick();
        }else if(materialName.equals("Clay Brick")){
            return new ClayBrick();
        }else if(materialName.equals("Concrete Brick")){
            return new ConcreteBrick();
        }else if(materialName.equals("Two by Four Wood")){
            return new TwoByFour();
        }else if(materialName.equals("Two by Three Wood")){
            return new TwoByThree();
        }else{
            return new Wood();
        }
    }

    public MaterialByUnit buildMaterialByUnit(String materialByUnitString){
        String[] breakdownStr = materialByUnitString.split("\\:");
        String featureName = breakdownStr[0].substring(0,breakdownStr[0].length()-1);
        if(featureName.equals("Bay Window")){
            return new BayWindow();
        }else if(featureName.equals("Door")){
            return new Door();
        }else if(featureName.equals("Double Hung Window")){
            return new DoubleHungWindow();
        }else if(featureName.equals("Garage Door")){
            return new GarageDoor();
        }else if(featureName.equals("Interior Door")){
            return new InteriorDoor();
        }else if(featureName.equals("Picture Window")){
            return new PictureWindow();
        }else if(featureName.equals("Screen Door")){
            return new ScreenDoor();
        }else if(featureName.equals("Single Hung Window")){
            return new SingleHungWindow();
        }else if(featureName.equals("Sliding Door")){
            return new SlidingDoor();
        }else if(featureName.equals("Sliding Window")){
            return new SlidingWindow();
        }else if(featureName.equals("Storm Door")){
            return new StormDoor();
        }else{
            return new Door();
        }
    }
}
