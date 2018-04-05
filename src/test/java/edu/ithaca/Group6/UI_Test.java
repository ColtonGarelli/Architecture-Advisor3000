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
        assertEquals(true,testUI.getYesOrNo(testValidYes),"Did not check that string is valid yes");
        assertEquals(true,testUI.getYesOrNo(testValidNo),"Did not check that string is valid no");
        testValidYes = "YES";
        testValidNo = "NO";
        assertEquals(true,testUI.getYesOrNo(testValidYes),"Did not check that string is valid yes");
        assertEquals(true,testUI.getYesOrNo(testValidNo),"Did not check that string is valid no");
        assertEquals(false,testUI.getYesOrNo(testInvalidInput),"Did not check invalid input");

    }

}
