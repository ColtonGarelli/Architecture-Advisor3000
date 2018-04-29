package edu.ithaca.Group6;

import java.io.FileOutputStream;

public interface FileOutput {
    String fileOutName = "";
    FileOutputStream outStream = null;

    /**
     * Creates the FileOutputStream from the fileOutName
     */
    public void generateOutStream();


    /**
     * Generates a string to be written to a file
     * @param buildingToOutput the building wished to be put into the file
     * @return string representing the building and all its walls/features
     */
    public String generateOutString(Building buildingToOutput);

    /**
     * Saves to the file
     * @return true if success, false otherwise
     */
    public boolean saveToFile(String outStr);

}
