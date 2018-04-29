package edu.ithaca.Group6;
//import javafx.scene.paint.Material;

import java.util.Scanner;
import java.util.ArrayList;
import static java.lang.Character.isLetter;

public class UIImpl implements UI{
    public Scanner userIn;
    public ArrayList<Building> buildingList = new ArrayList<Building>();

    public UIImpl(){
        this.userIn = new Scanner(System.in);
    }

    public static void main(String[] args) {
        UI demo = new UIImpl();
        demo.login();
        //demo.sprintThreeDemo();
    }

    public int enterValidInt(int startInt, int endInt){
        int userInt = startInt - 1;
        while(userInt < startInt || userInt > endInt) {
            String userInput = userIn.next();
            while (!checkValidInt(userInput)) {
                System.out.println("Please enter a valid option, " + startInt + " - " + endInt + "");
                userInput = userIn.next();
            }
            userInt = Integer.parseInt(userInput);
            if(userInt < startInt || userInt > endInt){
                System.out.println("Please enter a valid option, " + startInt + " - " + endInt + "");
            }
        }
        return userInt;
    }

    //    in a list of options, quit will always be 0
    public void sprintThreeDemo(){
        //Testing addWall
        //this.dummyBuilding();
        //this.addWall(0);
        System.out.println("Welcome to the Architecture Advisor3000");
        System.out.println("\nWhen you would like to begin modifying your project enter Yes.");
        String entry = userIn.next();
        boolean goodEntry = checkYesOrNo(entry);
        while(goodEntry==false){
            System.out.println("Please enter Yes when ready");
            entry = userIn.next();
            goodEntry = checkYesOrNo(entry);
        }
        Building demoBuilding = new BuildingImpl();
        double height = initializeHeight();
        demoBuilding.setHeight(height);
        double width = initializeWidth();
        demoBuilding.setWidth(width);
        double length =initializeLength();
        demoBuilding.setLength(length);
        Roof roof = new RoofImpl(width, length, 2, height);

        ExternalWall newWall1 = new ExternalWall();
        ExternalWall newWall2 = new ExternalWall();
        double thickness = requestWallThickness();


        newWall1.setHeight(demoBuilding.getHeight());
        newWall1.setLength(demoBuilding.getLength());
        newWall1.setThickness(thickness);
        demoBuilding.addWall(newWall1);
        newWall2.setHeight(demoBuilding.getHeight());
        newWall2.setLength(demoBuilding.getWidth());
        newWall2.setThickness(thickness);
        demoBuilding.addWall(newWall2);
        newWall1.setHeight(demoBuilding.getHeight());
        newWall1.setLength(demoBuilding.getLength());
        newWall1.setThickness(thickness);
        demoBuilding.addWall(newWall2);
        newWall2.setHeight(demoBuilding.getHeight());
        newWall2.setLength(demoBuilding.getWidth());
        newWall2.setThickness(thickness);
        demoBuilding.addWall(newWall2);
        this.addBuilding(demoBuilding);

        boolean modificationsDone = false;
        while(!modificationsDone){
            modificationsDone = modifyWalls(demoBuilding);
        }
        System.out.println(buildingOutput(demoBuilding));
        for(int i=0; i<4; i++) {
            System.out.println(displayWalls(demoBuilding.getWall(i)));
        }
        this.userIn.close();
    }

    //    will modify all 4
    public boolean modifyWalls(Building demoBuilding) {
        boolean goodEntry;
        boolean done = false;
        int option;
        int wallToChange;
        while (!done) {
            System.out.println("Choose a wall, 1-4, to modify");
            wallToChange = enterValidInt(1,4);
            int wallIndex = wallToChange-1;
            System.out.println("Wall being modified:\n" + displayWalls(demoBuilding.getWall(wallIndex)));
            System.out.println("Enter 1 to change wall material, 2 to add a feature, 3 to remove a feature," +
                    " and 0 to finish modifying");
            option = enterValidInt(0,3);

            int chooseFromDisplay;
            if (option == 1) {
                System.out.println(displayMaterialsByArea());
                chooseFromDisplay = enterValidInt(1,6);
                demoBuilding.getWall(wallIndex).setMaterial(chooseMaterial(chooseFromDisplay));

//                use chooseMaterial method to create object of choice, then add it to the wall
            } else if (option == 2) {
                System.out.println("Enter 1 to add a door, or 2 to add a window");
                chooseFromDisplay = enterValidInt(1,2);

//                change a wall material
                if (chooseFromDisplay == 1) {
                    System.out.println(displayDoors());
                    System.out.println("\n Enter the number associated with the kind of door you would like to add");
                    chooseFromDisplay = enterValidInt(1,6);
                    demoBuilding.addWallFeature(wallIndex, chooseDoors(chooseFromDisplay));
                }
//                add features to a wall
                else if (chooseFromDisplay == 2) {
                    System.out.println(displayWindows());
                    System.out.println("\n Enter the number associated with the kind of window you would like to add");
                    chooseFromDisplay = enterValidInt(1,5);
                    demoBuilding.addWallFeature(wallIndex, chooseWindows(chooseFromDisplay));
                }
            }
//            Remove features from a wall
            else if (option == 3) {
                System.out.println("\n Enter the number associated with the feature you would like to remove");
                chooseFromDisplay = enterValidInt(1,demoBuilding.getWall(wallIndex).getFeatureListSize());
                displayWalls(demoBuilding.getWall(wallIndex));
                demoBuilding.getWall(wallIndex).removeFeature(chooseFromDisplay-1);//minus one bc index
            }
            else{
                    done = true;
                }

            }

        return done;
    }

