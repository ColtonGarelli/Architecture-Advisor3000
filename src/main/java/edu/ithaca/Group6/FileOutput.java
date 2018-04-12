package edu.ithaca.Group6;

import java.io.FileOutputStream;

public interface FileOutput {
    String fileOutName = "";
    FileOutputStream outStream = null;

    /**
     * Creates the FileOutputStream from the fileOutName
     */
    public void generateOutStream();


    public String generateOutString(Building buildingToOutput);

}
