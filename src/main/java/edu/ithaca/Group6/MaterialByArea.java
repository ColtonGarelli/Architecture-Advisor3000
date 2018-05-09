package edu.ithaca.Group6;

public interface MaterialByArea {
    String materialName = "";
    double costPerSquareFoot = -1;
    String costPerSquareFootStr = "";

    public String materialNameBuilder();
    public double costPerSquareFeetBuilder();

    /**
     * Converts an area in square feet to an area in square meters
     * for use in physics calculations later on
     * @param areaSquareFeet the area in square feet
     * @return area in square meters
     */
    public double calcAreaMeter(double areaSquareFeet);

    /**
     * Calculates the cost of the material
     * @param areaSquareFoot the area of the material in square feet
     * @return total cost
     */
    public double calcCost(double areaSquareFoot);

    /**
     * sets the name of the material
     * @param material new name
     * @post materialName is changed to material
     */
    public void setMaterialName(String material);

    /**
     * sets the cost of the material in cost/area in square feet
     * @param cost cost per area in square foot
     * @post costPerSquareMeter is changed to cost
     */
    public void setCost(double cost);

    public String getMaterialName();

    public double getCostPerSquareFoot();

    /**
     *
     * @return String following the form:
     * "MaterialName : $Amount per square foot"
     * ***The amount always rounds down to the next nearest cent***
     */
    public String toString();

}
