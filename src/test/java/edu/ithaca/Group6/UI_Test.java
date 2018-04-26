package edu.ithaca.Group6;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UI_Test {
    private UI testUI;


    @Test
    public void testYesOrNo(){
        testUI = new UIImpl();

        //lowercase and random chars
        String testValidYes = "yes";
        String testValidNo = "no";
        String testInvalidInput = "a7j.3";
        assertTrue(testUI.checkYesOrNo(testValidYes),"Did not check that string is valid yes");
        assertTrue(testUI.checkYesOrNo(testValidNo),"Did not check that string is valid no");

        //uppercase
        testValidYes = "YES";
        testValidNo = "NO";
        assertTrue(testUI.checkYesOrNo(testValidYes),"Did not check that string is valid yes");
        assertTrue(testUI.checkYesOrNo(testValidNo),"Did not check that string is valid no");
        assertFalse(testUI.checkYesOrNo(testInvalidInput),"Did not check invalid input");

        //uppercase single chars
        testValidYes = "Y";
        testValidNo = "N";
        testInvalidInput = "X";
        assertTrue(testUI.checkYesOrNo(testValidYes),"Did not correctly evaluate 'y'");
        assertTrue(testUI.checkYesOrNo(testValidNo),"Did not correctly evaluate 'n'");
        assertFalse(testUI.checkYesOrNo(testInvalidInput),"Did not correctly evaluate invalid single character");

        //empty string
        String emptyString = "";
        assertFalse(testUI.checkYesOrNo(emptyString), "Did not handle empty string");
    }

    @Test
    public void testValidDouble(){
        testUI = new UIImpl();
        //Valids
        String testValidPosDouble = "114.34";
        String testValidNegDouble = "-23.345";
        String testValidSmallDouble = "0.324";
        String testValidSmallNegDouble = "-0.324";
        String testValidPoorFormatDouble = ".345";
        String testValidPoorFormatNegDouble = "-.345";
        String testValidPoorFormatDoubleEnd = "234.";
        String testValidPoorFormatNegDoubleEnd = "-323.";
        String testValidZeroInt = "0";
        String testValidPosInt = "23";
        String testValidNegInt = "-34";

        //Normal doubles
        assertTrue(testUI.checkValidDouble(testValidPosDouble), "Did not handle positive double");
        assertTrue(testUI.checkValidDouble(testValidNegDouble),"Did not handle negative double");
        assertTrue(testUI.checkValidDouble(testValidSmallDouble),"Did not handle small positive double");
        assertTrue(testUI.checkValidDouble(testValidSmallNegDouble),"Did not handle small negative double");

        //Poorly formatted doubles
        assertTrue(testUI.checkValidDouble(testValidPoorFormatDouble),"Did not handle poor format positive double");
        assertTrue(testUI.checkValidDouble(testValidPoorFormatNegDouble),"Did not handle poor format negative double");
        assertTrue(testUI.checkValidDouble(testValidPoorFormatDoubleEnd),"Did not handle poor format positive double at end");
        assertTrue(testUI.checkValidDouble(testValidPoorFormatNegDoubleEnd),"Did not handle poor format negative double at end");

        //Integers
        assertTrue(testUI.checkValidDouble(testValidZeroInt),"Did not handle zero");
        assertTrue(testUI.checkValidDouble(testValidPosInt),"Did not handle positive integer");
        assertTrue(testUI.checkValidDouble(testValidNegInt),"Did not handle negative integer");

        //Invalids
        String emptyStr = "";
        String testInvalidStr = "a45d.45";
        String testInvalidStr2 = "43.d43f";
        String testInvalidStr3 = "49d";
        String testInvalidStr4 = "49.d";

        //Invalids
        assertFalse(testUI.checkValidDouble(emptyStr), "Did not handle empty string");
        assertFalse(testUI.checkValidDouble(testInvalidStr),"Did not handle string with char at front");
        assertFalse(testUI.checkValidDouble(testInvalidStr2),"Did not handle string with char at end");
        assertFalse(testUI.checkValidDouble(testInvalidStr3),"Did not handle string with char only at end");
        assertFalse(testUI.checkValidDouble(testInvalidStr4),"Did not handle string with char only at end after decimal");
    }

    @Test
    public void testValidInt(){
        testUI = new UIImpl();
        //Valids
        String testValidZeroInt = "0";
        String testValidPosInt = "23";
        String testValidNegInt = "-34";

        //Normal Ints
        assertTrue(testUI.checkValidInt(testValidZeroInt),"Did not handle zero");
        assertTrue(testUI.checkValidInt(testValidPosInt),"Did not handle positive valid integer");
        assertTrue(testUI.checkValidInt(testValidNegInt),"Did not handle negative valid integer");

        //Invalids
        String testInvalidPosDouble = "0.4";
        String testInvalidNegDouble = "-1.9999";
        String testInvalidPosInt = "49f";
        String testInvalidPosInt2 = "f30";
        String testInvalidNegInt = "-23d";
        String testInvalidNegInt2 = "-p32";
        String emptyStr = "";

        //Doubles
        assertFalse(testUI.checkValidInt(testInvalidPosDouble),"Did not handle positive double");
        assertFalse(testUI.checkValidInt(testInvalidNegDouble),"Did not handle negative double");

        //Integers with letters
        assertFalse(testUI.checkValidInt(testInvalidPosInt),"Did not handle invalid positive integer");
        assertFalse(testUI.checkValidInt(testInvalidPosInt2),"Did not handle invalid positive integer");
        assertFalse(testUI.checkValidInt(testInvalidNegInt),"Did not handle invalid negative integer");
        assertFalse(testUI.checkValidInt(testInvalidNegInt2),"Did not handle invalid negative integer");

        assertFalse(testUI.checkValidInt(emptyStr),"Did not handle empty string");
    }

    @Test
    public void displayAvailableAreaTest(){
        testUI = new UIImpl();
        String display = "Building Materials:\n" +
                "1: Brick : $142.34 per square foot\n" +
                "2: Clay Brick : $0.04 per square foot\n" +
                "3: Concrete Brick : $0.03 per square foot\n" +
                "4: Two by Four Wood : $1.66 per square foot\n" +
                "5: Two by Three Wood : $1.23 per square foot\n" +
                "6: Wood : $1.00 per square foot";
        assertTrue(testUI.displayMaterialsByArea().equals(display), "Did not generate the list of available materialByArea objects");
    }

    @Test
    public void displayAvailableDoorTest() {
        testUI = new UIImpl();
        String display = "Doors:\n" +
                "1: Door : $900.00, Length: 3.00ft, Width: 0.15ft, Height: 6.67ft\n" +
                "2: Garage Door : $264.00, Length: 9.00ft, Width: 0.17ft, Height: 7.00ft\n" +
                "3: Interior Door : $377.76, Length: 3.00ft, Width: 0.15ft, Height: 6.67ft\n" +
                "4: Screen Door : $179.00, Length: 3.00ft, Width: 0.17ft, Height: 6.67ft\n" +
                "5: Sliding Door : $84.98, Length: 4.00ft, Width: 0.02ft, Height: 6.67ft\n" +
                "6: Storm Door : $199.00, Length: 3.00ft, Width: 0.08ft, Height: 6.67ft";
        assertTrue(testUI.displayDoors().equals(display), "Did not generate list of doors");
    }

    @Test
    public void displayAvailableWindowsTest() {
        testUI = new UIImpl();
        String display = "Windows:\n" +
                "1: Bay Window : $1198.66, Length: 6.13ft, Width: 1.00ft, Height: 5.08ft\n" +
                "2: Double Hung Window : $167.00, Length: 2.48ft, Width: 0.38ft, Height: 4.44ft\n" +
                "3: Picture Window : $252.00, Length: 4.00ft, Width: 0.27ft, Height: 4.00ft\n" +
                "4: Single Hung Window : $68.75, Length: 2.00ft, Width: 0.19ft, Height: 4.00ft\n" +
                "5: Sliding Window : $104.00, Length: 2.58ft, Width: 0.38ft, Height: 1.58ft";
        assertTrue(testUI.displayWindows().equals(display), "Did not generate list of windows");
    }

    @Test
    public void addWallTest(){
        testUI = new UIImpl();
        testUI.dummyBuilding();
        assertFalse(testUI.addWall(-1), "addWall Index Out of Bounds - Negative Number");
    }
}
