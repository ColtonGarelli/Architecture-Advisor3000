package edu.ithaca.Group6;
import java.util.ArrayList;


public abstract class WallImpl implements Wall{
    double height;
    double length;
    double width;
    MaterialByArea material;
}



class ExternalWall extends WallImpl {
    private double height;
    private double length;
    private double width;
    private MaterialByArea material = new Brick();
    private ArrayList<MaterialByUnit> featuresList;

    public ExternalWall() {
        this.featuresList = new ArrayList<MaterialByUnit>();
    }

    public boolean setHeight(double height) {
        if (height > 0) {
            this.height = height;
            return true;
        } else {
            return false;
        }
    }

    public double getHeight() {
        return this.height;
    }

    public boolean setLength(double length) {
        if (length > 0) {
            this.length = length;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getLength() {
        return this.length;
    }

    public boolean setThickness(double width) {
        if (width > 0) {
            this.width = width;
            return true;
        } else {
            return false;
        }
    }


    public double getWidth() {
        return this.width;
    }

    public boolean setMaterial(MaterialByArea wallMaterial) {
        this.material = wallMaterial;
        return true;
    }

    public MaterialByArea getMaterial() {
        return this.material;
    }


    public boolean addFeature(MaterialByUnit feature) {
        this.featuresList.add(feature);
        return true;
    }


    public MaterialByUnit getFeature(int index) {
        return this.featuresList.get(index);
    }


    public boolean removeFeature(int index) {
        if (index > 0 && index < this.featuresList.size() - 1) {
            this.featuresList.remove(index);
            return true;
        } else {
            return false;
        }
    }

    public int getFeatureListSize() {
        return this.featuresList.size();
    }
}

class InternalWall extends WallImpl{
    private double height;
    private double length;
    private double width;
    private MaterialByArea material;
    private ArrayList<MaterialByUnit> featuresList;


    public InternalWall(){
        this.featuresList = new ArrayList<MaterialByUnit>();
    }

    public boolean setHeight(double height) {
        if (height > 0) {
            this.height = height;
            return true;

        }
        else {
            return false;
        }

    }

    public double getHeight() {
            return this.height;

    }
    public boolean setLength(double length) {
        if (length > 0) {
            this.length = length;
            return true;

        }

        else {
            return false;
        }
    }

        @Override
    public double getLength() {
        return this.length;
    }

    public boolean setThickness(double width) {
        if (width > 0) {
            this.width = width;
            return true;
        }
        else {
            return false;
        }
    }


    public double getWidth() {
        return this.width;
    }

    public boolean setMaterial(MaterialByArea wallMaterial) {
        this.material = wallMaterial;
        return true;
    }


    public MaterialByArea getMaterial() {
        return this.material;
    }


    public boolean addFeature(MaterialByUnit feature) {
        this.featuresList.add(feature);
        return true;
    }


    public MaterialByUnit getFeature(int index) {
        return this.featuresList.get(index);
    }


    public boolean removeFeature(int index) {
        if (index > 0 && index < this.featuresList.size() - 1) {
            this.featuresList.remove(index);
            return true;

        }
        else {
            return false;
        }
    }

    public int getFeatureListSize() {
        return this.featuresList.size();
    }
}
