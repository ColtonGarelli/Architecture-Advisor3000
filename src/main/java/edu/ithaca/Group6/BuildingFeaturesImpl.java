package edu.ithaca.Group6;

public abstract class BuildingFeaturesImpl implements BuildingFeatures {

   public abstract double getCost();

   public abstract String getFeatureName();

}

class Stairs extends BuildingFeaturesImpl{
    double perStairlength;
    double width;
    double thickness;
    MaterialByArea material;
    String name = "Ceiling";
    double cost;

    public double getPerStairlengthLength(){
        return this.perStairlength;
    }

    public String getFeatureName(){
        return name;
    }

    public double getCost(){
        return this.cost;
    }

    public double getWidth(){
        return this.width;
    }

}
