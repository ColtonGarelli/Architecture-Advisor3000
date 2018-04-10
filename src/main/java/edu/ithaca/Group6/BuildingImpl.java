package edu.ithaca.Group6;

public class BuildingImpl implements Building{
    //Creating a building in the shape of a rectangular prism
    double length;
    double width;
    double height;
    MaterialByArea extWallMaterial;
    public BuildingImpl(){
        this.length = 0.0;
        this.width = 0.0;
        this.height = 0.0;
    }

    public BuildingImpl(double length, double width, double height, MaterialByArea extWallMaterial) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.extWallMaterial = extWallMaterial;
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

    public void setExtWallMaterial(MaterialByArea newMaterial) {
        //set a new material for the external walls
        extWallMaterial = newMaterial;
    }

    public String getExtWallMaterial() {
        //return the name of the exterior wall material
        return extWallMaterial.getMaterialName();
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
        double costExtWall = this.extWallMaterial.calcCost(surfaceArea);
        totalCost += costExtWall;

        return totalCost;
    }

}
