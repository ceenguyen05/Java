// HashTable but with the linear probing collision implementation


public class HashTableLinearProbed
{
	public static void main(String[] args) {
		HashTable <String , Integer> table = new HashTable <> (5) ; // new hashtable object 
		
		// add some objects in hashtable 
		table.put("Claudia" , 20) ;
		table.put("Ian" , 10) ;
		table.put("Mom" , 51) ;
		table.put("Dad" , 51) ;
		
		// test remove function 
		table.remove("Claudia") ;
		
		// test .get function
		System.out.println("Mom's Age is " + table.get("Mom")) ;
		
		// dislay the hashtable, should be full 
		table.transverse() ;
		
		// display the current size of the hashtable 
		System.out.println("Current Size: " + table.getSize()) ;
		
		// throw exception when hashtable is full 
		table.put("won" , 100) ;
		table.put("lost" , 00) ;
		table.put("GG" , 10000) ;
	
	}
}

// entry nodes  with a next reference 
class Entry <K , V> {
    K key ;
    V value ;
    boolean beenDeleted ;
    
    // constructor that gets the key and value from user 
    // next always set to null as new nodes are inserted at the end 
    public Entry (K key , V value) {
        this.key = key ;
        this.value = value ;
        this.beenDeleted = false ;
    }
}

class HashTable <K , V> {
    private Entry <K , V> [] hashtable ; // create an array of Entry objects 
    private int size ;
    private int currentSize ;
    
    // initialize the size and assign the size to the array 
    public HashTable (int size) {
        this.size = size ; 
        this.currentSize = 0 ;
        this.hashtable = new Entry [size] ; // initalizes the Entry Object arrays 
    }
    
    // get the hash of a key
    // key.hashCode generates a random number for that key 
    // Math.abs makes sure its a positive number 
    // returns the index of the hash
    private int hash (K key) {
        return Math.abs(key.hashCode()) % size ;
    }
    
    // .put function 
    public void put (K key , V value) {
        
        int index = hash(key) ; // get the index for the current key 
        int originalIndex = index ; // where we start our search
        
        // linear probing algorithm 
        // first check is if the index is not null 
        // second check is if the key at that index is not the same as the key we have (same keys)
        // third check is if the index has been deleted, if beenDeleted is false, loop 
        while (hashtable[index] != null && !hashtable[index].key.equals(key) 
        && !hashtable[index].beenDeleted) {
            // updates the index with the next index over
            // if it excedes size , % ensures it gets wrap 
            index = (index + 1) % size ; 
            
            if (index == originalIndex) {
                throw new IllegalStateException("Hashtable is full");
            }
        }
        
        // at this point the index slot will be null or is it has been deleted 
        // or is the same key as something in the hashtable 
        // update the index with the new entry 
        if (hashtable[index] == null || hashtable[index].beenDeleted) {
            hashtable[index] = new Entry <> (key , value) ;
            currentSize++ ; // update the current size of the hashtable 
        // this is if the keys are the same 
        } else {
            hashtable[index].value = value ; // update the same keys with the new value 
        }
    }
    
    // .get function 
    public V get (K key) {
        int index = hash(key) ;
        int originalIndex = index ;
        
        // loop continues while an entry is not null 
        // if it is null then the key is not found in the hashtable 
        while (hashtable[index] != null) {
            // if the key from the index is the key we are looking for 
            // if it hasnt been deleted as well 
            // then return the value 
            // if it has been deleted , then result of that key is null
            if (hashtable[index].key.equals(key) && !hashtable[index].beenDeleted) {
                return hashtable[index].value;
            }
            // if not then update the index 
            // if the index is back to the original, value is not found and break from loop
            index = (index + 1) % size;
            if (index == originalIndex) {
                break;
            }     
        }
        return null ; // at this point value is not found, return null 
    }
    
    // .remove function 
    public void remove (K key) {
        int index = hash(key) ;
        int originalIndex = index ;
        
        // search the indexes while each index in order is not null 
        while (hashtable[index] != null) {
            // check if the key is at the index and if it has been deleted 
            // if it is the key and it has not been deleted , remove that entry by marking it deleted 
            if (hashtable[index].key.equals(key) && !hashtable[index].beenDeleted) {
                hashtable[index].beenDeleted = true ;
                currentSize-- ;
                return ; // exit the loop
            }
            
            // if the conditions are not met, update the index and keep searching 
            index = (index + 1) % size ; 
            
            // if the index and original index are the same, you have searched every entry in the HT 
            if (index == originalIndex) {
                System.out.println("Key not found in Hash Table.") ;
                break ; // exit the function , value not found 
            }
        }
    }
    
    // get the currentsize of the hashtable 
    public int getSize () {
        return currentSize ;
    }
    
    // .transverse function 
    public void transverse () {
        for (int count = 0 ; count < size ; count++) {
            if (hashtable[count] != null && !hashtable[count].beenDeleted) {
                System.out.println("Bucket " + count + " -> Name: " + hashtable[count].key + 
                ", Age: " + hashtable[count].value) ;
            } else {
                if (hashtable[count] == null) {
                    System.out.println("Bucket " + count + " -> null, always empty") ;
                } else {
                    System.out.println("Bucket "+ count + " -> null, been deleted") ;
                }
            }
        }
    }
}
