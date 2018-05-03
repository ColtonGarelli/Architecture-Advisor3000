package edu.ithaca.Group6;

import java.util.ArrayList;

public class BuildingImpl implements Building{
    //Creating a building in the shape of a rectangular prism
    double length;
    double width;
    double height;
    public ArrayList<ExternalWall> walls;
    Roof roof;
    public ArrayList<Floor> floors;

    public BuildingImpl(){
        this.length = 0.0;
        this.width = 0.0;
        this.height = 0.0;
        this.walls = new ArrayList<ExternalWall>();
        this.roof = null;
        this.floors = new ArrayList<Floor>();
    }

    public BuildingImpl(double xEdge, double yEdge, double height) {
        this.length = xEdge;
        this.width = yEdge;
        this.height = height;
        this.walls = new ArrayList<ExternalWall>();
        this.roof = new RoofImpl(yEdge,xEdge,0.2,height);
        double thickness = 0.2;
        this.floors = new ArrayList<Floor>();


//        this.walls[0] = new ExternalWall();
//        this.walls[0].setBottomCoordinates(0,0,0);
//        this.walls[0].setTopCoordinates(thickness,width,height);
//
//        this.walls[1] = new ExternalWall();
//        this.walls[1].setBottomCoordinates(0,width,0);
//        this.walls[1].setTopCoordinates(length,width-thickness,height);
//
//        this.walls[2] = new ExternalWall();
//        this.walls[2].setBottomCoordinates(length,width,0);
//        this.walls[2].setTopCoordinates(length-thickness,0,height);
//
//        this.walls[3] = new ExternalWall();
//        this.walls[3].setBottomCoordinates(length,0,0);
//        this.walls[3].setTopCoordinates(0,thickness,height);
    }

    public void setLength(double newVal) {
        //set a new length of the building
        length = newVal;
    }

    public double getLength() {
        //get the length of the building
        return length;
    }

    public void setWidth(double newVal) {
        //set a new width for the building
        width = newVal;
    }

    public double getWidth() {
        //get the width of the building
        return width;
    }

    public void setHeight(double newVal) {
        //set a new height for the building
        height = newVal;
    }

    public double getHeight() {
        //get the height of the building
        return height;
    }

    public double getSquareFootage() {
        //get the square footage of the building
        double sqftg = length * width;
        return sqftg;
    }

    public double getPerimeter() {
        //calculate the perimeter of the building
        double perim = (length * 2) + (width * 2);
        return perim;
    }

    public double calcTotalCost() {
        double totalCost = 0;

        //Calculate the total cost of the walls
        for(int x = 0; x < this.walls.size(); x++){
            totalCost += this.walls.get(x).calcCost();
            for(int y = 0; y < this.walls.get(x).getFeatureListSize(); y++){
                totalCost += this.walls.get(x).getFeature(y).getCostPerUnit();
            }
        }

        return totalCost;
    }

    @Override
    public Wall getWall(int wallIdx) {
        if(wallIdx > -1 && wallIdx < this.walls.size()){
            try{
                return this.walls.get(wallIdx);
            }catch(Exception e){
                return null;
            }
        }
        return null;
    }

