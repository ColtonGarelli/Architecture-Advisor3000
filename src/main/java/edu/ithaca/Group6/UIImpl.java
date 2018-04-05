package edu.ithaca.Group6;

public class UIImpl implements UI{
    @Override
    public void main() {

    }

    @Override
    public boolean getYesOrNo(String userInput) {
        //Shorten the string
        String shortUserInput = userInput.substring(0,1);
        //Lowercase the string
        shortUserInput = shortUserInput.toLowerCase();
        //Compare if yes or no
        if(shortUserInput.equals("y") || shortUserInput.equals("n")){
            return true;
        }
        else{
            return false;
        }
    }
}
