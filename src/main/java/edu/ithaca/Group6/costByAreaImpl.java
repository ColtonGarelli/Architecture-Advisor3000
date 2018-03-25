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
        if(areaSquareFeet < 0){
            throw new IndexOutOfBoundsException("Cannot have negative area");
        }else if(areaSquareFeet == 0){
            return 0;
        }
        else {
            double areaSquareMeters = (long) (0.092903 * areaSquareFeet * 1e4) / 1e4;
            return areaSquareMeters;
        }
    }

    @Override
    public double calcCost(double areaSquareMeter) {
        if(areaSquareMeter < 0){
            throw new IndexOutOfBoundsException("Cannot have negative area");
        }else if(areaSquareMeter == 0) {
            return 0;
        }
        else{
            double cost = (long) (costPerSquareMeter * areaSquareMeter * 1e2) / 1e2;
            return cost;
        }
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
