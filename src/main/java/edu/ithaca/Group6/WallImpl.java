package edu.ithaca.Group6;
import java.util.ArrayList;


public abstract class WallImpl implements Wall{
//    an abstract class that defines both kinds of walls
    public abstract boolean setHeight(double height);
    public abstract double getHeight();
    public abstract boolean setLength(double length);
    public abstract double getLength();
    public abstract boolean setThickness(double thickness);
    public abstract double getThickness();
    public abstract boolean setBottomCoordinates(double x, double y, double z);
    public abstract double[] getBottomCoordinates();
    public abstract boolean setTopCoordinates(double x, double y, double z);
    public abstract double[] getTopCoordinates();
}


class ExternalWall extends WallImpl {
    private double height;
    private double length;
    private double thickness;
    private MaterialByArea material;
    private ArrayList<MaterialByUnit> featuresList;
    private double[] bottomCoordinates = new double[3];
    private double[] topCoordinates = new double[3];

    public ExternalWall() {
        this.featuresList = new ArrayList<MaterialByUnit>();
        this.setBottomCoordinates(0,0,0);
    }

    public ExternalWall(double height, double length, double thickness, double[] startPoint, MaterialByArea material){
        this.height = height;
        this.length = length;
        this.thickness = thickness;
        this.material = material;
        this.featuresList = new ArrayList<MaterialByUnit>();
        this.setBottomCoordinates(startPoint[0], startPoint[1], startPoint[2]);
        if(this.thickness > this.length){
            this.setTopCoordinates(startPoint[0] + this.thickness, startPoint[1] + this.length, startPoint[2] + this.height);
        }
        else{
            this.setTopCoordinates(startPoint[0] + this.length, startPoint[1] + this.thickness, startPoint[2] + this.height);
        }
    }

    public boolean setBottomCoordinates(double x, double y, double z){
        if(x>=0 && y>=0 && z>=0){
            this.bottomCoordinates[0] = x;
            this.bottomCoordinates[1] = y;
            this.bottomCoordinates[2] = z;
            return true;
        }
        else{
            return false;
        }
    }

    public double[] getBottomCoordinates(){
        return this.bottomCoordinates;
    }

    public boolean setTopCoordinates(double x, double y, double z){
        if(x>=0 && y>=0 && z>=0){
            this.topCoordinates[0] = x;
            this.topCoordinates[1] = y;
            this.topCoordinates[2] = z;
            return true;
        }
        else{
            return false;
        }
    }

    public double[] getTopCoordinates(){
        return this.topCoordinates;
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

    public double getLength() {
        return this.length;
    }

    public boolean setThickness(double width) {
        if (width > 0) {
            this.thickness = width;
            return true;
        } else {
            return false;
        }
    }


    public double getThickness() {
        return this.thickness;
    }

    public boolean setMaterial(MaterialByArea wallMaterial) {
        this.material = wallMaterial;
        return true;
    }

    public MaterialByArea getMaterial() {
        return this.material;
    }

    public double getArea(){
        double area = this.length * this.thickness * this.height;
        return area;
    }

    public double calcCost(){
        double cost = this.getArea() * this.getMaterial().getCostPerSquareFoot();
        return cost;
    }

    public boolean addFeature(MaterialByUnit feature) {
        try{this.featuresList.add(feature);
        return true;}catch(Exception e){
            return false;
        }
    }


    public MaterialByUnit getFeature(int index) {
        return this.featuresList.get(index);
    }


    public boolean removeFeature(int index) {
        if (index > -1 && index < this.featuresList.size()) {
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