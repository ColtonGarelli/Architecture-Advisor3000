package edu.ithaca.Group6;
import java.util.Scanner;
import static java.lang.Character.isLetter;

public class UIImpl implements UI{
    public Scanner userIn;

    public UIImpl(){
        this.userIn = new Scanner(System.in);
    }

    public static void main(String[] args) {
        UI demo = new UIImpl();
        demo.sprintTwoDemo();
    }

    //    in a list of options, quit will always be 0
    public void sprintTwoDemo(){
        System.out.println("Welcome to the Architecture Advisor3000");
        System.out.println("\nWhen you would like to begin modifying your project," +
                " enter Yes. To quit enter No.");
        String entry = userIn.next();
        boolean goodEntry = checkYesOrNo(entry);
        while(goodEntry==false){
            System.out.println("Please enter Yes or No.");
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

        ExternalWall newWall = new ExternalWall();
        double thickness = requestWallThickness();


        newWall.setHeight(demoBuilding.getHeight());
        newWall.setLength(demoBuilding.getLength());
        newWall.setThickness(thickness);
        demoBuilding.addWall(newWall);
        newWall.setHeight(demoBuilding.getHeight());
        newWall.setLength(demoBuilding.getWidth());
        newWall.setThickness(thickness);
        demoBuilding.addWall(newWall);
        newWall.setHeight(demoBuilding.getHeight());
        newWall.setLength(demoBuilding.getLength());
        newWall.setThickness(thickness);
        demoBuilding.addWall(newWall);
        newWall.setHeight(demoBuilding.getHeight());
        newWall.setLength(demoBuilding.getWidth());
        newWall.setThickness(thickness);
        demoBuilding.addWall(newWall);



        boolean modificationsDone = false;
        while(!modificationsDone){
            modificationsDone = modifyWalls(demoBuilding);
        }

        this.userIn.close();
    }

    public boolean outputStructureInfo() {
        return true;
    }

    //    will modify all 4
    public boolean modifyWalls(Building demoBuilding) {
        boolean goodEntry;
        boolean done = false;
        int option;
        while (!done) {
            System.out.println("Choose a wall, 1-4, to modify");
            int wallToChange = userIn.nextInt();
            while (wallToChange < 1 || wallToChange > 4) {
                System.out.println("Choose a wall, 1-4, to modify");
                wallToChange = userIn.nextInt();
            }
            int wallIndex = wallToChange;
            System.out.println("Wall being modified:\n" + displayWalls(demoBuilding.getWall(wallIndex)));
            System.out.println("Enter 1 to change wall material, 2 to add a feature, 3 to remove a feature," +
                    " and 0 to finish modifying");
            option = userIn.nextInt();
            while (option < 0 || option > 3) {
                System.out.println("Enter 1 to change wall material, 2 to add a feature, 3 to remove a feature," +
                        " and 0 to finish modifying");
                option = userIn.nextInt();
            }

            int chooseFromDisplay;
            if (option == 1) {
                System.out.println(displayMaterialsByArea());
                chooseFromDisplay = userIn.nextInt();
                while (chooseFromDisplay < 1 || chooseFromDisplay > 6) {
                    System.out.println("Please enter a valid choice.");
                    chooseFromDisplay = userIn.nextInt();
                }
                demoBuilding.getWall(wallToChange).setMaterial(chooseMaterial(chooseFromDisplay));

//                use chooseMaterial method to create object of choice, then add it to the wall
            } else if (option == 2) {
                System.out.println("Enter 1 to add a door, or 2 to add a window");
                chooseFromDisplay = userIn.nextInt();
                while (chooseFromDisplay != 1 && chooseFromDisplay != 2) {
                    System.out.println("Enter 1 to add a door, or 2 to add a window");
                    chooseFromDisplay = userIn.nextInt();
                }
//                change a wall material
                if (chooseFromDisplay == 1) {
                    System.out.println(displayDoors());
                    System.out.println("\n Enter the number associated with the kind of door you would like to add");
                    chooseFromDisplay = userIn.nextInt();
                    while (chooseFromDisplay < 1 || chooseFromDisplay > 6) {
                        System.out.println("Please enter a valid choice.");
                        chooseFromDisplay = userIn.nextInt();
                    }
                    demoBuilding.addWallFeature(wallIndex, chooseDoors(chooseFromDisplay));
                }
//                add features to a wall
                else if (chooseFromDisplay == 2) {
                    System.out.println(displayWindows());
                    System.out.println("\n Enter the number associated with the kind of window you would like to add");
                    chooseFromDisplay = userIn.nextInt();
                    while (chooseFromDisplay < 1 || chooseFromDisplay > 6) {
                        System.out.println("Please enter a valid choice.");
                        chooseFromDisplay = userIn.nextInt();
                    }
                    demoBuilding.addWallFeature(wallIndex, chooseWindows(chooseFromDisplay));
                }
            }
//            Remove features from a wall
            else if (option == 3) {
                System.out.println("\n Enter the number associated with the feature you would like to remove");
                chooseFromDisplay = userIn.nextInt();
                while (chooseFromDisplay<1 || chooseFromDisplay > demoBuilding.getWall(wallToChange).getFeatureListSize()){
                    System.out.println("Please enter a valid choice.");
                    chooseFromDisplay = userIn.nextInt();
                }
                demoBuilding.getWall(wallToChange).removeFeature(chooseFromDisplay);
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
            length = userIn.next();
            goodEntry = checkValidDouble(length);
            System.out.println("Invalid entry. Please enter the length of the structure");
        }
        return Double.parseDouble(length);
    }


    public double initializeHeight(){
        boolean goodEntry;
        System.out.println("Enter the height of the structure");
        String height = userIn.next();
        goodEntry = checkValidDouble(height);
        while(!goodEntry){
            height = userIn.next();
            goodEntry = checkValidDouble(height);
            System.out.println("Invalid entry. Please enter the height of the structure");
        }
        return Double.parseDouble(height);
    }


    public double initializeWidth(){
        boolean goodEntry;
        System.out.println("Enter the width of the structure");
        String width = userIn.next();
        goodEntry = checkValidDouble(width);
        while(!goodEntry){
            width = userIn.next();
            goodEntry = checkValidDouble(width);
            System.out.println("Invalid entry. Please enter the width of the structure");
        }
        return Double.parseDouble(width);
    }

    public double requestWallThickness(){
        System.out.println("Please enter desired wall thickness");
        double thickness = userIn.nextDouble();
        while(thickness<1){
            System.out.println("Invalid entry. Please enter desired wall thickness");
            thickness = userIn.nextDouble();
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
        buildingString = "Building Information:\n\n\n";
        buildingString += "Height: " + Double.toString(demoBuilding.getHeight())+ "\n";
        buildingString += "Width: " + Double.toString(demoBuilding.getWidth()) + "\n";
        buildingString += "Length: " + Double.toString(demoBuilding.getLength()) + "\n\n";
        buildingString += "Total Cost: $" + Double.toString(demoBuilding.calcTotalCost());
        return buildingString;
    }
    public String displayWalls(Wall wallIn){
        String wallString;
        wallString = "Height: " + Double.toString(wallIn.getHeight()) + "\n";
        wallString += "Width: " + Double.toString(wallIn.getHeight()) + "\n";
        wallString += "Thickness: " + Double.toString(wallIn.getHeight()) + "\n";
        wallString += "\nMaterial: " + wallIn.getMaterial();
        wallString += "\nFeatures List:\n\n";
        for(int i =0; i<wallIn.getFeatureListSize(); i++){
            wallString += wallIn.getFeature(i).toString() + "\n";
        }
        wallString+="\n\n";
        return wallString;

    }
}
