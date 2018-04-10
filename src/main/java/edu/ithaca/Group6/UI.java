package edu.ithaca.Group6;

public interface UI {
    public void main();

    /**
     * Determines if the user input a valid yes or no answer
     * @param userInput String of what the user responds
     * @return True if valid yes/no, False if invalid
     */
    public boolean checkYesOrNo(String userInput);

    /**
     * Determines if the user input is a valid double
     * @param userInput String of what the user inputs
     * @return True if a valid double, False if invalid entry
     */
    public boolean checkValidDouble(String userInput);

    /**
     * Determines if the user input is a valid integer
     * @param userInput String of what the user inputs
     * @return True if a valid integer, False if invalid entry
     */
    public boolean checkValidInt(String userInput);

    /**
     * Displays a list of available MaterialByArea objects as a string
     * Includes names and cost per square unit
     * @Return String containing MaterialByArea object data
     */
    public String displayMaterialsByArea();
}
