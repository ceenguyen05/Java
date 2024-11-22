import java.util.Scanner ;

public class BankAccountFile {
    public static void main (String [] args) {
        Scanner input = new Scanner(System.in) ;
        System.out.print("How much is in your account? $") ;
        double balance = input.nextDouble() ;
        
        System.out.println("\nMenu Display") ;
        System.out.println("1. Display Balance") ;
        System.out.println("2. Deposit") ;
        System.out.println("3. Withdraw") ; 
        int choice = input.nextInt() ;
        
        // create an instance of the BankAccount class and pass to the constructor 
        BankAccount bankAccount = new BankAccount (balance) ;
        switch (choice) {
            case 1 :
                System.out.println("\nCurrent Balance: $" +String.format("%.2f",bankAccount.getBalance())) ;
                break ;
            case 2 :
                try {
                    System.out.println("\nHow much would you like to deposit? $") ;
                    double amount = input.nextDouble() ;
                    bankAccount.deposit(amount) ;
                    System.out.println("\nCurrent Balance: $" + String.format("%.2f",bankAccount.getBalance())) ;
                }
                catch (InvalidTransactionException e) {
                    System.out.println('\n' + e.getMessage()) ;
                }
                break ;
            case 3 :
                try {
                    System.out.println("\nHow much would you like to withdraw? $") ;
                    double amount = input.nextDouble() ;
                    bankAccount.withdraw(amount) ;
                    System.out.println("Current Balance: " + String.format("%.2f",bankAccount.getBalance())) ;
                }
                catch (InvalidTransactionException e) {
                    System.out.println('\n' + e.getMessage()) ;
                }
                catch (InsufficientFundsException e) {
                    System.out.println('\n' + e.getMessage()) ;
                }
                break ;
            default :
                System.out.println("\nInvalid menu choice") ;
        }
    }
}

class BankAccount {
    // private member variable 
    private double balance ;
    
    // constructor 
    BankAccount (double balance) {
        this.balance = balance ;
    }
    public void deposit (double amount) throws InvalidTransactionException {
        if (amount < 0) {
            throw new InvalidTransactionException ("Cannot input a negative number") ;
        }
        balance += amount ;
    }
    
    public void withdraw (double amount) throws InsufficientFundsException , InvalidTransactionException {
        if ((balance - amount) < 0) {
            throw new InsufficientFundsException ("Cannot overdraft bank account") ;
        }
        else if (amount < 0) {
            throw new InvalidTransactionException ("Cannot input a negative number") ;
        }
        balance -= amount ;
    }
    
    // getter for the balance 
    public double getBalance () {
        return balance ;
    }
}

// error exception for not enough funds, passes a error message 
class InsufficientFundsException extends Exception {
    InsufficientFundsException (String error) {
        super(error) ;
    }
}

// error exception for negative inputs, passes a error message 
class InvalidTransactionException extends Exception {
    InvalidTransactionException (String error) {
        super(error) ;
    }
}