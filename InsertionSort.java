// InsertionSort
// O(n^2)

import java.util.Random ;

public class InsertionSort
{
	public static void main(String[] args) {
		int [] array = new int [20] ;
		Random random = new Random () ;
		
		System.out.println("Unsorted Array") ;
		for (int count = 0 ; count < array.length ; count ++) {
		    array[count] = random.nextInt(50) ;
		    System.out.println("Index " + count + ": " + array[count]) ;
		}
		
		sort (array) ; // call function to sort 
		
		System.out.println("\nSorted Array") ;
		for (int count = 0 ; count < array.length ; count++) {
		    System.out.println("Index " + count + ": " + array[count]) ;
		}
	}
	
	public static void sort (int [] array) {
	    // start with the second element of the array 
	    for (int count = 1 ; count < array.length ; count ++) {
	        int current = array[count] ; // this value gets checked by the all the indexes before it 
	        int previousIndex = count - 1 ; // previous element of the sorted part 
	        
	        // checks each index before current 
	        // checks if the previous is greater than the current for all previous indexes 
	        while (previousIndex >= 0 && array[previousIndex] > current ) {
	            array[previousIndex + 1] = array[previousIndex] ; // shifts the value to the right one space
	            previousIndex--; // decrement to check the rest of the values before it 
	        }
	        
	        array[previousIndex + 1 ] = current ; // insert current at the right spot (sorted)
	    }
	}
}
