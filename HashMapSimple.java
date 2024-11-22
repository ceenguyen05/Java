// must import the hashmap util 
import java.util.HashMap ;

public class HashMapSimple
{
	public static void main(String[] args) {
	    // create a new HashMap instance 
	    // String is the key , Integer is the value pair to string 
		HashMap <String , Integer> map = new HashMap <> () ;
		
		// add your family and their ages 
		// *.put* is how to add to the HashMap 
		map.put("Dad" , 51) ;
		map.put("Mom" , 51) ;
		map.put("Claudia" , 20) ;
		map.put("Casey" , 19) ;
		map.put("Ian" , 10) ;
		
		// check if a key exist by using *.containsKey()*
		if (map.containsKey("Ian")) {
		    System.out.println("Ian's Age is " + map.get("Ian")) ;
		}
		// go through the entire hashmap 
		// to go through the hasmap , use *.keySet()*
		// *key* would be the first thing in the hash , aka the name 
		// to get the value pair to key , call *.get(key)*
		System.out.println("\nFamily and their ages :") ;
		for (String key : map.keySet()) {
		    System.out.println ("Name: " + key + ", Age: " + map.get(key)) ;
		}
		
        // to remove from a hashmap, use *.remove()*
		// input the key and it will remove the key/value pair 
		map.remove("Casey") ;
		System.out.print("Is Casey in the family? ") ;
		if (map.get("Casey") == null) {
		    System.out.println("No") ;
		}
	}
}
