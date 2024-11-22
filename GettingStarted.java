import java.util.Scanner ;

public class GettingStarted
{
    public static void main (String [] args)
    {
        Scanner newScanner = new Scanner(System.in) ;
        System.out.println("Enter a number: ") ;
        int x = newScanner.nextInt() ;
        System.out.println() ;
        System.out.println("You entered the number " + x + ".") ;
        StringBuilder string = new StringBuilder("Hello there") ;
        string.append ( " Casey.") ;
        System.out.println() ;
        System.out.println(string.toString()) ;
    }
}