package edu.ithaca.Group6;
import java.util.ArrayList;


public interface Wall {

    double height = 0;
    double length = 0;
    double thickness = 0;
    MaterialByArea material = new Brick();
    ArrayList<MaterialByUnit> featuresList = new ArrayList<MaterialByUnit>();
    double[] bottomCoordinates = new double[3];
    double[] topCoordinates = new double[3];

    // each coordinate set equal to 0 as origin point for wall upon instantiation
    public boolean setBottomCoordinates(double x, double y, double z);

    public double[] getBottomCoordinates();

    // x=wall thickness, y= wall length, z = wall height
    public boolean setTopCoordinates(double x, double y, double z);

    /**
     *
     * @return coordinates of top corner in {x,y,z}
     */
    public double[] getTopCoordinates();

    /**
     *
     * @param height height of the wall
     * @return true if successful, false otherwise
     */
    public boolean setHeight(double height);

    public double getHeight();

    public boolean setLength(double length);

    public double getLength();

    public boolean setThickness(double width);

    public double getThickness();

    /**
     * Sets the material of the wall
     * @param wallMaterial MaterialByArea, such as brick
     * @return true if success, false otherwise
     */
    public boolean setMaterial(MaterialByArea wallMaterial);

    /**
     *
     * @return the material of the wall
     */
    public MaterialByArea getMaterial();

    /**
     * calculate the area of the wall in square feet
     * @return volume
     */
    public double getArea();

    /**
     * calculate the cost of the wall based on the area and material
     * @return cost
     */
    public double calcCost();

    /**
     * Adds a feature to a wall
     * @param feature a MaterialByUnit feature such as window/door
     * @return true if successful, false otherwise
     */
    public boolean addFeature(MaterialByUnit feature);

    /**
     * Gets a feature
     * @param index index of the feature
     * @return the feature as a MaterialByUnit object such as door/window
     */
    public MaterialByUnit getFeature(int index);

    /**
     * Removes a feature by its index
     * @param index index of the feature
     * @return true is successful, false if invalid index
     */
    public boolean removeFeature(int index);

    /**
     *
     * @return length of the list of features
     */
    public int getFeatureListSize();

    /**
     *
     * @return a string of the wall to be used in the output file
     */
    public String outString();

    public void addStairs(Stairs stairsToAdd);
}
