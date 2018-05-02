package edu.ithaca.Group6;

public abstract class BuildingFeaturesImpl implements BuildingFeatures {

   public abstract double getCostPerUnit();

   public abstract String getFeatureName();

}

class Ceiling extends BuildingFeaturesImpl{
    double length;
    double width;
    double thickness;
    MaterialByArea material;
    String name = "Ceiling";
    double cost;

    public Ceiling(){


    }

    public double getCostPerUnit(){
        return this.cost;
    }

    public String getFeatureName(){
        return this.name;
    }

}

class Stairs extends BuildingFeaturesImpl{
    double height;
    int numStairs;
    double width;
    double thickness;
    MaterialByArea material;
    String name = "Stairs";

    public Stairs(double height, int numStairs, double width, double thickness, MaterialByArea material){
        this.height = height;
        this.numStairs = numStairs;
        this.width = width;
        this.thickness = thickness;
        this.material = material;
    }

    public double getHeight(){
        return this.height;
    }

    public int getNumStairs() { return numStairs; }

    public String getFeatureName(){
        return name;
    }

    public double getCostPerUnit(){
        double cost = 0.0;
        double area = 0.0;
        //one side of the stairs is a right triangle which is as wide as the width and as tall as the height.
        //The area would be height*width/2, but there are two sides so that total is doubled.
        area += height*width;
        area += height*thickness;
        area += width*thickness;
        cost = area * material.getCostPerSquareFoot();
        return cost;
    }

    public double getWidth(){
        return this.width;
    }

}
