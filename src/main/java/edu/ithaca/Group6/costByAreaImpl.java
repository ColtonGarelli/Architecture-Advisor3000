package edu.ithaca.Group6;

public class costByAreaImpl implements costByArea{
    private String materialName;
    private double costPerSquareMeter;


    public costByAreaImpl(String material, double cost){
        this.materialName = material;
        this.costPerSquareMeter = cost;
    }

    @Override
    public double calcAreaMeter(double areaSquareFeet) {
        return 0;
    }

    @Override
    public double calcCost(double areaSquareMeter) {
        return 0;
    }

    @Override
    public void setMaterialName(String material) {
        this.materialName = material;
    }

    @Override
    public void setCost(double cost) {
        this.costPerSquareMeter = cost;
    }

    @Override
    public String getMaterialName() {
        return this.materialName;
    }

    @Override
    public double getCostPerSquareMeter() {
        return this.costPerSquareMeter;
    }
}
