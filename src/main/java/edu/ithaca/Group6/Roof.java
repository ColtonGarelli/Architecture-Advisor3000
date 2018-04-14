package edu.ithaca.Group6;

public interface Roof {
    double length = 0;
    double width = 0;
    double height = 0;

    MaterialByArea material = new Wood();
    double[] firstCornerCoordinates = new double[3];
    double[] secondCornerCoordinates = new double[3];

    // each coordinate set equal to 0 as origin point for wall upon instantiation
    public boolean setFirstCornerCoordinates(double x, double y, double z);

    public double[] getFirstCornerCoordinates();

    // x=wall height, y= wall length, z = wall thickness
    public boolean setSecondCornerCoordinates(double x, double y, double z);

    public double[] getSecondCornerCoordinates();

    public boolean setHeight(double height);

    public double getHeight();

    public boolean setLength(double length);

    public double getLength();

    public boolean setMaterial(MaterialByArea wallMaterial);

    public MaterialByArea getMaterial();

}
