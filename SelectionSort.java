// Selection Sort 
// O(n^2)

import java.util.Random ;

public class SelectionSort
{
	public static void main(String[] args) {
		int [] array = new int [20] ; // created a new array 
		Random random = new Random () ; // for random numbers
		
		// fill the array with random numbers and then display what values are in each index 
		System.out.println("Original Array") ;
		for (int count = 0 ; count < 20 ; count++){
		    array[count] = random.nextInt(100) ;
		    System.out.println ("Index " + count + ": " + array[count]) ;
		}
		
		sort (array) ; // call the sort function 
		System.out.println("\nSorted Array") ;
		for (int count = 0 ; count < 20 ; count++) {
		    System.out.println("Index " + count + ": " + array[count]) ;
		}
	
	}
	
	public static void sort (int [] array) {
	    int size = array.length ;
	    // first for loop makes sure we go through the entire array
	    for (int count = 0 ; count < size - 1 ; count ++) {
	        int minIndex = count ; // start with the first index 
	        
	        // nested for loop that finds the next smallest value by index 
	        for (int index = count + 1 ; index < size ; index++) {
	            if (array[index] < array[minIndex]) {
	                minIndex = index ; // this index has the slot of the smallest element of the unsorted
	            }
	        }
	        // swap the values 
	       int temp = array[minIndex] ; // placeholder 
	       array[minIndex] = array[count] ;
	       array[count] = temp ; 
	    }
	}
}
