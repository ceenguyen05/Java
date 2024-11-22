// this HashTable handles collisions in the same bucket by the chained method 
// which is to create a linked list on the collided K/V pairs 

public class HashTableChained
{
	public static void main(String[] args) {
	    // crete a new ChainedHashtable object 
	    ChainedHashtable <String , Integer> table = new ChainedHashtable <> (10) ;
	    
	    // add some key/value pairs , test .put function 
	    table.put("Ian" , 10) ;
	    table.put("Casey" , 19) ;
	    table.put("Claudia" , 20) ;
	    table.put("Dad" , 51) ;
	    table.put("Mom" , 51) ;
	    
	    // test the .get function 
	    System.out.println ("Ian, Age: " + table.get("Ian")) ;
	    // test the .remove function , should return null if called 
	    table.remove("Ian") ;
	    if (table.get("Ian") == null) {
	        System.out.println("Ian Has Left The Chat") ;
	    }
	    // test the transverse function 
	    // also test the linked list by adding duplicate keys and many collisions 
	    table.put("Ian" , 11) ;
	    table.put("Ian" , 10) ; // dupliate should have the same key just replaced value 
	    table.put("Erin" , 17) ;
	    table.put("Caden" , 20) ; // same has as dad, should be a linked list 
	    table.put("Lebron" , 41) ;
	    table.put("Grandma" , 65) ;
	    table.put("Grandpa" , 65) ;
	    table.put("Adrinn" , 21) ;
	    table.put("Kenneth" , 20) ;
	    table.remove("Grandpa") ; // test removing in the middle of the linked list (between casey and ken)
	    table.transverse() ;
	    
	}
}

// create an entry class 
// will store key value pairs and a next reference 
// similar to when you make a node for s doubly linked or a BST 
// templated <K , V> to get the key value of any type 
class Entry <K , V> {
    // define variables 
    K key ;
    V value ;
    Entry <K , V> next ;
    
    // constructor 
    public Entry (K key , V value) {
        this.key = key ;
        this.value = value ;
        this.next = null ;
    }
}

// create a custom hashtable 
// the hashtable will be an array of linked list 
// will be an array of Entry objects , each representing a bucket 
// similar to creating the head, tail, size of a doubly linked 
class ChainedHashtable <K , V> {
    private Entry <K , V> [] hashtable ; // array of entry objects 
    private int size ;
    
    // constructor , pass in the size of the hashtable , then create the size of the hashtable 
    public ChainedHashtable (int size) {
        this.size = size ;
        hashtable = new Entry [size] ; // initalizes the array 
    }
    
    // hash function to get the index / hash
    // whatever value goes in, it will get moduled with the size , therefore giving its bucket home 
    private int hash (K key) {
        return Math.abs(key.hashCode()) % size ;
    }
    
    // function for getting the bucket for a key and putting it in 
    // if there is already something there, will extend that bucket as a linked list 
    public void put (K key, V value) {
        // create a newEntry 
        // get the index for that key 
        Entry <K , V> newEntry = new Entry <> (key , value) ;
        int index = hash(key) ;
        
        // if no entry at the index , insert the new entry at that index 
        if (hashtable[index] == null) {
            hashtable[index] = newEntry ;
        // if there is an entry , a collision has beem detected 
        } else {
            // handle by chaining the newEntry to the current entry 
            // find the location where current is null to add the newEntry 
            Entry <K , V> current = hashtable[index] ;
            while (current != null) {
                // if the key exist , replace the value 
                // this handles where there are multiple of the same keys 
                if (current.key.equals(key)) {
                    current.value = value ;
                    return ;
                }
                // keep looping until current.next is null (to chain the new entry to the previous)
                if (current.next == null) {
                    // when current.next is null, exit the if else statement 
                    break ;
                }
                // update current and the loop starts again 
                current = current.next ; 
            }
            // when current.next is null, assign it to the newEntry 
            current.next = newEntry ;
        }
    }
    
    // create a getter function to retrieve the value from a key 
    public V get (K key) {
        // create a current entry with the current entry of the key in the hashtable 
        int index = hash(key) ;
        Entry <K , V> current = hashtable[index] ;
        // while current is not null 
        // set if the current key equals the key given 
        // if it is then return current.value (value of the key/value pair)
        // if not keep searching along the linked list 
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value ;
            }
            current = current.next ;
        }
        
        // if nothing is returned, value is not found so return null 
        return null ;
    }
    
    // create a remove function that removes an entry while updating the links after 
    public void remove (K key) {
        // get the current entry with the key 
        // get the current index 
        // create a prev entry to connect the links if it is chained 
        int index = hash(key) ;
        Entry <K , V> current = hashtable[index] ;
        Entry <K , V> prev = null ; // null to start (assume first key)
        
        // go through the links until it is null or value is found 
        while (current != null) {
            if (current.key.equals(key)) {
                // handle if it is the first node in the bucket 
                // simmply assign the next link as the current index
                if (prev == null) {
                    hashtable[index] = current.next ;
                // else update links if it is anywhere else 
                } else {
                    // point prev to the next node over, essentially breaking the link to current 
                    prev.next = current.next ;
                }
                return ;
            }
            // if key hasnt been found, update to the next 
            prev = current ;
            current = current.next ;
        }
    }
    
    // add a transverse funtion that goes through all the buckets and the keys in that bucket 
    public void transverse () {
        // go through the buckets in the array 
        for (int count = 0 ; count < size ; count++) {
            Entry <K , V> current = hashtable[count] ; // current would be each bucket 
            System.out.print("Bucket " + count + " : ") ;
            
            // go through the linked list of each bucket 
            while (current != null) {
                System.out.print("[Name: " + current.key + ", Age: " + current.value +"] --> ") ;
                current = current.next ;
            }
            // end of linked list 
            System.out.println("null.") ;
        }
    }
}
