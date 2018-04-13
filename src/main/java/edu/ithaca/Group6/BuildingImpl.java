package edu.ithaca.Group6;

import java.util.Arrays;

public class BuildingImpl implements Building{
    //Creating a building in the shape of a rectangular prism
    double length;
    double width;
    double height;
    InternalWall[] walls;

    public BuildingImpl(){
        this.length = 0.0;
        this.width = 0.0;
        this.height = 0.0;
        this.walls = new InternalWall[0];
    }

    public BuildingImpl(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.walls = new InternalWall[0];
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

    public boolean addWall(InternalWall wall){
        //Check if the wall is being added outside of the building dimensions
        //Check x dimensions
        if(wall.getBottomLeftOutsideCoordinates()[0] < 0.0 || wall.getBottomLeftOutsideCoordinates()[0] > this.length || wall.getTopRightInsideCoordinates()[0] < 0 || wall.getTopRightInsideCoordinates()[0] > this.length){
            return false;
        }
        //Check y dimensions
        else if(wall.getBottomLeftOutsideCoordinates()[1] < 0 || wall.getBottomLeftOutsideCoordinates()[1] > this.width || wall.getTopRightInsideCoordinates()[1] < 0 || wall.getTopRightInsideCoordinates()[1] > this.width){
            return false;
        }
        //Check z dimensions
        else if(wall.getBottomLeftOutsideCoordinates()[2] < 0 || wall.getBottomLeftOutsideCoordinates()[2] > this.height || wall.getTopRightInsideCoordinates()[2] < 0 || wall.getTopRightInsideCoordinates()[2] > this.height){
            return false;
        }
        //check if the wall being added will overlap any existing walls
        if(walls.length > 0) {
            for (int n = 0; n < walls.length; n++) {
                //Can't have the same start point as an existing wall
                if (Arrays.equals(wall.getBottomLeftOutsideCoordinates(), walls[n].getBottomLeftOutsideCoordinates())) {
                    return false;
                }
                //Can't start a wall inside an existing wall
                //Check the x value
                else if (wall.getBottomLeftOutsideCoordinates()[0] > walls[n].getBottomLeftOutsideCoordinates()[0] && wall.getBottomLeftOutsideCoordinates()[0] < walls[n].getTopRightInsideCoordinates()[0]) {
                    return false;
                }
                //Check the y value
                else if (wall.getBottomLeftOutsideCoordinates()[1] > walls[n].getBottomLeftOutsideCoordinates()[1] && wall.getBottomLeftOutsideCoordinates()[0] < walls[n].getTopRightInsideCoordinates()[1]) {
                    return false;
                }
                //Check the z value
                else if (wall.getBottomLeftOutsideCoordinates()[2] > walls[n].getBottomLeftOutsideCoordinates()[2] && wall.getBottomLeftOutsideCoordinates()[0] < walls[n].getTopRightInsideCoordinates()[2]) {
                    return false;
                }
                //Can't end the wall inside an existing wall
                //Check the x value
                else if (wall.getTopRightInsideCoordinates()[0] > walls[n].getBottomLeftOutsideCoordinates()[0] && wall.getTopRightInsideCoordinates()[0] + length < walls[n].getTopRightInsideCoordinates()[0]) {
                    return false;
                }
                //Check the y value
                else if (wall.getTopRightInsideCoordinates()[1] > walls[n].getBottomLeftOutsideCoordinates()[1] && wall.getTopRightInsideCoordinates()[1] + length < walls[n].getTopRightInsideCoordinates()[1]) {
                    return false;
                }
                //Check the z value
                else if (wall.getTopRightInsideCoordinates()[2] > walls[n].getBottomLeftOutsideCoordinates()[2] && wall.getTopRightInsideCoordinates()[2] + length < walls[n].getTopRightInsideCoordinates()[2]) {
                    return false;
                }
                //Can't have the wall overlap another wall
                else if ((wall.getBottomLeftOutsideCoordinates()[0] < walls[n].getBottomLeftOutsideCoordinates()[0] || wall.getBottomLeftOutsideCoordinates()[0] < walls[n].getBottomLeftOutsideCoordinates()[1] || wall.getBottomLeftOutsideCoordinates()[0] < walls[n].getBottomLeftOutsideCoordinates()[2]) && (wall.getTopRightInsideCoordinates()[0] > walls[n].getTopRightInsideCoordinates()[0] || wall.getTopRightInsideCoordinates()[1] > walls[n].getTopRightInsideCoordinates()[1] || wall.getTopRightInsideCoordinates()[2] > walls[n].getTopRightInsideCoordinates()[2])) {
                    return false;
                }
            }
        }
        if(walls.length == 0){
            InternalWall[] temp = new InternalWall[]{wall};
            walls = temp;
        }
        else {
            walls[walls.length] = wall;
        }
        return true;
    }

    public void removeWall(int wallIdx){

    }

    public void addWallFeature(int wallIdx, MaterialByUnit feature, double[] startPoint){

    }

    public void removeWallFeature(int wallIdx, int featureIdx){

    }
}