    public boolean addWall(ExternalWall wall){
        this.walls.add(wall);
        return true;
    }
        //Check if the wall is being added outside of the building dimensions
        //Check x dimensions
//        if(wall.getBottomCoordinates()[0] < 0.0 || wall.getBottomCoordinates()[0] > this.length || wall.getTopCoordinates()[0] < 0 || wall.getTopCoordinates()[0] > this.length){
//            return false;
//        }
//        //Check y dimensions
//        else if(wall.getBottomCoordinates()[1] < 0 || wall.getBottomCoordinates()[1] > this.width || wall.getTopCoordinates()[1] < 0 || wall.getTopCoordinates()[1] > this.width){
//            return false;
//        }
//        //Check z dimensions
//        else if(wall.getBottomCoordinates()[2] < 0 || wall.getBottomCoordinates()[2] > this.height || wall.getTopCoordinates()[2] < 0 || wall.getTopCoordinates()[2] > this.height){
//            return false;
//        }
//        /**
//        //check if the wall being added will overlap any existing walls
//        if(walls.length > 0) {
//            for (int n = 0; n < walls.length; n++) {
//                //Can't have the same start point as an existing wall
//                if (Arrays.equals(wall.getBottomCoordinates(), walls[n].getBottomCoordinates())) {
//                    return false;
//                }
//                //Can't start a wall inside an existing wall
//                //Check the x value
//                else if (wall.getBottomCoordinates()[0] > walls[n].getBottomCoordinates()[0] && wall.getBottomCoordinates()[0] < walls[n].getTopCoordinates()[0]) {
//                    return false;
//                }
//                //Check the y value
//                else if (wall.getBottomCoordinates()[1] > walls[n].getBottomCoordinates()[1] && wall.getBottomCoordinates()[1] < walls[n].getTopCoordinates()[1]) {
//                    return false;
//                }
//                //Check the z value
//                else if (wall.getBottomCoordinates()[2] > walls[n].getBottomCoordinates()[2] && wall.getBottomCoordinates()[2] < walls[n].getTopCoordinates()[2]) {
//                    return false;
//                }
//                //Can't end the wall inside an existing wall
//                //Check the x value
//                else if (wall.getTopCoordinates()[0] > walls[n].getBottomCoordinates()[0] && wall.getTopCoordinates()[0] < walls[n].getTopCoordinates()[0]) {
//                    return false;
//                }
//                //Check the y value
//                else if (wall.getTopCoordinates()[1] > walls[n].getBottomCoordinates()[1] && wall.getTopCoordinates()[1] < walls[n].getTopCoordinates()[1]) {
//                    return false;
//                }
//                //Check the z value
//                else if (wall.getTopCoordinates()[2] > walls[n].getBottomCoordinates()[2] && wall.getTopCoordinates()[2] < walls[n].getTopCoordinates()[2]) {
//                    return false;
//                }
//                //Can't have the wall overlap another wall
//                else if ((wall.getBottomCoordinates()[0] < walls[n].getBottomCoordinates()[0]) && (wall.getTopCoordinates()[0] > walls[n].getTopCoordinates()[0])){
//                    if((wall.getBottomCoordinates()[1] < walls[n].getBottomCoordinates()[1]) && (wall.getTopCoordinates()[1] > walls[n].getTopCoordinates()[1])){
//                        if ((wall.getBottomCoordinates()[2] < walls[n].getBottomCoordinates()[2]) && (wall.getTopCoordinates()[2] < walls[n].getTopCoordinates()[2] && wall.getTopCoordinates()[2] > walls[n].getBottomCoordinates()[2])){
//                            return false;
//                        }
//                        else if ((wall.getTopCoordinates()[2] < walls[n].getTopCoordinates()[2]) && (wall.getBottomCoordinates()[2] < walls[n].getTopCoordinates()[2] && wall.getBottomCoordinates()[2] > walls[n].getBottomCoordinates()[2])) {
//                            return false;
//                        }
//                    }
//                    if((wall.getBottomCoordinates()[2] < walls[n].getBottomCoordinates()[2]) && (wall.getTopCoordinates()[2] > walls[n].getTopCoordinates()[2])){
//                        if ((wall.getBottomCoordinates()[1] < walls[n].getBottomCoordinates()[1]) && (wall.getTopCoordinates()[1] < walls[n].getTopCoordinates()[1] && wall.getTopCoordinates()[1] > walls[n].getBottomCoordinates()[1])){
//                            return false;
//                        }
//                        else if ((wall.getTopCoordinates()[1] < walls[n].getTopCoordinates()[1]) && (wall.getBottomCoordinates()[1] < walls[n].getTopCoordinates()[1] && wall.getBottomCoordinates()[1] > walls[n].getBottomCoordinates()[1])) {
//                            return false;
//                        }
//                    }
//                }
//                else if ((wall.getBottomCoordinates()[1] < walls[n].getBottomCoordinates()[1]) && (wall.getTopCoordinates()[1] > walls[n].getTopCoordinates()[1])){
//                    if((wall.getBottomCoordinates()[0] < walls[n].getBottomCoordinates()[0]) && (wall.getTopCoordinates()[0] > walls[n].getTopCoordinates()[0])){
//                        if ((wall.getBottomCoordinates()[2] < walls[n].getBottomCoordinates()[2]) && (wall.getTopCoordinates()[2] < walls[n].getTopCoordinates()[2] && wall.getTopCoordinates()[2] > walls[n].getBottomCoordinates()[2])){
//                            return false;
//                        }
//                        else if ((wall.getTopCoordinates()[2] < walls[n].getTopCoordinates()[2]) && (wall.getBottomCoordinates()[2] < walls[n].getTopCoordinates()[2] && wall.getBottomCoordinates()[2] > walls[n].getBottomCoordinates()[2])) {
//                            return false;
//                        }
//                    }
//                    if((wall.getBottomCoordinates()[2] < walls[n].getBottomCoordinates()[2]) && (wall.getTopCoordinates()[2] > walls[n].getTopCoordinates()[2])){
//                        if ((wall.getBottomCoordinates()[0] < walls[n].getBottomCoordinates()[0]) && (wall.getTopCoordinates()[0] < walls[n].getTopCoordinates()[0] && wall.getTopCoordinates()[0] > walls[n].getBottomCoordinates()[0])){
//                            return false;
//                        }
//                        else if ((wall.getTopCoordinates()[0] < walls[n].getTopCoordinates()[0]) && (wall.getBottomCoordinates()[0] < walls[n].getTopCoordinates()[0] && wall.getBottomCoordinates()[0] > walls[n].getBottomCoordinates()[0])) {
//                            return false;
//                        }
//                    }
//                }
//                else if ((wall.getBottomCoordinates()[2] < walls[n].getBottomCoordinates()[2]) && (wall.getTopCoordinates()[2] > walls[n].getTopCoordinates()[2])){
//                    if((wall.getBottomCoordinates()[1] < walls[n].getBottomCoordinates()[1]) && (wall.getTopCoordinates()[1] > walls[n].getTopCoordinates()[1])){
//                        if ((wall.getBottomCoordinates()[0] < walls[n].getBottomCoordinates()[0]) && (wall.getTopCoordinates()[0] < walls[n].getTopCoordinates()[0] && wall.getTopCoordinates()[0] > walls[n].getBottomCoordinates()[0])){
//                            return false;
//                        }
//                        else if ((wall.getTopCoordinates()[0] < walls[n].getTopCoordinates()[0]) && (wall.getBottomCoordinates()[0] < walls[n].getTopCoordinates()[0] && wall.getBottomCoordinates()[0] > walls[n].getBottomCoordinates()[0])) {
//                            return false;
//                        }
//                    }
//                    if((wall.getBottomCoordinates()[0] < walls[n].getBottomCoordinates()[0]) && (wall.getTopCoordinates()[0] > walls[n].getTopCoordinates()[0])){
//                        if ((wall.getBottomCoordinates()[1] < walls[n].getBottomCoordinates()[1]) && (wall.getTopCoordinates()[1] < walls[n].getTopCoordinates()[1] && wall.getTopCoordinates()[1] > walls[n].getBottomCoordinates()[1])){
//                            return false;
//                        }
//                        else if ((wall.getTopCoordinates()[1] < walls[n].getTopCoordinates()[1]) && (wall.getBottomCoordinates()[1] < walls[n].getTopCoordinates()[1] && wall.getBottomCoordinates()[1] > walls[n].getBottomCoordinates()[1])) {
//                            return false;
//                        }
//                    }
//                }
//            }
//        }*/


