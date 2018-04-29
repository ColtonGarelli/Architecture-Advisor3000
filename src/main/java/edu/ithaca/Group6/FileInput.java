package edu.ithaca.Group6;

import java.io.File;
import java.io.FileInputStream;

public interface FileInput {
    String fileInName = "";
    FileInputStream inStream = null;

    /**
     * Creates the FileInputStream from the fileInName
     */
    public void generateInStream();


    /**
     * Generates a string from a file
     * @param inFile the name of the file to be loaded from
     * @return string representing the building and all its walls/features
     */
    public String generateInString(File inFile);

    /**
     * Loads a building from a file
     * @return Building of the file
     */
    public Building loadFromFile(String inStr);
}
