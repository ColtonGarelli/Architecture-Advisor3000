package edu.ithaca.Group6;

public interface Building {
    //Creating a building in the shape of a rectangular prism
    //Assume that the main function will prevent the user from inputting a negative dimension (i.e. -60.0 for the width)

    //Constructors
    public void Building();
    public void Building(double length, double width, double height, String extWallMaterial);

    public void setLength(double newVal);
    //set a new length of the building

    public double getLength();
    //get the length of the building

    public void setWidth(double newVal);
    //set a new width for the building

    public double getWidth();
    //get the width of the building

    public void setHeight(double newVal);
    //set a new height for the building

    public double getHeight();
    //get the height of the building

    public void setExtWallMaterial(String newMaterial);
    //set a new material for the external walls

    public String getExtWallMaterial();
    //get the material used to construct the exterior walls

    public double getSquareFootage();
    //get the square footage of the building

    public double getPerimeter();
    //calculate the perimeter of the building

    public double calcTotalCost();
    //Calculate the total cost of the walls
}
