package edu.ithaca.Group6;
//import javafx.scene.paint.Material;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Character.isLetter;

public class UIImpl implements UI {
    public Scanner userIn;
    public ArrayList<Building> buildingList = new ArrayList<Building>();
    public FileInput saveFileIn;
    public FileOutput saveFileOut;

    public UIImpl() {
        this.userIn = new Scanner(System.in);
    }

    public static void main(String[] args) {
        UI demo = new UIImpl();
        demo.sprintThreeDemo();
    }

    public int enterValidInt(int startInt, int endInt) {
        int userInt = startInt - 1;
        while (userInt < startInt || userInt > endInt) {
            String userInput = userIn.next();
            while (!checkValidInt(userInput)) {
                System.out.println("Please enter a valid option, " + startInt + " - " + endInt + "");
                userInput = userIn.next();
            }
            userInt = Integer.parseInt(userInput);
            if (userInt < startInt || userInt > endInt) {
                System.out.println("Please enter a valid option, " + startInt + " - " + endInt + "");
            }
        }
        return userInt;
    }

    /**
     * Determines if a user input is both valid and whether it is yes or no
     *
     * @param userInput
     * @return true if yes, false if no
     */
    public boolean yesOrNo(String userInput) {
        while (!checkYesOrNo(userInput)) {
            System.out.println("Please enter a valid yes or no option.");
            userInput = userIn.next();
        }
        String shortUserInput = userInput.substring(0, 1);
        //Lowercase the string
        shortUserInput = shortUserInput.toLowerCase();
        //Compare if yes or no
        if (shortUserInput.equals("y")) {
            return true;
        } else {
            return false;
        }

    }

