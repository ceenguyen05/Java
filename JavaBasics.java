import java.util.Scanner ; // need package Scanner to use inputs 

public class JavaBasics // public class , related to header file 
{
    public static void main (String [] args) // main body for displaying strings 
    {
        System.out.println ("Enter a number: ") ; // demonstration of using output 
        Scanner input = new Scanner (System.in) ; // create a Scanner variable 
        int number = input.nextInt () ; // demonstration on how to get input from user 
        System.out.println ("\nYour number was " + number) ;
        
        // how to combine literal strings and variables
        int number1 = 10 ;
        System.out.println ("The system number is " + number1) ;
        
        // how to use stringbuilder to place in string variable 
        StringBuilder string = new StringBuilder ("Casey") ;
        // uses variable name and .append to add to the string 
        string.append (" you are a computer science major.") ;
        System.out.println("\n" + string) ;
        
        System.out.println("\nEnter another number: ") ;
        int number2 = input.nextInt () ;
        System.out.println("Enter another number: ") ;
        int number3 = input.nextInt () ;
        // demonstration of if , else statement 
        if (number2 == number3)
        {
            System.out.println ("\nThe last two numbers are equal in value.") ;
            System.out.println ("The value of these two numbers are: " + (number2 + number3)) ;
        }
        else 
        {
            System.out.println ("\nThe last two numbers are not equal in value.") ;
            System.out.println ("The value of these two numbers are: " + (number2 + number3) + "\n") ;
        }
        
        String userInput ; // conditional variable 
        do 
        {
            System.out.println ("\nEnter what function you want to use: ") ;
            System.out.println ("A. Addition") ;
            System.out.println ("B. Subtraction") ;
            System.out.println ("C. Multiplication") ;
            System.out.println ("D. Division") ;
            System.out.print ("Choice: ") ;
            char switchLetter = input.next().charAt(0) ; // how to input a char variable 
            input.nextLine () ; // previous input left a garbage newline , this is used to clear 
            
            // only ask for input if a menu choice was selected 
            if (switchLetter == 'A' || switchLetter == 'B' || switchLetter == 'C' || switchLetter == 'D')
            {
                System.out.println ("\nEnter a number: ") ;
                int number4 = input.nextInt() ;
                System.out.println ("Enter another number: ") ;
                int number5 = input.nextInt();
                input.nextLine() ; // clears garbage newline 
                
            // switch statement for the menu program 
            switch (switchLetter)
            {
                case 'A' :
                {
                    int result = number4 + number5 ;
                    System.out.println ("\n" + number4 + " + " + number5 + " = " + result) ;
                }
                break ;
                
                case 'B' : 
                {
                    int result = number4 - number5 ;
                    System.out.println ("\n" + number4 + " - " + number5 + " = " + result) ;
                }
                break ;
                
                case 'C' : 
                {
                    int result = number4 * number5 ;
                    System.out.println ("\n" + number4 + " * " + number5 + " = " + result) ;
                }
                break ;
                
                case 'D' :
                {
                    // switch to a double to handle decimals and format two decimal places 
                    double result = (double) number4 / (double) number5 ;
                    String formattedResult = String.format("%.2f", result);
                    System.out.println ("\n" + number4 + " / " + number5 + " = " + formattedResult) ;
                }  
                break ;
            }
            }
            else 
            {
                System.out.println ("\nInvalid choice selected.") ;
            }
            
            System.out.println ("\nDo you want to use this program again? (Yes or No)") ;
            userInput = input.nextLine() ;
            
        }
        while (userInput.equals("Yes")) ;
        
        System.out.println ("\nEnd of Program") ;
    }
}