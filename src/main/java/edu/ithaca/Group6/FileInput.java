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
    public Building loadFromFile();
}
