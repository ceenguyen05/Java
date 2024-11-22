// recursive prime factors 

import java.util.Scanner ; // for user input 
    
public class PrimeFactorization 
{
    // prime numbers 
    private static final int [] PRIMES = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 
    43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 };
    
    // get the number from the user and call the function to find the prime factorization
    public static void main (String [] args)
    {
        Scanner input = new Scanner(System.in) ; // create Scanner for input 
        // ask the user for the number and store it 
        System.out.print("Enter a number: ") ;
        int userNumber = input.nextInt() ;
        if (userNumber < 2)
        {
            System.out.println("Your number does not have a prime factorization. ") ;
        }
        else 
        {
            findPrimeFactorization(userNumber) ; // function call to find prime factorization
        }
        input.close() ;
        
    }
    public static void findPrimeFactorization (int number)
    {
        // base case 
        // recursion stops when number is 1 
        if (number == 1)
        {
            return ;
        }
        // for loop that runs thorugh the prime list 
        // sees if the number divided by a prime number has no remainder 
        // if it is , prints the prime number 
        // then calls the function again for recursion 
        for (int tempPrime : PRIMES)
        {
            if (number % tempPrime == 0 )
            {
                System.out.print(tempPrime + " ") ;
                findPrimeFactorization(number / tempPrime) ;
                return ;
            }
        }
    }
}