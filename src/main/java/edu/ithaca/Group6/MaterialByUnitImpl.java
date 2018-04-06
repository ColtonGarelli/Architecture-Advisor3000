package edu.ithaca.Group6;

public abstract class MaterialByUnitImpl implements MaterialByUnit{
    private String materialName = "";
    private double costPerUnit = 0.00;
    private double length = 0.0;
    private double height = 0.0;

    public abstract String materialNameBuilder();
    public abstract double costPerUnitBuilder();
    public abstract double lengthBuilder();
    public abstract double heightBuilder();

    public MaterialByUnitImpl(){
        this.materialName = materialNameBuilder();
        this.costPerUnit = costPerUnitBuilder();
        this.length = lengthBuilder();
        this.height = heightBuilder();
    }

    @Override
    public String getMaterialName() { return this.materialName; }

    @Override
    public void setMaterialName(String newMaterial) { this.materialName = newMaterial; }

    @Override
    public double getCostPerUnit() { return this.costPerUnit; }

    @Override
    public void setCostPerUnit(double newCost) {
        if(newCost < 0){
            throw new IndexOutOfBoundsException("Cannot set cost to be negative");
        }
        else{
            this.costPerUnit = newCost;
        }
    }

    @Override
    public double getLength() { return this.length; }

    @Override
    public void setLength(double newLength) {
        if(newLength < 0){
            throw new IndexOutOfBoundsException("Cannot set length to be negative");
        }
        else{
            this.length = newLength;
        }
    }

    @Override
    public double getHeight() { return this.height; }

    @Override
    public void setHeight(double newHeight) {
        if(newHeight < 0){
            throw new IndexOutOfBoundsException("Cannot set height to be negative");
        }
        else{
            this.length = newHeight;
        }
    }

    @Override
    public String toString() {
        String costStr = String.format("%.2f",this.costPerUnit);
        return this.materialName + ", $" + costStr + ", Length: " + this.length + "ft, Height: " + this.height + "ft";
    }

    @Override
    public double getArea() { return this.length * this.height; }
}

class Door extends MaterialByUnitImpl {
    @Override
    public String materialNameBuilder() {
        return "Door";
    }

    @Override
    public double costPerUnitBuilder() { return 900.00; }

    @Override
    public double lengthBuilder() { return 3.0; }

    @Override
    public double heightBuilder() { return 6.67; }
}
