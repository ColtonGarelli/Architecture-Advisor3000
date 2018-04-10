package edu.ithaca.Group6;
import java.util.ArrayList;



public interface Wall {

    public double height = 0;
    public double length = 0;
    public double width = 0;
    public MaterialByArea material = new Brick();
    public ArrayList<MaterialByUnit> featuresList = new ArrayList<MaterialByUnit>();


    public boolean setHeight(double height);

    public double getHeight();

    public boolean setLength(double length);

    public double getLength();

    public boolean setThickness(double width);

    public double getWidth();

    public boolean setMaterial(MaterialByArea wallMaterial);

    public MaterialByArea getMaterial();

    public boolean addFeature(MaterialByUnit feature);

    public MaterialByUnit getFeature(int index);

    public boolean removeFeature(int index);

    public int getFeatureListSize();

}
