// Binary Search 
// O(log n)

public class BinarySearch
{
	public static void main(String[] args) {
	    // array must be already sorted 
		int [] array = {7,21,30,33,41,49,54,60,65,71,76,79,80,90,98,99} ;
		int value = 71  ;
		int low = 0 ;
		int high = array.length - 1;
		int index = search (array , value , low , high) ;
		if (index != -1) {
		    System.out.println("Value 71 was found at Index " + index) ;
		} else {
		    System.out.println("Value 3 was not found in the array.") ;
		}
	}
	
	public static int search (int [] array , int value , int low , int high) {
	    // if the value is not found 
	    if (low > high) {
	        return -1 ;
	    }
	    
	    // get the midpoint each time 
	    int mid = (low + high) / 2 ; 
	    
	    // check if mid is the target value 
	    if (array[mid] == value) {
	        return mid ;
	   // check if mid is lower 
	    } else if (array[mid] < value) {
	        // if it is call the function again , pass the low as mid 
	        return search (array , value , mid + 1 , high) ;
	   // this means mid is higher than target value , pass high as mid 
	    } else {
	        return search (array , value , low , mid - 1) ;
	    }
	}
}
