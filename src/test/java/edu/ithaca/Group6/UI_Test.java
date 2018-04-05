package edu.ithaca.Group6;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class UI_Test {
    private UI testUI;


    @Test
    public void testYesOrNo(){
        testUI = new UIImpl();
        String testValidYes = "yes";
        String testValidNo = "no";
        String testInvalidInput = "a7j.3";
        assertEquals(true,testUI.checkYesOrNo(testValidYes),"Did not check that string is valid yes");
        assertEquals(true,testUI.checkYesOrNo(testValidNo),"Did not check that string is valid no");
        testValidYes = "YES";
        testValidNo = "NO";
        assertEquals(true,testUI.checkYesOrNo(testValidYes),"Did not check that string is valid yes");
        assertEquals(true,testUI.checkYesOrNo(testValidNo),"Did not check that string is valid no");
        assertEquals(false,testUI.checkYesOrNo(testInvalidInput),"Did not check invalid input");

    }

}
