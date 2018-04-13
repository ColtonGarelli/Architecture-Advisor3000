package edu.ithaca.Group6;
import java.util.ArrayList;
import java.util.HashMap;


public interface Wall {

    double height = 0;
    double length = 0;
    double thickness = 0;
    MaterialByArea material = new Brick();
    ArrayList<MaterialByUnit> featuresList = new ArrayList<MaterialByUnit>();
    HashMap<String, Double> dimensions = new HashMap<String, Double>();


    public boolean calculateDimensions();

    public boolean setDimensions();

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
