// Radix Sort 
// O(n)

import java.util.Random ;

public class RadixSort
{
	public static void main(String[] args) {
		int [] array = new int [20] ;
		Random random = new Random () ;
		
		System.out.println("Unsorted Array") ;
		for (int count = 0 ; count < array.length ; count++) {
		    array[count] = random.nextInt(500) ;
		    System.out.println("Index " + count + ": " + array[count]) ;
		}
		
		sort (array) ;
		System.out.println("\nSorted Array") ;
		for (int count = 0 ; count < array.length ; count++) {
		    System.out.println("Index " + count + ": " + array[count]) ;
		}
	}
	
	public static void sort (int [] array) {
	    // gets the highest number in the array , this is to see how many passes radix needs 
	    int max = getMax (array) ; 
	    
	    // for loop for passes update for each place (1,10,100,etc)
	    // exp times 10 goes to each place (1,10,100)
	    // say 782 , exp can at most go to 100 , so there are three passes 
	    for (int exp = 1 ; max / exp > 0 ; exp*=10) {
	        // call the sorting function 
	        countSort (array , exp) ;
	    }
	}
	
	private static void countSort (int [] array , int exp) {
	    int size = array.length ; // size of array 
	    int [] sortedArray = new int [size] ; // to store sorted array values 
	    int [] countPlace = new int [10] ; // to store the amount of times 0-9 appears 
	    
	    // count how many times each digit occurs in the current exp 
	    for (int count = 0 ; count < size ; count++) {
	        // divsion removes the places we arent looking for (1,10,100s)
	        // % gets the right most digit , this digit we increment in the countPlace
	        countPlace[(array[count] / exp) % 10]++ ; // increment 
	    }
	    
	    // get the last occurence of the position 
	    for (int count = 1 ; count < 10 ; count++) {
	        countPlace[count] += countPlace[count - 1] ;
	    }
	    
	    // put elements in sortedArray 
	    for (int count = size - 1 ; count >= 0 ; count-- ) {
	        // put the value in the sorted array 
	        sortedArray[countPlace[(array[count] / exp) % 10] - 1] = array[count] ;
	        countPlace[(array[count] / exp) % 10]-- ; // decrement the times the number ends in 
	    }
	    
	    // copy sorted array back to original array 
	    System.arraycopy(sortedArray , 0 , array , 0 , size) ;
	}
	
	// gets the max value of the array 
	private static int getMax (int [] array) {
	    int max = array[0] ;
	    for (int count = 1 ; count < array.length ; count++) {
	        if (max < array[count]) {
	            max = array[count] ;
	        }
	    }
	    return max ;
	}
}

