// Casey Nguyen 
// 10/15/2024
// COSC 2425 - 51700 , Professor Martinez 

// Program Purpose :
// A Simple stack machine tha contains 6 functions 
// Push, adds value on stack 
// pop , removes value from stack 
// add , pops two values but adds then first then pushes 
// sub , div , mul , same idea as last line except for their operators 
// reads from a txt file called machine.txt, only works if the file is named machine.txt
// displays message to console like the sample output in the pdf instructions 

// imports to read file and handle 
// also an import to use stack 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class StackMachine {

    private static final int MEMORY_SIZE = 10; // M0 to M9
    private static double[] memory = new double[MEMORY_SIZE]; // create the array and declare size 
    private static Stack<Double> stack = new Stack<>(); // create the stack 

    public static void main(String[] args) {
        String filename = "machine.txt"; // The input file containing the instructions
        // try catch block to make sure the file can be read , must used a txt file called machine
        try {
            executeInstructions(filename);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
    
    // reads the file , throws an exception if cannot be read 
    private static void executeInstructions(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                executeInstruction(line.trim());
            }
        }
    }
    
    // instruction set for the stack features 
    // 6 features and a defaulr case 
    private static void executeInstruction(String instruction) {
        String[] parts = instruction.split("\\s+");
        String operation = parts[0];

        switch (operation) {
            case "Push":
                handlePush(parts[1]);
                break;
            case "Pop":
                handlePop(parts[1]);
                break;
            case "Add":
                handleAdd();
                break;
            case "Sub":
                handleSub();
                break;
            case "Mul":
                handleMul();
                break;
            case "Div":
                handleDiv();
                break;
            default:
                System.out.println("Unknown instruction: " + operation);
        }
    }
    
    // function that handles the pushing of values on the stack at each part 
    private static void handlePush(String operand) {
        if (isMemoryLocation(operand)) {
            int index = operand.charAt(1) - '0'; // M0-M9
            stack.push(memory[index]);
        } else {
            stack.push(Double.parseDouble(operand)); // Push the literal
        }
    }
    
    // handles and displays the pop in each location uses array and index 
    private static void handlePop(String operand) {
        int index = operand.charAt(1) - '0'; // M0-M9
        double value = stack.pop();
        memory[index] = value;
        System.out.printf(value + " Stored in location %s%n", operand);
    }
    
    // adds onto the stack 
    private static void handleAdd() {
        double t2 = stack.pop();
        double t1 = stack.pop();
        stack.push(t1 + t2);
    }
    
    // subtracts from the stack 
    private static void handleSub() {
        double t2 = stack.pop();
        double t1 = stack.pop();
        stack.push(t1 - t2);
    }
    
    // mutlipies values from the stack 
    private static void handleMul() {
        double t2 = stack.pop();
        double t1 = stack.pop();
        stack.push(t1 * t2);
    }
    
    // divides values from the stack 
    private static void handleDiv() {
        double t2 = stack.pop();
        double t1 = stack.pop();
        stack.push(t1 / t2);
    }
    
    // checks memory location , returns true if it starts with M and has correct length and digit for second
    // character 
    private static boolean isMemoryLocation(String operand) {
        return operand.startsWith("M") && operand.length() == 2 && Character.isDigit(operand.charAt(1));
    }
}
