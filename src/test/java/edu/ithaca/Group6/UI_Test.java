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

        String testValidPosDouble = "114.34";
        String testValidNegDouble = "-23.345";
        String testValidSmallDouble = "0.324";
        String testValidSmallNegDouble = "-0.324";
        String testValidPoorFormatDouble = ".345";
        String testValidPoorFormatNegDouble = "-.345";
        String testValidPoorFormatDoubleEnd = "234.";
        String testValidPoorFormatNegDoubleEnd = "-323.";

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

        String emptyStr = "";
        String testInvalidStr = "a45d.45";
        String testInvalidStr2 = "43.d43f";
        String testInvalidStr3 = "49d";
        String testInvalidStr4 = "49.d";

        assertFalse(testUI.checkValidDouble(emptyStr), "Did not handle empty string");
        assertFalse(testUI.checkValidDouble(testInvalidStr),"Did not handle string with char at front");
        assertFalse(testUI.checkValidDouble(testInvalidStr2),"Did not handle string with char at end");
        assertFalse(testUI.checkValidDouble(testInvalidStr3),"Did not handle string with char only at end");
        assertFalse(testUI.checkValidDouble(testInvalidStr4),"Did not handle string with char only at end after decimal");


    }

}
