import java.util.Scanner ;

public class Calculator 
{
    public static void main (String [] args)
    {
        Scanner input = new Scanner (System.in) ;
        System.out.println("Select from the menu below: ") ;
        System.out.println("A. Addtion") ;
        System.out.println("B. Subtraction") ;
        System.out.println("C. Multiplication") ;
        System.out.println("D. Division") ;
        System.out.print("Selection: ") ;
        char selection = input.next().charAt(0) ;
        System.out.println("Enter two numbers seperated by a space. ") ;
        float number1 = input.nextInt() ;
        float number2 = input.nextInt() ;
        input.close () ;

        switch (selection)
        {
            case 'A' :
            System.out.println(number1 + " + " + number2 + " = " + addtion(number1 , number2)) ;
            break ;

            case 'B' :
            System.out.println(number1 + " - " + number2 + " = " + subtraction(number1 , number2)) ;
            break ;

            case 'C' :
            System.out.println(number1 + " * " + number2 + " = " + multiplication(number1 , number2)) ;
            break ;

            case 'D' :
            System.out.println(number1 + " / " + number2 + " = " + division(number1 , number2)) ;
            break ;
    
            default :
            System.out.println("Invalid Selection Chosen.") ;
            break ;
        }
    }

    public static float addtion (float number1 , float number2)
    {
        return number1 + number2 ;
    }
    public static float subtraction (float number1 , float number2)
    {
        return number1 - number2 ;
    }
    public static float multiplication (float number1 , float number2)
    {
        return number1 * number2 ;
    }
    public static float division (float number1 , float number2)
    {
        return number1 / number2 ;
    }
}