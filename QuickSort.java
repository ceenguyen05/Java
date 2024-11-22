// Quick Sort 
// O(n log n)

import java.util.Random ;

public class QuickSort
{
    private static Random random = new Random () ;
    
	public static void main(String[] args) {
		int [] array = new int [20] ;
		
		System.out.println("Unsorted Array") ;
		for (int count = 0 ; count < array.length ; count++) {
		    array[count] = random.nextInt(50) ;
		    System.out.println("Index " + count + ": " + array[count]) ;
		}
		
		// 0 index and max index 
		sort (array , 0 , array.length - 1) ;
		
		System.out.println("\nSorted Array") ;
		for (int count = 0 ; count < array.length ; count++) {
		    System.out.println("Index " + count + ": " + array[count]) ;
		}
	}
	
	public static void sort (int [] array , int low , int high) {
	    if (low < high) {
	        int pivot = randomPivot (array , low , high) ; // get random pivot 
	        
	        // recursion , sorts left and right side out 
	        sort (array , low , pivot - 1) ; // for values lower than pivot 
	        sort (array , pivot + 1 , high) ; // values greater than pivot 
	    }
	}
	
	private static int randomPivot (int [] array , int low , int high) {
	    int randomNumber = random.nextInt(high - low + 1) + low ; // generate a random index in range 
	    
	    swap (array , randomNumber , high) ; // swap the random number to the end of array 
	    
	    return split (array , low , high) ; // call the split function, this sorts the array 
	}
	
	private static int split (int [] array , int low , int high) {
	    int pivot = array[high] ; // pivot is high now that we swapped in the last function 
	    int lower = low - 1 ; // previous index before low 
	    
	    // loops through current sub array 
	    for (int count = low ; count < high ; count++) {
	        // if the value is smaller than pivot , swap 
	        if (array[count] <= pivot) {
	            lower ++ ; // increment and swap 
	            swap (array , lower , count) ;
	        }
	    }
	    
	    // swap the pivot in the right place 
	    swap (array , lower + 1 , high) ;
	    
	    return lower + 1 ; // index of the pivot 
	}
	
	private static void swap (int [] array , int previous , int current) {
	    int temp = array[previous] ;
	    array[previous] = array[current] ;
	    array[current] = temp ;
	}
}
