// recursion to find factorial of a number 

import java.util.Scanner ; // to get user input 

public class Factorial 
{
    public static void main (String [] args)
    {
        // ask the user for the number 
        Scanner input = new Scanner (System.in) ;
        int number ;
        do 
        {
            System.out.print ("Enter a positive number: ") ;
            number = input.nextInt() ;
            
            if (number < 0)
            {
                System.out.println("\nCannot enter an negative number, try again.") ;
            }
        }
        while (number < 0) ;
        
        // call the recursion function 
        // assign the value of the return to a variable 
        // display the result 
        int factorialNumber = factorial(number) ;
        
        System.out.println("The factorial of " + number + " is " + factorialNumber) ;
    }
    
    // recursion function that multiplies the number until 0 is reached
    // fuction calls itself for each time the number variable is not 0
    // returns the total value 
    public static int factorial (int number)
    {
        if (number == 0)
        {
            return 1 ;
        }
        else 
        {
            return number * factorial(number - 1) ;
        }
    }
}