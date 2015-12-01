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
    static boolean validInput = true;
    static String[] allStates = new String[21];
    static String startState;
    static String[] alphabet = new String[20];
    static String[] acceptStates = new String[21];
    
    static Hashtable transitionTable = new Hashtable();
        Enumeration names;
        String str;
        ArrayList transitions;
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
     */
    public static void main(String[] args){
        //Get user input by calling helper function; will check for valid input and alter input here.
        promptUser();
        
        //return appropriate answer to user.
        returnAnswer();
    }
    
    /**
     * Function convert()
     * 
     * Purpose: Show user given NFA or DFA to NFA that accepts A*
     * 
     */
    public static void returnAnswer(){
        //add new start state to the transitionTable
        transitionTable.put("Start", new ArrayList<String>(Arrays.asList("epsilon->" + startState)));
        //add new start state to list of accept states and to list of all states
        int numAccept = countMyArray(acceptStates);
        int numAll = countMyArray(allStates);
        acceptStates[numAccept+1] = "Start";
        allStates[numAll+1] = "Start";
        startState = "Start";
        System.out.println("*****************");
        System.out.println("PROGRAM OUTPUT: ");
        System.out.println("Start State: "+startState);
        System.out.println("Accept States: ");
        System.out.println("Start");
        printMyArray(acceptStates);
        System.out.println("All States: ");
        System.out.println("Start");
        printMyArray(allStates);
        System.out.println("Alphabet: ");
        printMyArray(alphabet);
        System.out.println("Transition Table: ");
        String printTableOut = transitionTable.toString();
        System.out.println(printTableOut);
       
    }
    
    public static void printMyArray(String[] arr){
        int length = countMyArray(arr);
        for(int i = 0; i < length; i++){
            if(arr[i]!=null){
                System.out.println(arr[i]);
            }
        }
    }
    
    /**
     * Function propmtUser()
     * 
     * Purpose: Helper function to main, will prompt
     *          user for info and store it appropriately
     *          for later use and manipulation.
     * 
     */
    
    public static void promptUser(){
        String INTRO_PROMPT = "Welcome to the Kleene Star Converter Program!";
        String Q_1 = "Please type NFA if converting a NFA or DFA if converting a DFA: ";
        String Q_2 = "Please type the start state(3 chars max): ";
        String Q_3 = "Please enter the Automata alphabet, by following the prompts. Max 20 chars, use 'empty' for empty string please. Otherwise, 1 char letters only, enter 'done' if done:";
        String Q_4 = "Please enter all accept states, one by one by folllowing the prompts";
        String Q_5 = "Please enter all  states, one by one by folllowing the prompts";
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
        System.out.println();
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
        System.out.println();
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
        System.out.println();
        //Get all states.
        if(validInput==true){
            System.out.println(Q_5);
            for( int i = 0; i < allStates.length; i++){
                System.out.println("Please enter states. 3 char max. Max 20 states, type 'done' when finished. Then hit return:");
                state = keyboard.nextLine();
                state = state.trim();
                if(state.equals("done")||i==allStates.length-1){
                    System.out.println("Thank you for entering the states.");
                    break;
                }
                else if(state.length() <=3){
                    allStates[i]=state;
                }
                else{
                    validInput=false;
                    System.out.println("Invalid state. Program terminating");
                }
            }
        }
        System.out.println();
        //Get Accept states.
        if(validInput==true){
            System.out.println(Q_4);
            for( int i = 0; i < acceptStates.length; i++){
                System.out.println("Please enter an accepting state. 3 char max. Max 20 accept states, type 'done' when finished. Must be a state from previous state you entered.Then hit return:");
                state = keyboard.nextLine();
                state = state.trim();
                if(state.equals("done")||i==acceptStates.length-1){
                        System.out.println("Thank you for entering the accept states.");
                        break;
                    }
                if(isStateInList(state)==true){
                    
                    if(state.length() <=3 || state.equals("empty")){
                        acceptStates[i]=state;
                    }
                    else{
                        validInput=false;
                        System.out.println("Invalid accept state. Program terminating");
                    }
                }
                else{
                    validInput=false;
                    System.out.println("Accept state not in list of states. Program terminating");
                    break;
                }
            }
        }
        
        //Loop through all states and get their appropriate transitions for each letter of the alphabet. 
      
            int numStates = countMyArray(allStates); //get me all the fucking states as a number
            int alphabetLen = countMyArray(alphabet); //
            for (int i = 0; i < numStates; i++){
            transitionTable.put(allStates[i], new ArrayList<String>(Arrays.asList("garbage")));
            ArrayList transitions = new ArrayList<String>(Arrays.asList(""));
            for(int j = 0; j < alphabetLen; j++){
                System.out.println("Please enter the state transition for { " + alphabet[j] + " } for state { " + allStates[i]+" }.");
                state = keyboard.nextLine();
                state = state.trim();
                transitions.add(alphabet[j] + "->" + state);
            }
               if(isItAnAcceptState(allStates[i])){
                transitions.add("empty->" + startState);
            }
            transitionTable.put(allStates[i], transitions);
        }
        String printItAll = transitionTable.toString();
        System.out.println(printItAll);
    }
    
    public static boolean isItAnAcceptState(String state){
        int lengthAcceptStates = countMyArray(acceptStates);
        for(int i = 0; i < lengthAcceptStates; i++){
            if(acceptStates[i].equals(state)){
                return true;
            }
        }
        return false;
    }
    
    public static int countMyArray(String[] arr){
        int count = 0;
        for( int i = 0; i < arr.length; i++){
            if(arr[i] != null){
                count++;
            }
            else{
                return count;
            }
        }
        return count;
    }
    
    /**
     * Function isStateInList
     * 
     * @parameter state //desired state to see if in List of States
     * @return true if in list, false otherwise
     */
    public static boolean isStateInList(String state){
        for( int i =0; i < allStates.length; i++){
            String allState = allStates[i];
            if(allState != null){
                if(allState.equals(state)){
                    return true;
                }
            }
        }
        return false;
    }
    
}
