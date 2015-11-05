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
        String Q_3 = "Please enter the Automata alphabet, by following the prompts. Max 20 chars, use 'empty' for empty string please. Otherwise, 1 char letters only, enter 'done' if done:";
        String Q_4 = "Please enter all accept states, one by one by folllowing the prompts";
        //Welcome user to program.
        System.out.println(INTRO_PROMPT);
        //Ask what they are converting.
        System.out.println(Q_1);
        //Save response, determine if prompt for NFA or DFA.
        String state;
        String startState;
        String[] alphabet = new String[20];
        String[] acceptStates = new String[20];
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
                startState = state;
            }
            //If input was invalid, terminate program.
            else{
                System.out.println("So sorry, " + state + " exceeds the 3 character limit. Program terminating.");
                validInput = false;
            }
            
        }
        
        //Get alphabet.
        if(validInput==true){
            System.out.println(Q_3);
            for( int i = 0; i < alphabet.length; i++){
                System.out.println("Please enter an alphabet character. 1 char max unless entering 'empty' for empty string. Max 20 char alphabet and hit return");
                state = keyboard.nextLine();
                state = state.trim();
                if(state.equals("done")||i==alphabet.length-1){
                    System.out.println("Thank you for entering the alphabet.");
                    break;
                }
                else if(state.length() <=1 || state.equals("empty")){
                    alphabet[i]=state;
                }
                else{
                    validInput=false;
                    System.out.println("Invalid alphabet. Program terminating");
                }
            }
        }
        
        //Get Accept states.
        if(validInput==true){
            System.out.println(Q_4);
            for( int i = 0; i < acceptStates.length; i++){
                System.out.println("Please enter an accepting state. 3 char max. Max 20 accept states, type 'done' when finished. Then hit return:");
                state = keyboard.nextLine();
                state = state.trim();
                if(state.equals("done")||i==acceptStates.length-1){
                    System.out.println("Thank you for entering the accept states.");
                    break;
                }
                else if(state.length() <=3 || state.equals("empty")){
                    acceptStates[i]=state;
                }
                else{
                    validInput=false;
                    System.out.println("Invalid accept state. Program terminating");
                }
            }
        }
        
        //Get all states and transitions.
        
    }

}
