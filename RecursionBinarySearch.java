// recursion with binary search 

import java.util.Scanner ;

public class RecursionBinarySearch
{
    public static void main (String [] args)
    {
        Scanner input = new Scanner (System.in) ;
        
        System.out.println("What is the target number?") ;
        int target = input.nextInt()  ;
        input.close() ;
        // defined an array in order 
        int [] array = {7 , 21 , 28 , 49 , 50 , 66 , 78 , 82 , 91 , 100} ;
        int low = 0 ; // low index of array 
        int high = array.length - 1 ; // high index of array 
        // assigns the value of the return function , passes 4 arguements 
        int found = BinarySearch (array , low , high , target) ;
        // if found display the index , if not display not found 
        if (found == -1)
        {
            System.out.println("Number not found in array.") ;
        }
        else 
        {
            System.out.println("Number found at index " + found) ;
        }
    }
    
    // function for binary search 
    public static int BinarySearch (int [] array , int low , int high , int target)
    {
        // base case for search if the target ends up not being found 
        if (low > high)
        {
            return -1 ;
        }
        
        // midpoint does integer division each time function gets called 
        int midpoint = (high + low) / 2 ;
        
        // if the target is the midpoint , return the midpoint 
        if (target == array[midpoint])
        {
            return midpoint ;
        }
        // if the midpoint index is smaller than the target 
        // change the low to midpoint + 1 as to search the right side of the array 
        else if (array[midpoint] < target)
        {
            return BinarySearch (array , midpoint + 1 , high , target) ; // recrusion 
        }
        // if the midpoint index is bigger than the target 
        // change high to midpoint - 1 to search the array from the left half side 
        else 
        {
            return BinarySearch (array , low , midpoint - 1 , target) ; // recursion 
        }

    }
}