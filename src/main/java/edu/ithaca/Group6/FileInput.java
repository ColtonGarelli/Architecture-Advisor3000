package edu.ithaca.Group6;

import java.io.BufferedReader;

public interface FileInput {
    String fileInName = "";
    BufferedReader inReader = null;

    /**
     * Creates the FileInputStream from the fileInName
     */
    public void generateInStream();

    /**
     * Loads a building from a file
     * @return Building of the file
     */
    public BuildingImpl loadFromFile();

    /**
     * Loads the master file that contains the smaller files
     * @return a string array of file names to load from
     */
    public String[] loadFileNames();
}
