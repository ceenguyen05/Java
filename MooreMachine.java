import java.util.Scanner ; // import scanner to get user input 

// Casey Nguyen 
// 9/12/2024
// COSC 2425 - 51700 , Professor Martinez 
// Program Purpose : Recreates the Moore Machine, given the initial state and the number input 
// Creates a Moore class to define one state of the Moore Machine 
// Creates Multiple Moore States and stores the value of the state 
// Processes the input by the user and stores them 
// Cycles through and appends the new state and displays the output and final state to the user 

// creates states of the MooreMachine 
public class MooreMachine 
{
    // creates states of the MooreMachine 
    public static class Moore 
    {
        private char state ; // the name of the state
        private String output ; // the output displayed when this state is entered
        private int zero ; // the index of the next state given an input of 0
        private int one ; // the index of the next state given an input of 1

        // constructor for the Moore state
        public Moore(char state, String output, int zero, int one) 
        {
            this.state = state ;
            this.output = output ;
            this.zero = zero ;
            this.one = one ;
        }
        // returns the state name 
        public char getState() 
        {
            return state ;
        }
        // returns the output for the state 
        public String getOutput() 
        {
            return output ;
        }
        // determines the next state 
        public int getNextState(int input) 
        {
            return input == 0 ? zero : one ;
        }
    }
    // main function 
    public static void main(String[] args) 
    {
        // Define Moore states
        Moore[] mooreStates = new Moore[5] ;
        mooreStates[0] = new Moore(' ', "", 0, 0) ; // holder state since we wont be using index 0 
        mooreStates[1] = new Moore('A', "00 ", 2, 4);
        mooreStates[2] = new Moore('B', "01 ", 2, 3) ;
        mooreStates[3] = new Moore('C', "11 ", 4, 3) ;
        mooreStates[4] = new Moore('D', "10 ", 3, 1) ;

        Scanner scanner = new Scanner(System.in) ; // create scanner to get user input 

        // get initial state from user
        System.out.print("Please enter the initial State: ") ;
        String initialStateInput = scanner.nextLine().toUpperCase() ;

        // check if the state given by the user is valid 
        int currentStateIndex = getStateIndex(initialStateInput, mooreStates) ;
        if (currentStateIndex == -1) 
        {
            System.out.println("Invalid initial state.") ;
            return ;
        }

        // get input string from user
        System.out.print("Please enter the input: ") ;
        String input = scanner.nextLine() ;

        // check if the input given is 1 and 0 only 
        if (!input.matches("[01]+")) 
        {
            System.out.println("Invalid input. Only binary values (0 and 1) are allowed.") ;
            return ;
        }

        // process input and display output
        StringBuilder outputBuilder = new StringBuilder() ;
        for (char letter : input.toCharArray()) 
        {
            int inputValue = Character.getNumericValue(letter) ;
            outputBuilder.append(mooreStates[currentStateIndex].getOutput()) ; 
            currentStateIndex = mooreStates[currentStateIndex].getNextState(inputValue) ;
        }

        // append the output for the final state after processing the input
        outputBuilder.append(mooreStates[currentStateIndex].getOutput()) ;

        // dislay the output and final state to the user 
        System.out.println("The output is:") ;
        System.out.println(outputBuilder.toString()) ;
        System.out.println("The final State is: " + mooreStates[currentStateIndex].getState()) ;
    }

    // a helper to find the name and info of the state 
    private static int getStateIndex(String stateName, Moore[] states) 
    {
        for (int i = 1; i < states.length; i++) 
        {
            if (states[i].getState() == stateName.charAt(0)) 
            {
                return i ;
            }
        }
        return -1 ; // return -1 if state is not valid 
    }
}