    public MaterialByUnit chooseWindows(int option) {
        if(option==1){
            return new BayWindow();
        }
        else if(option==2){
            return new DoubleHungWindow();
        }
        else if(option==3){
            return new PictureWindow();
        }
        else if(option==4){
            return new SingleHungWindow();
        }
        else{
            return new SlidingWindow();
        }
    }

    public MaterialByUnit chooseDoors(int option) {
        if(option==1){
            return new Door();
        }
        else if(option==2){
            return new GarageDoor();
        }
        else if(option==3){
            return new InteriorDoor();
        }
        else if(option==4){
            return new ScreenDoor();
        }
        else if(option==5){
            return new SlidingDoor();

        }
        else{
            return new StormDoor();
        }
    }


    public MaterialByArea chooseMaterial(int option) {
        if(option==1){
            return new Brick();
        }
        else if(option==2){
            return new ClayBrick();
        }
        else if(option==3){
            return new ConcreteBrick();
        }
        else if(option==4){
            return new TwoByFour();
        }
        else if(option==5){
            return new TwoByThree();

        }
        else{
            return new Wood();
        }
    }

    public double initializeLength(){
        boolean goodEntry;
        System.out.println("Enter the length of the structure");
        String length = userIn.next();
        goodEntry = checkValidDouble(length);
        while(!goodEntry){
            System.out.println("Invalid entry. Please enter the length of the structure");
            length = userIn.next();
            goodEntry = checkValidDouble(length);
        }
        return Double.parseDouble(length);
    }


    public double initializeHeight(){
        boolean goodEntry;
        System.out.println("Enter the height of the structure");
        String height = userIn.next();
        goodEntry = checkValidDouble(height);
        while(!goodEntry){
            System.out.println("Invalid entry. Please enter the height of the structure");
            height = userIn.next();
            goodEntry = checkValidDouble(height);
        }
        return Double.parseDouble(height);
    }


    public double initializeWidth(){
        boolean goodEntry;
        System.out.println("Enter the width of the structure");
        String width = userIn.next();
        goodEntry = checkValidDouble(width);
        while(!goodEntry){
            System.out.println("Invalid entry. Please enter the width of the structure");
            width = userIn.next();
            goodEntry = checkValidDouble(width);
        }
        return Double.parseDouble(width);
    }

    public double requestWallThickness(){
        System.out.println("Please enter desired wall thickness");
        String thicknessStr = userIn.next();
        boolean goodEntry = checkValidDouble(thicknessStr);
        double thickness = -1;
        if(goodEntry){
            thickness = Double.parseDouble(thicknessStr);
        }
        while(thickness  < 0.1 || !goodEntry){
            System.out.println("Invalid entry. Please enter desired wall thickness");
            thicknessStr = userIn.next();
            goodEntry = checkValidDouble(thicknessStr);
            if(goodEntry){
                thickness = Double.parseDouble(thicknessStr);
            }
        }
        return thickness;
    }





