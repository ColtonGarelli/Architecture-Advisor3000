package edu.ithaca.Group6;

import java.util.ArrayList;

public interface Building {
    //Creating a building in the shape of a rectangular prism
    //Assume that the main function will prevent the user from inputting a negative dimension (i.e. -60.0 for the width)
    public ArrayList<ExternalWall> walls = new ArrayList<ExternalWall>();
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

    public double getSquareFootage();
    //get the square footage of the building

    public double getPerimeter();
    //calculate the perimeter of the building

    public double calcTotalCost();
    //Calculate the total cost of the walls

    /**
     *
     * @param wallIdx index of the wall in list of walls
     * @return the Wall at that index
     */
    public Wall getWall(int wallIdx);

    /**
     * Add a wall to the array of walls in the building
     * @param wall wall to be added
     * @post Wall array in building gets incremented
     * @return true or false value indicating whether a wall was added
     */
    public boolean addWall(ExternalWall wall);

    /**
     * Remove a wall from the array
     * @param wallIdx
     * @post delete a wall from the array of walls in the building
     */
    public void removeWall(int wallIdx);

    /**
     * Add a feature (door, window) to a wall
     * @param wallIdx
     * @param feature
     * @post add a wall feature to the array in a wall object
     */
    public void addWallFeature(int wallIdx, MaterialByUnit feature);

    /**
     * Add a feature (door, window) to a wall
     * @param wallIdx
     * @param feature
     * @param startPoint
     * @post add a wall feature to the array in a wall object
     */
    public void addWallFeature(int wallIdx, MaterialByUnit feature, double[] startPoint);

    /**
     * Remove a feature (door, window) to a wall
     * @param wallIdx
     * @param featureIdx
     * @post delete a feature from the array of features in the wall
     */
    public void removeWallFeature(int wallIdx, int featureIdx);

    /**
     * Changes the material of a wall
     * @param wallIdx index of the wall
     * @param wallMaterial new material of the wall
     * @return true if success, false if otherwise
     */
    public boolean setWallMaterial(int wallIdx, MaterialByArea wallMaterial);


    /**
     * Adds a roof to the building
     * @param roofToAdd
     * @return true if successful add, false otherwise
     */
    public boolean setRoof(Roof roofToAdd);

    /**
     *
     * @return the roof of the building
     */
    public Roof getRoof();

    /**
     *
     * @return the amount of walls in a building
     */
    public int getWallAmount();

    public boolean removeFloor(int index);

    public Floor getFloor(int index);

    public boolean addFloor(Floor floorToAdd);

    public int getNumberOfFloors();

    public String buildingToString();


    }
