/* Program Purpose :
 * Create a bank account program using classes 
 * user should be able to deposit and withdraw and see their balances 
*/

import java.util.Scanner ; // Scanner for user input 

// main class to get basic info 
// calls methods and classes 
public class BankTransactions 
{
    public static void main (String [] args)
    {
        Scanner input = new Scanner (System.in) ; // created a new scanner on the heap called input 
        System.out.print("Enter your account name: ") ; // prompts user to enter their name 
        String accountName = input.nextLine() ; // string variable to get their name 
        
        // create an object for the BankAccount class on the heap
        // sets the accountName in the BankAccount class via constructor 
        BankAccount bankClass = new BankAccount (accountName) ;
        
        char moreTransactions ; // variable to ask the user to do more transactions
        double balance = 0 ; // creates balance variable
        
        // do while loop to keep going if the user wants to do more transactions 
        do 
        {
            // pass the Scanner input so getChoice can use it 
            // calls the getChoice function to get user choice on transaction type
            char choice = getChoice(input) ; 
        
            // call the transactionType method to compute the deposits and withdrawls 
            // pass the object , scanner , and character to the function
            transactionType(bankClass , input, choice) ;
        
            // get new bank balance 
            balance = bankClass.getBalance() ;
            
            // ask the user if they would like to make another transaction 
            System.out.print("\nWould you like to make another transaction? (Y or N) ") ;
            moreTransactions = input.next().charAt(0) ;
        }
        while (Character.toUpperCase(moreTransactions) == 'Y') ; // make character uppercase 
        
        // call the displayInfo method inside the bankClass object to display a receipt to the user 
        bankClass.displayInfo () ;
        
        input.close() ; // close the input Scanner to avoid memory leaks 
    }
    
    // static class to access thorughout the class 
    public static char getChoice (Scanner input)
    {
        char choice ;
        // do while loop to check if menu choice was valid 
        do 
        {
            // menu choice prompted to the user 
            System.out.println("\nWhat would you like to do today? ") ;
            System.out.println("A. Deposit") ;
            System.out.println("B. Withdraw") ;
            System.out.print("Your Choice: ") ;
            choice = input.next().charAt(0) ; // gets the next character 
            choice = Character.toUpperCase(choice) ; // makes character upper case (in event user enters a or b)
            
            // checks if a or b was entered 
            if (choice != 'A' && choice != 'B')
            {
                System.out.println("Invalid menu choice selected, try again. ") ; // error message 
            }
        }
        while (choice != 'A' && choice != 'B') ; // continues until a or b is selected
        
        return choice ; // returns the validated choice to the main fucntion 
    }
    
    // method to pass amounts of money to the balance in the class BankAccount 
    public static void transactionType (BankAccount bankClass , Scanner input, char choice)
    {
        double amount = 0.00 ; // amount variable to handle the transaction
        // switch statement to handle deposits and withdrawals 
        switch (choice)
        {
            // handles deposits 
            case 'A' :
                System.out.print("\nHow much would you like to deposit? $") ;
                amount = input.nextDouble() ;
                bankClass.deposit(amount) ;
                break ;
            // handle withdrawals 
            case 'B' :
                System.out.print("\nHow much would you like to withdraw? $") ;
                amount = input.nextDouble() ;
                bankClass.withdraw(amount , input) ;
                break ;
        }
    }
}

// BankAccount class to handle bank transactions 
class BankAccount 
{
    private String accountName ; // private variable to store name 
    private double balance ;  // private variable to store the balance 
    private final double INITIAL_BALANCE = 500.00; // initial balance
    
    // initializes member variables with a constructor 
    BankAccount (String accountName) {
        this.accountName = accountName ;
        balance = 500.00 ; // user has $500 to start 
    }
    
    // setter method , updates the user balance with the deposit amount 
    public void deposit (double depositAmount)
    {
        this.balance = balance + depositAmount ;
    }
    
    // setter method , updates the user balance with the withdrawal amount 
    public void withdraw (double withdrawalAmount , Scanner input)
    {
        // if user attempts to withdraw more than they have, prompt them a message 
        // else make the calculation
        if (withdrawalAmount > balance)
        {
            System.out.print("Withdrawal amount will result in overdraft, continue? (Y or N) ") ;
            char choice = input.next().charAt(0) ;
            if (Character.toUpperCase(choice) == 'Y')
            {
                this.balance = balance - withdrawalAmount ;
            }
        }
        else 
        {
            this.balance = balance - withdrawalAmount ;
        }
    }
    
    // returns the balance when called 
    public double getBalance ()
    {
        return balance ;
    }
    
    // returns the account name when called 
    public String getAccountName () 
    {
        return accountName ;
    }
    
    public void displayInfo ()
    {
        // display a receipt, containing name, previous balance and new balance 
        System.out.println("\nReceipt: ") ;
        System.out.println("Name: " + accountName) ;
        System.out.println("Previous Balance: $" + String.format("%.2f" , INITIAL_BALANCE)) ; // 2 decimals
        // if negative balance , display an overdraft message 
        if (balance < 0)
        {
            System.out.println("OVERDRAFTED") ;
        }
        System.out.println("New Balance: $" + String.format("%.2f", balance)) ; // format two decimal places
    }
}
