import java.util.Scanner ;
import java.util.List ;
import java.util.ArrayList ;

public class LibrarySystem
{
    public static void main (String [] args) {
        Scanner input = new Scanner(System.in) ;
        Library libraryClass = new Library () ;
        String choice = "" ;
    
        while (true) {
            System.out.print("Would you like to add a book or a magazine? ") ;
            String item = input.nextLine().toLowerCase() ;
            if (item.equals("book")) {
                System.out.print("What is the title of the book? ") ;
                String title = input.nextLine() ;
                System.out.print("Who is the author of the book? ") ;
                String author = input.nextLine() ;
                System.out.print("What is the ibsn of the book? ") ;
                String ibsn = input.nextLine() ;
                System.out.print("How many pages is the book? ") ;
                int pages = input.nextInt() ;
                input.nextLine() ;
                Book bookClass = new Book (title , author , ibsn , pages) ;
                libraryClass.addList(bookClass) ;
            }
            else if (item.equals("magazine")) {
                System.out.print("What is the title of the magazine? ") ;
                String title = input.nextLine() ;
                System.out.print("Who is the author of the magazine? ") ;
                String author = input.nextLine() ;
                System.out.print("What is the issue number of the magazine? ") ;
                int issueNumber = input.nextInt() ;
                input.nextLine() ;
                Magazine magazineClass = new Magazine (title , author , issueNumber) ;
                libraryClass.addList(magazineClass) ;
            }
            else {
                System.out.println ("Invalid choice.") ;
            }
            choice = resume (input) ;
            if (choice.equals("no")) {
                break ;
            }
            
            System.out.println() ;
        }
        System.out.println("\nLibrary Items: \n") ;
        libraryClass.displayLibraryInfo () ;
    }
    public static String resume (Scanner input) {
        System.out.print("\nWould you like to add more items? (yes or no) ") ;
        return (input.nextLine().toLowerCase()) ;
    }
}

// interface to define basic details 
interface LibraryItem {
    String getTitle () ;
    String getAuthor () ;
    void displayInfo () ;
}

class Book implements LibraryItem {
    private String title ;
    private String author ;
    private String ibsn ;
    private int pages ;
    
    Book (String title, String author , String ibsn , int pages) {
        this.title = title ;
        this.author = author ;
        this.ibsn = ibsn ;
        this.pages = pages ;
    }
    
    @Override 
    public String getTitle () {
        return title ;
    }
    
    @Override 
    public String getAuthor () {
        return author ;
    }
    
    @Override 
    public void displayInfo () {
        System.out.println ("Book") ;
        System.out.println ("Title: " + title) ;
        System.out.println ("Author: " + author) ;
        System.out.println ("IBSN: " + ibsn) ;
        System.out.println ("Pages: " + pages) ;
    }
}

class Magazine implements LibraryItem {
    private String title ;
    private String author ;
    private int issueNumber ;
    
    Magazine (String title , String author , int issueNumber) {
        this.title = title ;
        this.author = author ;
        this.issueNumber = issueNumber ;
    }
    
    @Override 
    public String getTitle () {
        return title ;
    }
    
    @Override 
    public String getAuthor () {
        return author ;
    }
    
    @Override 
    public void displayInfo () {
        System.out.println ("Magazine") ;
        System.out.println ("Title: " + title) ;
        System.out.println ("Author: " + author) ;
        System.out.println ("Issue Number: " + issueNumber) ;
    }
}

class Library {
    private List<LibraryItem> items ;
    
    Library () {
        items = new ArrayList<>() ;
    }
    
    public void addList (LibraryItem item) {
        items.add(item) ;
    }
    
    public void displayLibraryInfo () {
        for (LibraryItem item : items) {
            item.displayInfo();
            System.out.println();
        }
    }
}
