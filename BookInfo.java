import java.util.Scanner ; // import to use user inputs 

// main class 
public class BookInfo 
{
    public static void main (String [] args)
    {
        Scanner input = new Scanner (System.in) ; // creates input 
        
        // ask user for the book info 
        // assign values to the variables 
        System.out.println("Enter the book title, author, publication year and ibsn number. ") ;
        String title = input.nextLine() ;
        String author = input.nextLine() ;
        int year = input.nextInt() ;
        input.nextLine() ; // consume the newline after a int is entered 
        String isbn = input.nextLine () ;
        input.close() ; // close Scanner variable 
        // create a new book object and send it arguements 
        Book newBook = new Book (title, author, year, isbn) ;
        
        System.out.println(newBook.newBook()) ; // call the object and the function in the object class 
    }
}
// book class to get a book from a libraian 
class Book {
    // member variables 
    private String title ;
    private String author ;
    private int year ;
    private String isbn ;
    
    // constructor 
    public Book () {
        title = "" ;
        author = "" ;
        year = 0 ;
        isbn = "" ;
    }
    
    // getter function 
    public Book (String title0 , String author0 , int year0 , String isbn0) {
        this.title = title0 ;
        this.author = author0 ;
        this.year = year0 ;
        this.isbn = isbn0 ;
    }
    
    // setter function and returns the new string to be displayed to user 
    public final String newBook () {
        return ("\nBook: " + title + " by " + author + ", " + year + " , ISBN: " + isbn) ;
    }
}