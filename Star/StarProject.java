import java.util.*;
/**
 * Write a description of class StarProject here.
 * 
 * @author Rachel Smith and Nerissa Lemon
 * @version v1.0 10_28_15
 */
public class StarProject
{
    // instance variables
    public String INTRO_PROMPT = "Welcome to the Kleene Star Converter Program!";
    public String Q_1 = "Please type NFA if converting an NFA or DFA if converting a DFA: ";
    static boolean validInput = true;
    /**
     * Constructor for objects of class StarProject
     */
    public StarProject()
    {

    }

    /**
     * Main Method. Will handle entire program by calling 
     * helper functions and files.
     * 
     * @author Rachel Smith and Nerissa Lemon
     */
    public static void main(String[] args){
        //Get user input by calling helper function; will check for valid input here.
        promptUser();
        
        //If user entered valid input, proceed.
        if(validInput == true){
            //Perform computation of converting the NFA or DFA.

            //Return the appropriate NFA accepting A* to the user.
        }

    }

    public static void promptUser(){
        String INTRO_PROMPT = "Welcome to the Kleene Star Converter Program!";
        String Q_1 = "Please type NFA if converting a NFA or DFA if converting a DFA: ";
        String Q_2 = "Please type the start state(3 chars max): ";
        //Welcome user to program.
        System.out.println(INTRO_PROMPT);
        //Ask what they are converting.
        System.out.println(Q_1);
        //Save response, determine if prompt for NFA or DFA.
        String state;
        Scanner keyboard = new Scanner(System.in);
        state = keyboard.nextLine();
        state = state.trim();
        state = state.toUpperCase();
        if(state.equals("NFA")){
            System.out.println("You have selected NFA!");
        }
        else if(state.equals("DFA")){
            System.out.println("You have selected DFA!");
        }
        else{
            System.out.println("So sorry, we can't convert anything of type: " + state + ". Program terminating.");
            validInput = false;
        }
        
        //Get start state. Must contain no spaces and only one word.
        if(validInput==true){
            System.out.println(Q_2);
            state = keyboard.nextLine();
            state = state.trim();
            //If number of chars <= 3, proceed
            if(state.length() <= 3){
                System.out.println("Your start state "+state+" is valid input.");
            }
            //If input was invalid, terminate program.
            else{
                System.out.println("So sorry, " + state + " exceeds the 3 character limit. Program terminating.");
                validInput = false;
            }
            
        }
        
        //Get 
        
    }

}
