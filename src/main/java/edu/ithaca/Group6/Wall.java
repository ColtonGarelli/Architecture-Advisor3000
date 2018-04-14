package edu.ithaca.Group6;
import java.util.ArrayList;
import java.util.HashMap;


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

    // x=wall height, y= wall length, z = wall thickness
    public boolean setTopCoordinates(double x, double y, double z);

    public double[] getTopCoordinates();

    public boolean setHeight(double height);

    public double getHeight();

    public boolean setLength(double length);

    public double getLength();

    public boolean setThickness(double width);

    public double getThickness();

    public boolean setMaterial(MaterialByArea wallMaterial);

    public MaterialByArea getMaterial();

    public boolean addFeature(MaterialByUnit feature);

    public MaterialByUnit getFeature(int index);

    public boolean removeFeature(int index);

    public int getFeatureListSize();

}
