package edu.ithaca.Group6;

public abstract class costByAreaImpl implements costByArea{
    private String materialName;
    private double costPerSquareFoot;
    private String costPerSquareFootStr;

    public abstract String materialNameBuilder();
    public abstract double costPerSquareFeetBuilder();

    public costByAreaImpl(){
        this.materialName = materialNameBuilder();
        this.costPerSquareFoot = costPerSquareFeetBuilder();
        this.costPerSquareFootStr = convertDoubleToString(this.costPerSquareFoot);
    }

    private String convertDoubleToString(double toConvert){
        return String.format("%.2f",toConvert); //formats the string to have two trailing decimals
    }

    @Override
    public double calcAreaMeter(double areaSquareFeet) {
        double conversionFactor = 0.092903; //conversion rate from square feet to square meters
        if(areaSquareFeet < 0){
            throw new IndexOutOfBoundsException("Cannot have negative area");
        }else if(areaSquareFeet == 0){
            return 0;
        }
        else {
            double areaSquareMeters = (long) (conversionFactor * areaSquareFeet * 1e4) / 1e4;
            return areaSquareMeters;
        }
    }

    @Override
    public double calcCost(double areaSquareFeet) {
        if(areaSquareFeet < 0){
            throw new IndexOutOfBoundsException("Cannot have negative area");
        }else if(areaSquareFeet == 0) {
            return 0;
        }
        else{
            double cost = (long) (costPerSquareFoot * areaSquareFeet * 1e2) / 1e2;
            return cost;
        }
    }

    @Override
    public void setMaterialName(String material) {
        if(material == ""){
            throw new NullPointerException("Cannot set a material name to blank!");
        }
        this.materialName = material;
    }

    @Override
    public void setCost(double cost) {
        if(cost < 0){
            throw new IndexOutOfBoundsException("Cannot set cost to be negative!");
        }else {
            this.costPerSquareFoot = cost;
        }
    }

    @Override
    public String getMaterialName() {
        return this.materialName;
    }

    @Override
    public double getCostPerSquareFoot() {
        return this.costPerSquareFoot;
    }

    @Override
    public String toString(){
        return this.materialName + " : $" +this.costPerSquareFootStr + " per square foot";
    }
}

class Wood extends costByAreaImpl{
    @Override
    public String materialNameBuilder() {
        return "Wood";
    }

    @Override
    public double costPerSquareFeetBuilder() {
        return 1.00;
    }
}

class Brick extends costByAreaImpl{

    @Override
    public String materialNameBuilder() {
        return "Brick";
    }

    @Override
    public double costPerSquareFeetBuilder() {
        return 142.34231564;
    }
}

class ClayBrick extends costByAreaImpl{

    @Override
    public String materialNameBuilder() {
        return "Clay Brick";
    }

    @Override
    public double costPerSquareFeetBuilder() {
        return 0.04;
    }
}

class ConcreteBrick extends costByAreaImpl{

    @Override
    public String materialNameBuilder() {
        return "Concrete Brick";
    }

    @Override
    public double costPerSquareFeetBuilder() {
        return 0.03;
    }
}

class TwoByFour extends costByAreaImpl{

    @Override
    public String materialNameBuilder() {
        return "Two by Four Wood";
    }

    @Override
    public double costPerSquareFeetBuilder() {
        return 1.66;
    }
}

class TwoByThree extends costByAreaImpl{

    @Override
    public String materialNameBuilder() {
        return "Two by Three Wood";
    }

    @Override
    public double costPerSquareFeetBuilder() {
        return 1.23;
    }
}