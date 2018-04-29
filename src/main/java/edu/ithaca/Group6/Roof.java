package edu.ithaca.Group6;

public interface Roof {
    double length = 0;
    double width = 0;
    double height = 0;

    MaterialByArea material = new Wood();
    double[] firstCornerCoordinates = new double[3];
    double[] secondCornerCoordinates = new double[3];

    // each coordinate set equal to 0 as origin point for wall upon instantiation

    /**
     * sets coordinates for the first corner
     * @param x x position
     * @param y y position
     * @param z z start position
     * @return true if success, false otherwise
     */
    public boolean setFirstCornerCoordinates(double x, double y, double z);

    /**
     * sets coordinates for first corner
     * @param xyzCoord array of coordinates in the form {x,y,z} as in previous
     * @return true if success, false otherwise
     */
    public boolean setFirstCornerCoordinates(double[] xyzCoord);

    /**
     *
     * @return the array of coordinates in form {x,y,z}
     */
    public double[] getFirstCornerCoordinates();

    /**
     * sets coordinates for the second corner
     * @param x x position
     * @param y y position
     * @param z z end position
     * @return true if success, false otherwise
     * x=wall height, y= wall length, z = wall thickness
     */
    public boolean setSecondCornerCoordinates(double x, double y, double z);

    /**
     * sets coordinates for first corner
     * @param xyzCoord array of coordinates in the form {x,y,z} as in previous
     * @return true if success, false otherwise
     */
    public boolean setSecondCornerCoordinates(double[] xyzCoord);

    /**
     *
     * @return the array of coordinates in form {x,y,z}
     */
    public double[] getSecondCornerCoordinates();

    public boolean setHeight(double height);

    public double getHeight();

    public boolean setWidth(double width);

    public double getWidth();

    public boolean setLength(double length);

    public double getLength();

    public boolean setMaterial(MaterialByArea wallMaterial);

    public MaterialByArea getMaterial();

    public String getFirstCornerCoordString();

    public String getSecondCornerCoordString();
    }
