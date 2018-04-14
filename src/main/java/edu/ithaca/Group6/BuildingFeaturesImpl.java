package edu.ithaca.Group6;

public abstract class BuildingFeaturesImpl implements BuildingFeatures {

   public abstract double getCost();

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

    public double getCost(){
        return this.cost;
    }

    public String getFeatureName(){
        return this.name;
    }

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
