package edu.ithaca.Group6;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class UI_Test {
    private UI testUI;


    @Test
    public void testYesOrNo(){
        testUI = new UIImpl();

        //lowercase and random chars
        String testValidYes = "yes";
        String testValidNo = "no";
        String testInvalidInput = "a7j.3";
        assertEquals(true,testUI.checkYesOrNo(testValidYes),"Did not check that string is valid yes");
        assertEquals(true,testUI.checkYesOrNo(testValidNo),"Did not check that string is valid no");

        //uppercase
        testValidYes = "YES";
        testValidNo = "NO";
        assertEquals(true,testUI.checkYesOrNo(testValidYes),"Did not check that string is valid yes");
        assertEquals(true,testUI.checkYesOrNo(testValidNo),"Did not check that string is valid no");
        assertEquals(false,testUI.checkYesOrNo(testInvalidInput),"Did not check invalid input");

        //uppercase single chars
        testValidYes = "Y";
        testValidNo = "N";
        testInvalidInput = "X";
        assertEquals(true,testUI.checkYesOrNo(testValidYes),"Did not correctly evaluate 'y'");
        assertEquals(true,testUI.checkYesOrNo(testValidNo),"Did not correctly evaluate 'n'");
        assertEquals(false,testUI.checkYesOrNo(testInvalidInput),"Did not correctly evaluate invalid single character");

        //empty string
        String emptyString = "";
        assertEquals(false, testUI.checkYesOrNo(emptyString), "Did not handle empty string");


    }

}
