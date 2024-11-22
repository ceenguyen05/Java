// Merge Sort 
// O(n log n)

import java.util.Random ;

public class MergeSort
{
	public static void main(String[] args) {
		int [] array = new int [20] ;
		Random random = new Random () ;
		
		System.out.println("Unsorted Array") ;
		for (int count = 0 ; count < array.length ; count++) {
		    array[count] = random.nextInt(50) ;
		    System.out.println("Index " + count + ": " + array[count]) ;
		}
		
		sort (array) ;
		System.out.println("\nSorted Array") ;
		for (int count = 0 ; count < array.length ; count++) {
		    System.out.println("Index " + count + ": " + array[count]) ;
		}
	}
	
	public static void sort (int [] array) {
	    if (array.length < 2 ) {
	        return ; // base case as any array with 1 index is already sorted 
	    }
	    
	    // get mid of array 
	    int mid = array.length / 2 ;
	    
	    // split the array 
	    int [] left = new int [mid] ;
	    int [] right = new int [array.length - mid] ;
	    
	    // copy elements in each Array
	    // original array , starting index of OG , destination array , starting index of destination , index 
        System.arraycopy(array, 0, left, 0, mid) ; 
        System.arraycopy(array, mid, right, 0, array.length - mid) ;
	    
	    // keep recursivly sorting the arrays in half
	    sort(left) ;
	    sort(right) ;
	    
	    // after all halves have been made, now merge sort them 
	    merge (array , left , right) ;
	}
	
	// merge the two sorted array , build into original array 
	private static void merge (int [] array , int [] left , int [] right) {
	    int arrayIndex = 0 ;
	    int leftIndex = 0 ; 
	    int rightIndex = 0;
	    
	    // compare values and put into original array respectivly 
	    while (leftIndex < left.length && rightIndex < right.length) {
	        // if the left array value is less than or equal to right array value , insert into array 
	        if (left [leftIndex] <= right [rightIndex]) {
	            array[arrayIndex++] = left[leftIndex++] ;
	        } else { // else add in the right value 
	            array[arrayIndex++] = right[rightIndex++] ;
	        }
	    }
	    
	    // add in any remaining left values (smallest values) 
	    while (leftIndex < left.length) {
	        array[arrayIndex++] = left[leftIndex++] ;
	    }
	    
	    // add in any remaining right values , (bigesst values on right) 
	    while (rightIndex < right.length) {
	        array[arrayIndex++] = right[rightIndex++] ;
	    }
	}
}

