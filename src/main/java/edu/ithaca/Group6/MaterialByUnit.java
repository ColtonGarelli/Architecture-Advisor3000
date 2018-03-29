package edu.ithaca.Group6;

public interface MaterialByUnit {
    String materialName = "";
    double costPerUnit = 0.00;
    double length = 0.0;
    double height = 0.0;

    public String materialNameBuilder();
    public double costPerUnitBuilder();
    public double lengthBuilder();
    public double heightBuilder();

    /**
     * Get the name of the material
     * @return materialName
     */
    public String getMaterialName();

    /**
     * Set a new material name
     * @param newMaterial
     * @post materialName becomes newMaterial
     */
    public void setMaterialName(String newMaterial);

    /**
     * Get the cost of an individual unit of the material
     * @return costPerUnit
     */
    public double getCostPerUnit();

    /**
     * Set a new cost per unit
     * @param newCost
     * @post costPerUnit becomes newCost
     */
    public void setCostPerUnit(double newCost);

    /**
     * Get the length
     * @return length
     */
    public double getLength();

    /**
     * Set a new length (in feet)
     * @param newLength
     * @post length becomes newLength
     */
    public void setLength(double newLength);

    /**
     * Get the height
     * @return height
     */
    public double getHeight();

    /**
     * Set a new height (in feet)
     * @param newHeight
     * @post height becomes newHeight
     */
    public void setHeight(double newHeight);

    /**
     *
     * @return String of the form:
     * MaterialName + ": $" + amount per unit
     * Rounds up to the nearest cent
     */
    public String toString();

    /**
     * calculate the area of the object
     * @return length * height
     */
    public double getArea();
}