    //NEEDS REPLACING, DOESN'T ACTUALLY HELP
    public void removeWall(int wallIdx){
        /**if(wallIdx > -1 && wallIdx < this.walls.length){
            try{
                this.walls[wallIdx] = null;
            }catch(Exception e){
                System.out.println("Oops this code is broken");
            }
        }*/
    }

    public void addWallFeature(int wallIdx, MaterialByUnit feature){
        this.walls.get(wallIdx).addFeature(feature);
    }

        //For when features have position
    public void addWallFeature(int wallIdx, MaterialByUnit feature, double[] startPoint){
        this.walls.get(wallIdx).addFeature(feature);
    }

    public void removeWallFeature(int wallIdx, int featureIdx){
        this.walls.get(wallIdx).removeFeature(featureIdx);
    }

    @Override
    public boolean setWallMaterial(int wallIdx, MaterialByArea wallMaterial) {
        if(wallIdx > -1 && wallIdx < this.walls.size()){
            try{
                return this.walls.get(wallIdx).setMaterial(wallMaterial);
            }catch(Exception e){
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean setRoof(Roof roofToAdd) {
        try{this.roof = roofToAdd; return true;}
        catch(Exception e){
            return false;
        }
    }

    @Override
    public Roof getRoof() {
        return this.roof;
    }

    @Override
    public int getWallAmount() {
        return this.walls.size();
    }

    public boolean addFloor(Floor floorToAdd){
        this.floors.add(floorToAdd);
        return true;
    }

    public Floor getFloor(int index) {
        return this.floors.get(index);

    }

    public boolean removeFloor(int index){
        try{
            this.floors.remove(index);
            return true;
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("An out of bounds error occured while trying to remove a floor");
            return false;
        }
    }

    public int getNumberOfFloors(){
        return this.floors.size();
    }

    public String buildingToString(){

        String buildingString;
        buildingString = "\nBuilding Dimensions\n\n";
        buildingString += "Height: ";
        buildingString += String.valueOf(this.getHeight()) + "\n";
        buildingString += "Length: ";
        buildingString += String.valueOf(this.getLength())+"\n";
        buildingString += "Width: ";
        buildingString += String.valueOf(this.getWidth())+"\n\n\n";
        buildingString += "Walls:\n";
        for(int i=0; i<this.getWallAmount(); i++){
            buildingString += String.valueOf(i+1) +".\n" + "Height: ";
            buildingString += String.valueOf(this.getWall(i).getHeight()) + "\n";
            buildingString += "Length: ";
            buildingString+= String.valueOf(this.getWall(i).getLength()+"\n");
            buildingString += "Thickness: ";
            buildingString += String.valueOf(this.getWall(i).getThickness())+"\n\n";

            if(this.getNumberOfFloors()>0) {
                buildingString += "Floors: ";
                for (int i2 = 0; i2 < this.getNumberOfFloors(); i2++) {
                    buildingString += this.getFloor(i2).floorOutString().replace('_', ' ') + "\n";
                }
            }

            if(this.getWall(i).getFeatureListSize() > 0) {
                buildingString += "Features: \n";
                for (int i3 = 0; i3 < this.getWall(i).getFeatureListSize(); i3++) {
                    buildingString += this.getWall(i).getFeature(i3).toString() + "\n";
                }
            }
            buildingString += "\n\n";
        }
        return buildingString;
    }

    @Override
    public int getNumberOfWalls() {
        return this.walls.size();
    }
}
