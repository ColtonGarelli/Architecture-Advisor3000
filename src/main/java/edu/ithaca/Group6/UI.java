package edu.ithaca.Group6;

public interface UI {
    public void main();

    /**
     * Determines if the user input a valid yes or no answer
     * @param userInput String of what the user responds
     * @return True if valid yes/no, False if invalid
     */
    public boolean getYesOrNo(String userInput);
}
