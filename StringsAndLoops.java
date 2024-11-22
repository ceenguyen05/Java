public class StringsAndLoops 
{
    public static void main (String [] args)
    {
        // creating an array of strings 
        String [] entries = {"Hi" , "There" , "Student"} ;
        // creates a string builder to make a string ;
        StringBuilder string = new StringBuilder () ;
        int count = 0 ;
        
        // while loop to add the contents of entries to the string using .append 
        while (count < entries.length)
        {
            string.append (entries[count]) ;
            count++ ;
        }
        // shows the user what is in the string variable now 
        System.out.println (string) ;
        
        StringBuilder string2 = new StringBuilder () ;
        // adds the strings in entries in a string backwards 
        for (int counter = entries.length - 1 ; counter >= 0 ; counter --)
        {
            string2.append (entries[counter]) ;
        }
        System.out.println (string2) ;
        
        // adds both words together 
        string.append (string2) ;
        System.out.println (string) ;
    }
}