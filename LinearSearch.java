// Linear Search 
// Time Complexity O(1)

import java.util.Random ;

public class LinearSearch {
    public static void main (String [] args) {
        int [] array = new int [20] ;
        int value = 20 ;
        
        // create your random number generator 
        Random random = new Random() ;
        for (int count = 0 ; count < 20 ; count++) {
            array [count] = random.nextInt(50) ;
        }
        // display the list and the index 
        int count = 0 ;
        for (int number : array) {
            System.out.println("Index " + count++ + ": " + number) ;
        }
        
        int index = search(array , value) ;
        if (index != -1) {
            System.out.println(value + " was found at index " + index) ;
        } else {
            System.out.println(value + " was not found in the array.") ;
        }
    }
    
    // function that returns the index if the number is found 
    public static int search (int [] array , int value) {
        for (int count = 0 ; count < 20 ; count++) {
            if (array[count] == value) {
                return count ;
            }
        }
        return -1 ;
    }
}
