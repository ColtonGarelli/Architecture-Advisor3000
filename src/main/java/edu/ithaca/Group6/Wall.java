package edu.ithaca.Group6;
import java.util.ArrayList;

public class Wall {

    private double height;
    private double width;
    private costByArea material;
    private ArrayList <costByUnit> featuresList;

    public boolean setHeight(float height){
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
        if (height > 0) {
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

    public boolean setMaterial(costByArea wallMaterial) {
        this.material = wallMaterial;
        return true;
    }

    public costByArea getMaterial(){
        return this.material;
    }

    public ArrayList<costByUnit> addFeature(costByUnit feature){
        Wall testWall = new Wall();
        return testWall.featuresList;
    }

    public void getFeature(int index){

    }

    public void removeFeature(int index){

    }

}