    @Override
    public boolean checkYesOrNo(String userInput) {
        //Shorten the string
        if(userInput.length() < 1){
            return false;
        }
        else{
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
        if(userInput.length() < 1){ //quick false for empty string
            return false;
        }
        else if(isLetter(userInput.charAt(userInput.length()-1))){ //fixes error with parseDouble
            return false;
        }
        else{
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
       if(userInput.length() < 1){  //quick false for empty string
           return false;
       }
       else{
           try
           {
               Integer.parseInt(userInput);
               return true;
           } catch (NumberFormatException e)
           {
               return false;
           }
       }
    }

    @Override
    public String displayMaterialsByArea(){
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
    public String displayDoors(){
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
    public String displayWindows(){
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

    public String buildingOutput(Building demoBuilding){
        String buildingString;
//        print structure params, each wall by parameter, print roof
        buildingString = "Building Information:\n";
        buildingString += "Height: " + Double.toString(demoBuilding.getHeight())+ "\n";
        buildingString += "Width: " + Double.toString(demoBuilding.getWidth()) + "\n";
        buildingString += "Length: " + Double.toString(demoBuilding.getLength()) + "\n\n";
        buildingString += "Total Cost: $" + Double.toString(demoBuilding.calcTotalCost());
        return buildingString;
    }
    public String displayWalls(Wall wallIn){
        String wallString;
        wallString = "Wall Information:\n\n";
        wallString += "\n\nHeight: " + Double.toString(wallIn.getHeight()) + "\n";
        wallString += "Length: " + Double.toString(wallIn.getLength()) + "\n";
        wallString += "Thickness: " + Double.toString(wallIn.getThickness()) + "\n";
        wallString += "\nMaterial: " + wallIn.getMaterial();
        wallString += "\nFeatures List:\n\n";
        for(int i =0; i<wallIn.getFeatureListSize(); i++){
            wallString += wallIn.getFeature(i).toString() + "\n";
        }
        wallString+="\n\n";
        return wallString;

    }

    //creates a dummy building for testing purposes
    @Override
    public void dummyBuilding(){
        Building newBuilding = new BuildingImpl(60, 60, 12);
        double[] startPoint1 = new double[]{0.0, 0.0, 0.0};
        double[] startPoint2 = new double[]{0.0, 0.0, 0.0};
        double[] startPoint3 = new double[]{0.0, 55.0, 0.0};
        double[] startPoint4 = new double[]{55.0, 0.0, 0.0};
        MaterialByArea wood = new Wood();
        ExternalWall wall1 = new ExternalWall(12, 60, 5, startPoint1, wood);
        newBuilding.addWall(wall1);
        ExternalWall wall2 = new ExternalWall(12, 5, 60, startPoint2, wood);
        newBuilding.addWall(wall2);
        ExternalWall wall3 = new ExternalWall(12, 60, 5, startPoint3, wood);
        newBuilding.addWall(wall3);
        ExternalWall wall4 = new ExternalWall(12, 5, 60, startPoint4, wood);
        newBuilding.addWall(wall4);
        buildingList.add(newBuilding);
    }

    @Override
    public void createBuilding(){

    }

    @Override
    public void addBuilding(Building building){
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
            if(selection == 1){
                newMaterial = new Brick();
            }
            else if(selection == 2){
                newMaterial = new ClayBrick();
            }
            else if(selection == 3){
                newMaterial = new ConcreteBrick();
            }
            else if(selection == 4){
                newMaterial = new TwoByFour();
            }
            else if(selection == 5){
                newMaterial = new TwoByThree();
            }
            else{
                newMaterial = new Wood();
            }
            ExternalWall wall = new ExternalWall(height, length, width, start, newMaterial);
            if(wall.getTopCoordinates()[0] > this.buildingList.get(idx).getLength()){
                System.out.print("Error: Wall is longer than the building");
                return false;
            }
            else if(wall.getTopCoordinates()[1] > this.buildingList.get(idx).getWidth()){
                System.out.print("Error: Wall is wider than the building");
                return false;
            }
            else if(wall.getTopCoordinates()[2] > this.buildingList.get(idx).getHeight()){
                System.out.print("Error: Wall is taller than the building");
                return false;
            }
            this.buildingList.get(idx).addWall(wall);
            System.out.println("Wall Added");
            return true;
        }
    }

    @Override
    public void addWallFeature(Building building){
        System.out.println("Choose a wall to modify");
        System.out.println(building.walls.size());
        int count = 0;
        for(int x = 0; x < building.walls.size(); x++) {
            count++;
        }
        System.out.println("Number of Existing walls: " + count);
        int wallToChange = enterValidInt(1, count);
        int wallIndex = wallToChange-1;
        System.out.println("Wall being modified:\n" + displayWalls(building.getWall(wallIndex)));
        int option = enterValidInt(0,3);

        int chooseFromDisplay;
        /**if (option == 1) {
            System.out.println(displayMaterialsByArea());
            chooseFromDisplay = enterValidInt(1,6);
            this.buildingList.get(idx).getWall(wallIndex).setMaterial(chooseMaterial(chooseFromDisplay));

//                use chooseMaterial method to create object of choice, then add it to the wall
        } else if (option == 2) {*/
        System.out.println("Enter 1 to add a door, or 2 to add a window");
        chooseFromDisplay = enterValidInt(1,2);

//      change a wall material
        if (chooseFromDisplay == 1) {
            System.out.println(displayDoors());
            System.out.println("\n Enter the number associated with the kind of door you would like to add");
            chooseFromDisplay = enterValidInt(1,6);
            building.addWallFeature(wallIndex, chooseDoors(chooseFromDisplay));
        }
//                add features to a wall
        else if (chooseFromDisplay == 2) {
            System.out.println(displayWindows());
            System.out.println("\n Enter the number associated with the kind of window you would like to add");
            chooseFromDisplay = enterValidInt(1,5);
            building.addWallFeature(wallIndex, chooseWindows(chooseFromDisplay));
        }
        /*}
//            Remove features from a wall
        else if (option == 3) {
            System.out.println("\n Enter the number associated with the feature you would like to remove");
            chooseFromDisplay = enterValidInt(1,this.buildingList.get(idx).getWall(wallIndex).getFeatureListSize());
            displayWalls(this.buildingList.get(idx).getWall(wallIndex));
            this.buildingList.get(idx).getWall(wallIndex).removeFeature(chooseFromDisplay-1);//minus one bc index
        }
        else{
        }**/

    }

    public void login(){
        this.dummyBuilding();
        //System.out.println(displayWalls(this.buildingList.get(0).getWall(0)));
        System.out.println("Welcome to the Architecture Advisor3000");
        System.out.println("Please Log In.");
        System.out.println("1.) Architect login");
        System.out.println("2.) Builder Login");
        String entry = userIn.next();
        boolean goodEntry = checkValidInt(entry);
        while(goodEntry==false){
            System.out.println("Invalid Entry.");
            System.out.println("Please Log In.");
            System.out.println("1.) Architect login");
            System.out.println("2.) Builder Login");
            entry = userIn.next();
            goodEntry = checkValidInt(entry);
        }
        int entryInt = Integer.parseInt(entry);
        switch (entryInt) {
            case 1: architectMain();
                    break;
            case 2: builderMain();
                    break;
            default: break;
        }
    }

    public void architectMain(){
        System.out.println("Hello Architect.");
        System.out.println("What would you like to do?");
        System.out.println("1.) Display Existing Buildings");
        System.out.println("2.) Create Building");
        System.out.println("3.) Modify an existing building");
        String entry = userIn.next();
        boolean goodEntry = checkValidInt(entry);
        while(goodEntry==false){
            System.out.println("Invalid Entry.");
            System.out.println("What would you like to do?");
            System.out.println("1.) Display Existing Buildings");
            System.out.println("2.) Create Building");
            System.out.println("3.) Modify an existing building");
            entry = userIn.next();
            goodEntry = checkValidInt(entry);
        }
        int entryInt = Integer.parseInt(entry);
        switch (entryInt) {
            case 1: break;
            case 2: this.createBuilding();
                    break;
            case 3: //select a building from the arrayList
                    architectModify(0);
                    break;
            default: break;
        }
    }

    public void architectModify(int idx){
        //System.out.println("Existing buildings:");
        //Display list of buildings
        System.out.println("1.) Add a New Wall to an Existing Building");
        System.out.println("2.) Add a Feature to a Wall");
        System.out.println("3.) Remove a Feature from a Wall");
        String entry = userIn.next();
        boolean goodEntry = checkValidInt(entry);
        while(goodEntry==false){
            System.out.println("Invalid Entry.");
            System.out.println("What would you like to do?");
            System.out.println("1.) Add a New Wall to an Existing Building");
            System.out.println("2.) Add a Feature to a Wall");
            System.out.println("3.) Remove a Feature from a Wall");
            entry = userIn.next();
            goodEntry = checkValidInt(entry);
        }
        int entryInt = Integer.parseInt(entry);
        switch (entryInt) {
            case 1: this.addWall(idx);
                    break;
            case 2: this.addWallFeature(this.buildingList.get(idx));
                    break;
            case 3:
                    break;
            default: break;
        }
    }

    public void builderMain(){
        System.out.println("Builder Main");
    }
}
