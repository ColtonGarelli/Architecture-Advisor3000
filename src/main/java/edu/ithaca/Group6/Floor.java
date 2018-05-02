package edu.ithaca.Group6;

public interface Floor {

    /**
     * Sets the height of the floor.
     * Height should be within the height range of the house
     * @param height Z coordinate at which the floor exists in the structure
     */
    public void setHeight(double height);

    /**
     *
     */
    public double getHeight();

    /**
     *
     */
    public void setMaterial(MaterialByArea material);

    /**
     *
     */
    public MaterialByArea getMaterial();

}