    //    in a list of options, quit will always be 0
    public void sprintThreeDemo() {
        System.out.println("Welcome to the Architecture Advisor3000");
        System.out.println("\nWhen you would like to begin modifying your project enter Yes.");
        String entry = userIn.next();
        Building demoBuilding;
        boolean userYes = yesOrNo(entry);
        while (!userYes) {
            System.out.println("Please enter Yes when ready");
            entry = userIn.next();
            userYes = yesOrNo(entry);
        }
        System.out.println("You have the option to load from a save slot. Would you like to load?");
        entry = userIn.next();
        userYes = yesOrNo(entry);
        if (userYes) {
            demoBuilding = keepLoading();
        }else{
            demoBuilding = createNewBuilding();
        }
        this.addBuilding(demoBuilding);
        boolean modificationsDone = false;
        while (!modificationsDone) {
            modificationsDone = modifyWalls(demoBuilding);
        }
        System.out.println("To create or select another building, enter 1. To quit enter 0.");
        int switchBuildings = enterValidInt(0, 1);
        while (switchBuildings == 1) {
            System.out.println("Enter 1 to modify an existing building.\nEnter 2 to create a new building.\nEnter 0 to go back.");
            int option = enterValidInt(0, 2);
            try {
                switch (option) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 0:
                        switchBuildings = 0;
                        break;
                    default:
                        System.out.println("There was a problem selecting buildings");
                }
            } catch (Exception e) {
                System.out.println("Error type " + e.getMessage() + " occured.");
            }
        }
        System.out.println(buildingOutput(demoBuilding));
        for (int i = 0; i < demoBuilding.getWallAmount(); i++) {
            System.out.println(displayWalls(demoBuilding.getWall(i)));
        }
        System.out.println("Select which file to save to.");
        int saveChoice = displayAvailableFiles();
        this.saveFileOut = selectOutFile(saveChoice);
        boolean didSave = saveToFile(saveFileOut,demoBuilding);
        while(!didSave){
            System.out.println("Save failed. Try again.");
            saveChoice = displayAvailableFiles();
            this.saveFileOut = selectOutFile(saveChoice);
            didSave = saveToFile(saveFileOut,demoBuilding);
        }
        System.out.println("Save success!");
        this.userIn.close();
    }

    public Building createNewBuilding() {
        double height = initializeHeight();
        double width = initializeWidth();
        double length = initializeLength();
        Building demoBuilding = new BuildingImpl(length, width, height);
        Roof roof = new RoofImpl(width, length, 2, height);
        ExternalWall newWall1 = new ExternalWall();
        ExternalWall newWall2 = new ExternalWall();
        double thickness = requestWallThickness();
        System.out.println("Select a material from the list below\n" + displayMaterialsByArea());
        int option = enterValidInt(1, 6);
        MaterialByArea selectMaterial = chooseMaterial(option);
        newWall1.setHeight(demoBuilding.getHeight());
        newWall1.setLength(demoBuilding.getLength());
        newWall1.setThickness(thickness);
        newWall1.setMaterial(selectMaterial);
        demoBuilding.addWall(newWall1);
        newWall2.setHeight(demoBuilding.getHeight());
        newWall2.setLength(demoBuilding.getWidth());
        newWall2.setThickness(thickness);
        newWall2.setMaterial(selectMaterial);
        demoBuilding.addWall(newWall2);
        newWall1 = new ExternalWall();
        newWall1.setHeight(demoBuilding.getHeight());
        newWall1.setLength(demoBuilding.getLength());
        newWall1.setThickness(thickness);
        newWall1.setMaterial(selectMaterial);
        demoBuilding.addWall(newWall1);
        newWall2 = new ExternalWall();
        newWall2.setHeight(demoBuilding.getHeight());
        newWall2.setLength(demoBuilding.getWidth());
        newWall2.setThickness(thickness);
        newWall2.setMaterial(selectMaterial);
        demoBuilding.addWall(newWall2);
        return demoBuilding;

    }

    //    will modify all 4
    public boolean modifyWalls(Building demoBuilding) {
        boolean goodEntry;
        boolean done = false;
        int option;
        int wallToChange;
        while (!done) {
            System.out.println("Choose a wall, 1-4, to modify, or enter 0 to quit");
            wallToChange = enterValidInt(0, 4);
            if (wallToChange != 0) {
                int wallIndex = wallToChange - 1;
                System.out.println("\nWall being modified: " + wallToChange + "\n" + displayWalls(demoBuilding.getWall(wallIndex)));
                System.out.println("Enter 1 to change wall material, 2 to add a feature, 3 to remove a feature," +
                        " and 0 to return to wall selection menu");
                option = enterValidInt(0, 3);

                int chooseFromDisplay;
                try {
                    switch (option) {
                        case 1:
                            System.out.println(displayMaterialsByArea());
                            chooseFromDisplay = enterValidInt(1, 6);
                            demoBuilding.getWall(wallIndex).setMaterial(chooseMaterial(chooseFromDisplay));
                            break;
                        //                use chooseMaterial method to create object of choice, then add it to the wall
                        case 2:
                            System.out.println("Enter 1 to add a door, or 2 to add a window");
                            chooseFromDisplay = enterValidInt(1, 2);
                            try {
                                switch (chooseFromDisplay) {
                                    //                      change a wall material
                                    case 1:
                                        System.out.println(displayDoors());
                                        System.out.println("\nEnter the number associated with the kind of door you would like to add");
                                        chooseFromDisplay = enterValidInt(1, 6);
                                        demoBuilding.addWallFeature(wallIndex, chooseDoors(chooseFromDisplay));
                                        break;
                                    //                      add features to a wall
                                    case 2:
                                        System.out.println(displayWindows());
                                        System.out.println("\nEnter the number associated with the kind of window you would like to add");
                                        chooseFromDisplay = enterValidInt(1, 5);
                                        demoBuilding.addWallFeature(wallIndex, chooseWindows(chooseFromDisplay));
                                        break;

                                    default:
                                        System.out.println("Invalid entry");
                                        break;
                                }
                            } catch (Exception e) {
                                String message = e.getMessage();
                                System.out.println("Error of type" + message + " occurred.");
                            }
                            break;
                        //Remove features from a wall
                        case 3:
                            if (demoBuilding.getWall(wallIndex).getFeatureListSize() > 0) {
                                System.out.println(displayWalls(demoBuilding.getWall(wallIndex)));
                                System.out.println("\nEnter the number associated with the feature you would like to remove");
                                chooseFromDisplay = enterValidInt(1, demoBuilding.getWall(wallIndex).getFeatureListSize());
                                displayWalls(demoBuilding.getWall(wallIndex));
                                demoBuilding.getWall(wallIndex).removeFeature(chooseFromDisplay - 1);//minus one bc index
                            } else if (demoBuilding.getWall(wallIndex).getFeatureListSize() == 0) {
                                System.out.println("There are no features to remove from this wall.");
                            }
                            break;
                        case 0:
                            break;

                        default:
                            System.out.println("Invalid entry. Please enter an option from the menu.");
                            break;
                    }
                } catch (Exception e) {
                    String message = e.getMessage();
                    System.out.println("Error of type " + message + " occurred.");
                }
            } else {
                done = true;
            }
        }
        return done;
    }


    public MaterialByUnit chooseWindows(int option) {
        switch (option) {
            case 1:
                return new BayWindow();
            case 2:
                return new DoubleHungWindow();
            case 3:
                return new PictureWindow();
            case 4:
                return new SingleHungWindow();
            case 5:
                return new SlidingWindow();
            default:
                System.out.println("Invalid window selection");
                return null;
        }
    }

    public MaterialByUnit chooseDoors(int option) {
        // change option menus to map <K, V>??
        switch (option) {
            case 1:
                return new Door();
            case 2:
                return new GarageDoor();
            case 3:
                return new InteriorDoor();

            case 4:
                return new ScreenDoor();

            case 5:
                return new SlidingDoor();

            case 6:
                return new StormDoor();
            default:
                System.out.println("Invalid door selection");
                return null;
        }
    }


    public MaterialByArea chooseMaterial(int option) {
        switch (option) {
            case 1:
                return new Brick();
            case 2:
                return new ClayBrick();
            case 3:
                return new ConcreteBrick();
            case 4:
                return new TwoByFour();
            case 5:
                return new TwoByThree();
            case 6:
                return new Wood();
            default:
                System.out.println("Invalid material selection");
                return null;
        }
    }

    public double initializeLength() {
        boolean goodEntry;
        System.out.println("Enter the length of the structure");
        String length = userIn.next();
        goodEntry = checkValidDouble(length);
        while (!goodEntry) {
            System.out.println("Invalid entry. Please enter the length of the structure");
            length = userIn.next();
            goodEntry = checkValidDouble(length);
        }
        return Double.parseDouble(length);
    }


    public double initializeHeight() {
        boolean goodEntry;
        System.out.println("Enter the height of the structure");
        String height = userIn.next();
        goodEntry = checkValidDouble(height);
        while (!goodEntry) {
            System.out.println("Invalid entry. Please enter the height of the structure");
            height = userIn.next();
            goodEntry = checkValidDouble(height);
        }
        return Double.parseDouble(height);
    }


    public double initializeWidth() {
        boolean goodEntry;
        System.out.println("Enter the width of the structure");
        String width = userIn.next();
        goodEntry = checkValidDouble(width);
        while (!goodEntry) {
            System.out.println("Invalid entry. Please enter the width of the structure");
            width = userIn.next();
            goodEntry = checkValidDouble(width);
        }
        return Double.parseDouble(width);
    }

    public double requestWallThickness() {
        System.out.println("Please enter desired wall thickness");
        String thicknessStr = userIn.next();
        boolean goodEntry = checkValidDouble(thicknessStr);
        double thickness = -1;
        if (goodEntry) {
            thickness = Double.parseDouble(thicknessStr);
        }
        while (thickness < 0.1 || !goodEntry) {
            System.out.println("Invalid entry. Please enter desired wall thickness");
            thicknessStr = userIn.next();
            goodEntry = checkValidDouble(thicknessStr);
            if (goodEntry) {
                thickness = Double.parseDouble(thicknessStr);
            }
        }
        return thickness;
    }


    @Override
    public boolean checkYesOrNo(String userInput) {
        //Shorten the string
        if (userInput.length() < 1) {
            return false;
        } else {
            String shortUserInput = userInput.substring(0, 1);
            //Lowercase the string
            shortUserInput = shortUserInput.toLowerCase();
            //Compare if yes or no
            if (shortUserInput.equals("y") || shortUserInput.equals("n")) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean checkValidDouble(String userInput) {
        if (userInput.length() < 1) { //quick false for empty string
            return false;
        } else if (isLetter(userInput.charAt(userInput.length() - 1))) { //fixes error with parseDouble
            return false;
        } else {
            try {   //tries to parse as a double, throws exception if not double
                Double.parseDouble(userInput);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }

    @Override
    public boolean checkValidInt(String userInput) {
        if (userInput.length() < 1) {  //quick false for empty string
            return false;
        } else {
            try {
                Integer.parseInt(userInput);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }

    @Override
    public String displayMaterialsByArea() {
        Brick brick = new Brick();
        ClayBrick clayBrick = new ClayBrick();
        ConcreteBrick concreteBrick = new ConcreteBrick();
        TwoByFour twoByFour = new TwoByFour();
        TwoByThree twoByThree = new TwoByThree();
        Wood wood = new Wood();
        String display = "Building Materials:";
        display = display + "\n1: " + brick.toString();
        display = display + "\n2: " + clayBrick.toString();
        display = display + "\n3: " + concreteBrick.toString();
        display = display + "\n4: " + twoByFour.toString();
        display = display + "\n5: " + twoByThree.toString();
        display = display + "\n6: " + wood.toString();
        return display;
    }

    @Override
    public String displayDoors() {
        Door door = new Door();
        GarageDoor garageDoor = new GarageDoor();
        InteriorDoor interiorDoor = new InteriorDoor();
        ScreenDoor screenDoor = new ScreenDoor();
        SlidingDoor slidingDoor = new SlidingDoor();
        StormDoor stormDoor = new StormDoor();
        String display = "Doors:";
        display = display + "\n1: " + door.toString();
        display = display + "\n2: " + garageDoor.toString();
        display = display + "\n3: " + interiorDoor.toString();
        display = display + "\n4: " + screenDoor.toString();
        display = display + "\n5: " + slidingDoor.toString();
        display = display + "\n6: " + stormDoor.toString();
        return display;
    }

    @Override
    public String displayWindows() {
        BayWindow bayWindow = new BayWindow();
        DoubleHungWindow doubleHungWindow = new DoubleHungWindow();
        PictureWindow pictureWindow = new PictureWindow();
        SingleHungWindow singleHungWindow = new SingleHungWindow();
        SlidingWindow slidingWindow = new SlidingWindow();
        String display = "Windows:";
        display = display + "\n1: " + bayWindow.toString();
        display = display + "\n2: " + doubleHungWindow.toString();
        display = display + "\n3: " + pictureWindow.toString();
        display = display + "\n4: " + singleHungWindow.toString();
        display = display + "\n5: " + slidingWindow.toString();
        return display;
    }

    public String buildingOutput(Building demoBuilding) {
        try {
            String buildingString;
//        print structure params, each wall by parameter, print roof
            buildingString = "Building Information:\n";
            buildingString += "Height: " + Double.toString(demoBuilding.getHeight()) + "\n";
            buildingString += "Width: " + Double.toString(demoBuilding.getWidth()) + "\n";
            buildingString += "Length: " + Double.toString(demoBuilding.getLength()) + "\n\n";
            buildingString += "Total Cost: $" + Double.toString(demoBuilding.calcTotalCost());
            return buildingString;
        } catch (Exception e) {
            System.out.println("Error of type " + e.getMessage() + " occurred.");
            return null;
        }
    }

    public String displayWalls(Wall wallIn) {
        String wallString;
        wallString = "\nWall Information: ";
        wallString += "\nHeight: " + Double.toString(wallIn.getHeight()) + "\n";
        wallString += "Length: " + Double.toString(wallIn.getLength()) + "\n";
        wallString += "Thickness: " + Double.toString(wallIn.getThickness()) + "\n";
        wallString += "Material: " + wallIn.getMaterial();
        wallString += "\n\nFeatures List:\n";
        for (int i = 0; i < wallIn.getFeatureListSize(); i++) {
            wallString += (i + 1) + ": " + wallIn.getFeature(i).toString() + "\n";
        }
        wallString += "\n";
        return wallString;

    }

    //creates a dummy building for testing purposes
    @Override
    public void dummyBuilding() {
        Building newBuilding = new BuildingImpl(60, 60, 12);
        buildingList.add(newBuilding);
    }

    @Override
    public void createBuilding() {

    }

    @Override
    public void addBuilding(Building building) {
        buildingList.add(building);
    }

    @Override
    public boolean addWall(int idx) {
        /**System.out.println("Enter a length for the new wall");
         String lengthStr = userIn.next();
         boolean lengthEntry = checkValidDouble(lengthStr);
         double length = -1;
         if(lengthEntry){
         length = Double.parseDouble(lengthStr);
         }**/
        if (idx < 0) {
            return false;
        } else if (idx > this.buildingList.size() - 1) {
            return false;
        } else {
            //Input wall start point
            double[] start = new double[3];
            System.out.println("Enter a starting point for the new wall.");
            //x position
            System.out.print("X position: ");
            String xStr = userIn.next();
            boolean xEntry = checkValidDouble(xStr);
            double x = -1;
            if (xEntry) {
                x = Double.parseDouble(xStr);
            }
            while (x < 0 || !xEntry || x > this.buildingList.get(idx).getLength()) {
                System.out.println("Invalid entry.");
                System.out.print("X position: ");
                xStr = userIn.next();
                xEntry = checkValidDouble(xStr);
                if (xEntry) {
                    x = Double.parseDouble(xStr);
                }
            }
            //y position
            System.out.print("Y position: ");
            String yStr = userIn.next();
            boolean yEntry = checkValidDouble(yStr);
            double y = -1;
            if (yEntry) {
                y = Double.parseDouble(yStr);
            }
            while (y < 0 || !yEntry || x > this.buildingList.get(idx).getWidth()) {
                System.out.println("Invalid entry.");
                System.out.print("Z position: ");
                yStr = userIn.next();
                yEntry = checkValidDouble(yStr);
                if (yEntry) {
                    y = Double.parseDouble(yStr);
                }
            }
            //z position
            System.out.print("Z position: ");
            String zStr = userIn.next();
            boolean zEntry = checkValidDouble(zStr);
            double z = -1;
            if (zEntry) {
                z = Double.parseDouble(zStr);
            }
            while (z < 0 || !zEntry || x > this.buildingList.get(idx).getHeight()) {
                System.out.println("Invalid entry.");
                System.out.print("Z position: ");
                zStr = userIn.next();
                zEntry = checkValidDouble(zStr);
                if (zEntry) {
                    z = Double.parseDouble(zStr);
                }
            }
            //Input wall length
            System.out.println("Enter a length for the new wall");
            String lengthStr = userIn.next();
            boolean lengthEntry = checkValidDouble(lengthStr);
            double length = -1;
            if (lengthEntry) {
                length = Double.parseDouble(lengthStr);
            }
            while (length < 0.1 || !lengthEntry) {
                System.out.println("Invalid entry. Please enter desired wall length");
                lengthStr = userIn.next();
                lengthEntry = checkValidDouble(lengthStr);
                if (lengthEntry) {
                    length = Double.parseDouble(lengthStr);
                }
            }
            //Input wall width
            System.out.println("Enter a width for the new wall");
            String widthStr = userIn.next();
            boolean widthEntry = checkValidDouble(widthStr);
            double width = -1;
            if (widthEntry) {
                width = Double.parseDouble(widthStr);
            }
            while (width < 0.1 || !widthEntry) {
                System.out.println("Invalid entry. Please enter desired wall width");
                widthStr = userIn.next();
                widthEntry = checkValidDouble(widthStr);
                if (widthEntry) {
                    width = Double.parseDouble(widthStr);
                }
            }
            //Input wall height
            System.out.println("Enter a height for the new wall");
            String heightStr = userIn.next();
            boolean heightEntry = checkValidDouble(heightStr);
            double height = -1;
            if (heightEntry) {
                height = Double.parseDouble(heightStr);
            }
            while (height < 0.1 || !heightEntry) {
                System.out.println("Invalid entry. Please enter desired wall height");
                heightStr = userIn.next();
                heightEntry = checkValidDouble(heightStr);
                if (heightEntry) {
                    height = Double.parseDouble(heightStr);
                }
            }
            //Input wall material
            System.out.println("Select a material to make the new wall out of");
            System.out.println(this.displayMaterialsByArea());
            String selectionStr = userIn.next();
            boolean selectionEntry = checkValidInt(selectionStr);
            int selection = 0;
            if (selectionEntry) {
                selection = Integer.parseInt(selectionStr);
            }
            while (selection < 1 || !selectionEntry || selection > 6) {
                System.out.println("Invalid entry. Please select one of the available materials.");
                System.out.println(this.displayMaterialsByArea());
                selectionStr = userIn.next();
                selectionEntry = checkValidInt(selectionStr);
                if (selectionEntry) {
                    selection = Integer.parseInt(selectionStr);
                }
            }
            MaterialByArea newMaterial;
            switch (selection) {
                case 1:
                    newMaterial = new Brick();
                    break;
                case 2:
                    newMaterial = new ClayBrick();
                    break;
                case 3:
                    newMaterial = new ConcreteBrick();
                    break;
                case 4:
                    newMaterial = new TwoByFour();
                    break;
                case 5:
                    newMaterial = new TwoByThree();
                    break;
                case 6:
                    newMaterial = new Wood();
                    break;
                default:
                    System.out.println("Invalid selection. Wall material has been set to Wood.");
                    newMaterial = new Wood();
                    break;
            }

            ExternalWall wall = new ExternalWall(height, length, width, start, newMaterial);

            if (wall.getTopCoordinates()[0] > this.buildingList.get(idx).getLength()) {
                System.out.print("Error: Wall is longer than the building");
                return false;
            } else if (wall.getTopCoordinates()[1] > this.buildingList.get(idx).getWidth()) {
                System.out.print("Error: Wall is wider than the building");
                return false;
            } else if (wall.getTopCoordinates()[2] > this.buildingList.get(idx).getHeight()) {
                System.out.print("Error: Wall is taller than the building");
                return false;
            }
            this.buildingList.get(idx).addWall(wall);
            System.out.println("Wall Added");
            return true;
        }
    }

    /**
     * Displays the available files
     *
     * @return the number of available files
     */
    public int displayAvailableFiles() {
        FileInput masterIn = new FileInputImpl("masterFile.txt");
        String[] listOfFiles = masterIn.loadFileNames();
        String displayString = "Available Files:\n";
        for (int i = 0; i < listOfFiles.length; i++) {
            displayString += (i+1) + ": " + listOfFiles[i] + "\n";
        }
        System.out.println(displayString);
        System.out.println("Select which save file you wish to use:");
        int selection = enterValidInt(1, listOfFiles.length);
        return selection-1;
    }

    /**
     * Select a file to input/output to from masterFile.txt
     *
     * @param choice integer valueo of the choice from files
     * @return FileInput object with the file string of the selection
     */
    public FileInput selectInFile(int choice) {
        FileInput masterIn = new FileInputImpl("masterFile.txt");
        String[] listOfFiles = masterIn.loadFileNames();
        FileInput fileIn;
        if (choice < listOfFiles.length) {
            fileIn = new FileInputImpl(listOfFiles[choice] + ".txt");
            return fileIn;
        } else {
            System.out.println("Invalid file input name.");
            return null;
        }
    }

    /**
     * Generates the FileOutput for a choice from the save slots
     *
     * @param choice number for save slot
     * @return FileOutput of what is to be saved
     */
    public FileOutput selectOutFile(int choice) {
        FileInput masterIn = new FileInputImpl("masterFile.txt");
        String[] listOfFiles = masterIn.loadFileNames();
        FileOutput fileOut;
        if (choice < listOfFiles.length) {
            fileOut = new FileOutputImpl(listOfFiles[choice] + ".txt");
            return fileOut;
        } else {
            System.out.println("Invalid file output name.");
            return null;
        }
    }

    /**
     * Saves the building to the file
     *
     * @param file           FileOutput save slot
     * @param buildingToSave Building which is going to be saved to a file
     * @return true is successful save, false otherwise
     */
    public boolean saveToFile(FileOutput file, Building buildingToSave) {
        String outString = file.generateOutString(buildingToSave);
        boolean didSave = file.saveToFile(outString);
        return didSave;
    }

    public Building keepLoading() {
        Building demoBuilding;
        int saveSlotNum = displayAvailableFiles();
        saveFileIn = selectInFile(saveSlotNum);
        demoBuilding = saveFileIn.loadFromFile();
        while (demoBuilding == null) {
            System.out.println("That file is empty. You may try another or build a new building.");
            System.out.println("1. Try another save slot. \n2. Build a new building.");
            int userNum = enterValidInt(1, 2);
            if(userNum == 1) {
                saveSlotNum = displayAvailableFiles();
                saveFileIn = selectInFile(saveSlotNum);
                demoBuilding = saveFileIn.loadFromFile();
                saveFileOut = selectOutFile(saveSlotNum);
            }else {
                demoBuilding = createNewBuilding();
            }
        }
        return demoBuilding;
    }
}
