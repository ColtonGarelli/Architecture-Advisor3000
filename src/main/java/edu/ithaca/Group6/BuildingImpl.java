package edu.ithaca.Group6;

import java.util.Arrays;

public class BuildingImpl implements Building{
    //Creating a building in the shape of a rectangular prism
    double length;
    double width;
    double height;
    ExternalWall[] walls;
    Roof roof;

    public BuildingImpl(){
        this.length = 0.0;
        this.width = 0.0;
        this.height = 0.0;
        this.walls = new ExternalWall[0];
        this.roof = null;
    }

    public BuildingImpl(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.walls = new ExternalWall[0];
        this.roof = new RoofImpl(width,length,0.2,height);
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
        double perim = this.getPerimeter();
        double surfaceArea = perim*this.height;
        //double costExtWall = this.extWallMaterial.calcCost(surfaceArea);
        //totalCost += costExtWall;

        return totalCost;
    }

    public boolean addWall(ExternalWall wall){
        //Check if the wall is being added outside of the building dimensions
        //Check x dimensions
        if(wall.getBottomCoordinates()[0] < 0.0 || wall.getBottomCoordinates()[0] > this.length || wall.getTopCoordinates()[0] < 0 || wall.getTopCoordinates()[0] > this.length){
            return false;
        }
        //Check y dimensions
        else if(wall.getBottomCoordinates()[1] < 0 || wall.getBottomCoordinates()[1] > this.width || wall.getTopCoordinates()[1] < 0 || wall.getTopCoordinates()[1] > this.width){
            return false;
        }
        //Check z dimensions
        else if(wall.getBottomCoordinates()[2] < 0 || wall.getBottomCoordinates()[2] > this.height || wall.getTopCoordinates()[2] < 0 || wall.getTopCoordinates()[2] > this.height){
            return false;
        }
        /**
        //check if the wall being added will overlap any existing walls
        if(walls.length > 0) {
            for (int n = 0; n < walls.length; n++) {
                //Can't have the same start point as an existing wall
                if (Arrays.equals(wall.getBottomCoordinates(), walls[n].getBottomCoordinates())) {
                    return false;
                }
                //Can't start a wall inside an existing wall
                //Check the x value
                else if (wall.getBottomCoordinates()[0] > walls[n].getBottomCoordinates()[0] && wall.getBottomCoordinates()[0] < walls[n].getTopCoordinates()[0]) {
                    return false;
                }
                //Check the y value
                else if (wall.getBottomCoordinates()[1] > walls[n].getBottomCoordinates()[1] && wall.getBottomCoordinates()[1] < walls[n].getTopCoordinates()[1]) {
                    return false;
                }
                //Check the z value
                else if (wall.getBottomCoordinates()[2] > walls[n].getBottomCoordinates()[2] && wall.getBottomCoordinates()[2] < walls[n].getTopCoordinates()[2]) {
                    return false;
                }
                //Can't end the wall inside an existing wall
                //Check the x value
                else if (wall.getTopCoordinates()[0] > walls[n].getBottomCoordinates()[0] && wall.getTopCoordinates()[0] < walls[n].getTopCoordinates()[0]) {
                    return false;
                }
                //Check the y value
                else if (wall.getTopCoordinates()[1] > walls[n].getBottomCoordinates()[1] && wall.getTopCoordinates()[1] < walls[n].getTopCoordinates()[1]) {
                    return false;
                }
                //Check the z value
                else if (wall.getTopCoordinates()[2] > walls[n].getBottomCoordinates()[2] && wall.getTopCoordinates()[2] < walls[n].getTopCoordinates()[2]) {
                    return false;
                }
                //Can't have the wall overlap another wall
                else if ((wall.getBottomCoordinates()[0] < walls[n].getBottomCoordinates()[0]) && (wall.getTopCoordinates()[0] > walls[n].getTopCoordinates()[0])){
                    if((wall.getBottomCoordinates()[1] < walls[n].getBottomCoordinates()[1]) && (wall.getTopCoordinates()[1] > walls[n].getTopCoordinates()[1])){
                        if ((wall.getBottomCoordinates()[2] < walls[n].getBottomCoordinates()[2]) && (wall.getTopCoordinates()[2] < walls[n].getTopCoordinates()[2] && wall.getTopCoordinates()[2] > walls[n].getBottomCoordinates()[2])){
                            return false;
                        }
                        else if ((wall.getTopCoordinates()[2] < walls[n].getTopCoordinates()[2]) && (wall.getBottomCoordinates()[2] < walls[n].getTopCoordinates()[2] && wall.getBottomCoordinates()[2] > walls[n].getBottomCoordinates()[2])) {
                            return false;
                        }
                    }
                    if((wall.getBottomCoordinates()[2] < walls[n].getBottomCoordinates()[2]) && (wall.getTopCoordinates()[2] > walls[n].getTopCoordinates()[2])){
                        if ((wall.getBottomCoordinates()[1] < walls[n].getBottomCoordinates()[1]) && (wall.getTopCoordinates()[1] < walls[n].getTopCoordinates()[1] && wall.getTopCoordinates()[1] > walls[n].getBottomCoordinates()[1])){
                            return false;
                        }
                        else if ((wall.getTopCoordinates()[1] < walls[n].getTopCoordinates()[1]) && (wall.getBottomCoordinates()[1] < walls[n].getTopCoordinates()[1] && wall.getBottomCoordinates()[1] > walls[n].getBottomCoordinates()[1])) {
                            return false;
                        }
                    }
                }
                else if ((wall.getBottomCoordinates()[1] < walls[n].getBottomCoordinates()[1]) && (wall.getTopCoordinates()[1] > walls[n].getTopCoordinates()[1])){
                    if((wall.getBottomCoordinates()[0] < walls[n].getBottomCoordinates()[0]) && (wall.getTopCoordinates()[0] > walls[n].getTopCoordinates()[0])){
                        if ((wall.getBottomCoordinates()[2] < walls[n].getBottomCoordinates()[2]) && (wall.getTopCoordinates()[2] < walls[n].getTopCoordinates()[2] && wall.getTopCoordinates()[2] > walls[n].getBottomCoordinates()[2])){
                            return false;
                        }
                        else if ((wall.getTopCoordinates()[2] < walls[n].getTopCoordinates()[2]) && (wall.getBottomCoordinates()[2] < walls[n].getTopCoordinates()[2] && wall.getBottomCoordinates()[2] > walls[n].getBottomCoordinates()[2])) {
                            return false;
                        }
                    }
                    if((wall.getBottomCoordinates()[2] < walls[n].getBottomCoordinates()[2]) && (wall.getTopCoordinates()[2] > walls[n].getTopCoordinates()[2])){
                        if ((wall.getBottomCoordinates()[0] < walls[n].getBottomCoordinates()[0]) && (wall.getTopCoordinates()[0] < walls[n].getTopCoordinates()[0] && wall.getTopCoordinates()[0] > walls[n].getBottomCoordinates()[0])){
                            return false;
                        }
                        else if ((wall.getTopCoordinates()[0] < walls[n].getTopCoordinates()[0]) && (wall.getBottomCoordinates()[0] < walls[n].getTopCoordinates()[0] && wall.getBottomCoordinates()[0] > walls[n].getBottomCoordinates()[0])) {
                            return false;
                        }
                    }
                }
                else if ((wall.getBottomCoordinates()[2] < walls[n].getBottomCoordinates()[2]) && (wall.getTopCoordinates()[2] > walls[n].getTopCoordinates()[2])){
                    if((wall.getBottomCoordinates()[1] < walls[n].getBottomCoordinates()[1]) && (wall.getTopCoordinates()[1] > walls[n].getTopCoordinates()[1])){
                        if ((wall.getBottomCoordinates()[0] < walls[n].getBottomCoordinates()[0]) && (wall.getTopCoordinates()[0] < walls[n].getTopCoordinates()[0] && wall.getTopCoordinates()[0] > walls[n].getBottomCoordinates()[0])){
                            return false;
                        }
                        else if ((wall.getTopCoordinates()[0] < walls[n].getTopCoordinates()[0]) && (wall.getBottomCoordinates()[0] < walls[n].getTopCoordinates()[0] && wall.getBottomCoordinates()[0] > walls[n].getBottomCoordinates()[0])) {
                            return false;
                        }
                    }
                    if((wall.getBottomCoordinates()[0] < walls[n].getBottomCoordinates()[0]) && (wall.getTopCoordinates()[0] > walls[n].getTopCoordinates()[0])){
                        if ((wall.getBottomCoordinates()[1] < walls[n].getBottomCoordinates()[1]) && (wall.getTopCoordinates()[1] < walls[n].getTopCoordinates()[1] && wall.getTopCoordinates()[1] > walls[n].getBottomCoordinates()[1])){
                            return false;
                        }
                        else if ((wall.getTopCoordinates()[1] < walls[n].getTopCoordinates()[1]) && (wall.getBottomCoordinates()[1] < walls[n].getTopCoordinates()[1] && wall.getBottomCoordinates()[1] > walls[n].getBottomCoordinates()[1])) {
                            return false;
                        }
                    }
                }
            }
        }*/
        ExternalWall[] temp;
        if(walls.length == 0){
            temp = new ExternalWall[]{wall};
            walls = temp;
        }
        else {
            temp = new ExternalWall[walls.length+1];
            for (int a = 0; a < walls.length; a++) {
                temp[a] = walls[a];
            }
            temp[walls.length] = wall;
            walls = temp;
        }
        return true;
    }

    public void removeWall(int wallIdx){

    }

    public void addWallFeature(int wallIdx, MaterialByUnit feature, double[] startPoint){

    }

    public void removeWallFeature(int wallIdx, int featureIdx){

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
}
