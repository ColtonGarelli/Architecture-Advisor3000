package edu.ithaca.Group6;

public interface costByArea {
    String materialName = "";
    double costPerSquareMeter = -1;

    public double calcAreaMeter(double areaSquareFeet);

    public double calcCost(double areaSquareMeter);

    public void setMaterialName(String material);

    public void setCost(double cost);

    public String getMaterialName();

    public double getCostPerSquareMeter();

    public String toString();

}
