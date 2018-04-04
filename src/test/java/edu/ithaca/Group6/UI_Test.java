package edu.ithaca.Group6;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class UI_Test {
    private UI testUI;


    @Test
    private void testYesOrNo(){
        String testValidYes = "yes";
        String testInvalidInput = "k";
        assertEquals(true,testUI.getYesOrNo(testValidYes),"Did not check that string is valid yes");
    }

}
