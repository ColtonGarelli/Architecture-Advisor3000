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
        demoBuilding.setHeight(initializeHeight());
        demoBuilding.setWidth(initializeWidth());
        boolean modificationsDone = false;
        while(!modificationsDone){
            modificationsDone = modifyWalls();
        }
        this.userIn.close();
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

//    will modify all 4
    public boolean modifyWalls(){
        boolean goodEntry;
        boolean done =false;
        System.out.println("Enter 1 to set wall thickness, 2 to set wall material, 3 to add a feature");
        int option;
        while(!done){
            System.out.println("Enter 1 to set wall thickness, 2 to set wall material, 3 to add a feature," +
                    " and 0 to finish modifying");
            option = userIn.nextInt();
            while(option<0 || option >3){
                System.out.println("Enter 1 to set wall thickness, 2 to set wall material, 3 to add a feature," +
                        " and 0 to finish modifying");
                option = userIn.nextInt();
            }
        }
        return true;
    }

    public double requestWallThickness(){
        System.out.println("Please enter desired wall thickness");
        double thickness = userIn.nextInt();
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
        display = display + "\n" + brick.toString();
        display = display + "\n" + clayBrick.toString();
        display = display + "\n" + concreteBrick.toString();
        display = display + "\n" + twoByFour.toString();
        display = display + "\n" + twoByThree.toString();
        display = display + "\n" + wood.toString();
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
        display = display + "\n" + door.toString();
        display = display + "\n" + garageDoor.toString();
        display = display + "\n" + interiorDoor.toString();
        display = display + "\n" + screenDoor.toString();
        display = display + "\n" + slidingDoor.toString();
        display = display + "\n" + stormDoor.toString();
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
        display = display + "\n" + bayWindow.toString();
        display = display + "\n" + doubleHungWindow.toString();
        display = display + "\n" + pictureWindow.toString();
        display = display + "\n" + singleHungWindow.toString();
        display = display + "\n" + slidingWindow.toString();
        return display;
    }
}
