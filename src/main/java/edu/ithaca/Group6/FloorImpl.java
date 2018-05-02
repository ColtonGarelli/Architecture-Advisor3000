package edu.ithaca.Group6;

public class FloorImpl implements Floor {

    private double height;
    private MaterialByArea material;

    public FloorImpl(double height, MaterialByArea material){
        this.height = height;
        this.material = material;
    }

    public void setHeight(double height){
        this.height = height;
    }


    public double getHeight() {
        return this.height;
    }


    public void setMaterial(MaterialByArea material) {
        this.material = material;
    }


    public MaterialByArea getMaterial() {
        return this.material;
    }

    public String floorOutString(){
        String floorString;
        floorString = "F: " + this.material.getMaterialName() + "_" + this.height;
        return floorString;
    }
}
