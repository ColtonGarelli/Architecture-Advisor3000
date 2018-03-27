package edu.ithaca.Group6;

public interface costByArea {
    String materialName = "";
    double costPerSquareMeter = -1;
    String costPerSquareMeterStr = "";

    /**
     * Converts an area in square feet to an area in square meters
     * @param areaSquareFeet the area in square feet
     * @return area in square meters
     */
    public double calcAreaMeter(double areaSquareFeet);

    /**
     * Calculates the cost of the material
     * @param areaSquareMeter the area of the material in square meters
     * @return total cost
     */
    public double calcCost(double areaSquareMeter);

    /**
     * sets the name of the material
     * @param material new name
     * @post materialName is changed to material
     */
    public void setMaterialName(String material);

    /**
     * sets the cost of the material in cost/area in square meters
     * @param cost cost per area in square meters
     * @post costPerSquareMeter is changed to cost
     */
    public void setCost(double cost);

    /**
     *
     * @return materialName
     */
    public String getMaterialName();

    /**
     *
     * @return costPerSquareMeter
     */
    public double getCostPerSquareMeter();

    /**
     *
     * @return String following the form:
     * "MaterialName : $Amount per square meter"
     * ***The amount always rounds down to the next nearest cent***
     */
    public String toString();

}
