import java.util.Scanner ;

public class VsCodeJava
{
    public static void main(String [] args)
    {
        System.out.println("Hello World") ;
        Scanner input = new Scanner(System.in) ;
        System.out.println ("What is your name? ") ;
        String name = input.nextLine() ;
        System.out.println ("Your name is " + name) ;
        input.close () ;
    }
}