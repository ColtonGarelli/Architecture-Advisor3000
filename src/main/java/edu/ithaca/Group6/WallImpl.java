package edu.ithaca.Group6;
import java.util.ArrayList;

public class WallImpl implements Wall {

    private double height;
    private double width;
    private MaterialByArea material = new Wood();
    private ArrayList <MaterialByUnit> featuresList;

    public WallImpl(){
        this.featuresList = new ArrayList<MaterialByUnit>();
    }

    public boolean setHeight(double height){
        if(height > 0) {
            this.height = height;
            return true;
        }
        else{
            return false;
        }
    }


    public double getHeight(){
        return this.height;
    }

    public boolean setWidth(double width) {
        if (width > 0) {
            this.width = width;
            return true;
        }
        else{
            return false;
        }
    }


    public double getWidth(){
        return this.width;
    }

    public boolean setMaterial(MaterialByArea wallMaterial) {
        this.material = wallMaterial;
        return true;
    }


    public MaterialByArea getMaterial(){
        return this.material;
    }


    public boolean addFeature(MaterialByUnit feature){
        this.featuresList.add(feature);
        return true;
    }


    public MaterialByUnit getFeature(int index){
            return this.featuresList.get(index);
    }


    public boolean removeFeature(int index){
        if(index > 0 && index < this.featuresList.size()-1){
            this.featuresList.remove(index);
            return true;
        }
        else{
            return false;
        }
    }

    public int getFeatureListSize(){
        return this.featuresList.size();
    }
}
