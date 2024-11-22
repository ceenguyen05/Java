// doubly linked list 
// add to the front , back , middle 
// retrieve the head , tail , and at middle 
// remove the head , tail , and at middle 

public class DoublyLinked
{
	public static void main(String [] args) {
		Linked <Integer> linkedClass = new Linked <> () ; // create an instance of the linked class 
		
		linkedClass.addFront (100) ; // add some integer data to the front of the list 
		linkedClass.addFront (50) ;
		
		linkedClass.addBack (150) ; // add some integer data to the back of the list 
		linkedClass.addBack (250) ;
		
		linkedClass.addAt (200 , 3) ; // add some integer data to the middle of the list 
		
		linkedClass.displayListFront () ; // display the doubly linked list from the front 
		linkedClass.displayListBack () ; // display the doubly linked from the back 
		
		// get the head 
		Node <Integer> currentHead = linkedClass.getHead () ;
		if (currentHead == null) {
		    System.out.println("The list is emmpty") ;
		} else {
		    System.out.println("Current Head: " + currentHead.data) ;
		}
		
		// get the tail 
		Node <Integer> currentTail = linkedClass.getTail () ;
		if (currentHead == null) {
		    System.out.println("The list is emmpty") ;
		} else {
		    System.out.println("Current Tail: " + currentTail.data) ;
		}
		
		// get at whatever index 
		Node <Integer> nodeAt = linkedClass.getAt (2) ;
		System.out.println("Node at Index 2: " + nodeAt.data) ;
		
		// get the size 
		System.out.println("LinkedList Current Size: " + linkedClass.getSize ()) ;
		
		// remove the current head 
		Node <Integer> removedHead = linkedClass.removeFront () ;
		if (removedHead == null) {
		    System.out.println("The list is emmpty") ;
		} else {
		    System.out.println ("\nRemoved Head: " + removedHead.data) ;
		}
		
		// remove the current tail 
		Node <Integer> removedTail = linkedClass.removeBack () ;
		if (removedTail == null) {
		    System.out.println("The list is emmpty") ;
		} else {
		    System.out.println ("Removed Tail: " + removedTail.data) ;
		}
		
		// remove at index 2 
		Node <Integer> removeAt = linkedClass.removeAt (2) ;
		System.out.println ("Removed Index 2: " + removeAt.data) ;
		
		
		linkedClass.displayListFront () ; // display the doubly linked list from the front 
		linkedClass.displayListBack () ; // display the doubly linked from the back 
		
		// get the head 
		currentHead = linkedClass.getHead () ;
		if (currentHead == null) {
		    System.out.println("The list is emmpty") ;
		} else {
		    System.out.println("Current Head: " + currentHead.data) ;
		}
		
		// get the tail 
		currentTail = linkedClass.getTail () ;
		if (currentHead == null) {
		    System.out.println("The list is emmpty") ;
		} else {
		    System.out.println("Current Tail: " + currentTail.data) ;
		}
		
		// get at whatever index 
		nodeAt = linkedClass.getAt (1) ;
		System.out.println("Node at Index 2: " + nodeAt.data) ;
		
		// get the size 
		System.out.println("LinkedList Current Size: " + linkedClass.getSize ()) ;
	}
}

class Node <T> {
    T data ;
    Node <T> next ;
    Node <T> prev ;
    
    Node (T data) {
        this.data = data ;
        this.next = null ;
        this.prev = null ;
    } 
}

class Linked <T> {
    private Node <T> head ;
    private Node <T> tail ;
    private int size ;
    
    Linked () {
        this.head = null ;
        this.tail = null ;
        this.size = 0 ;
    }
    
    // add to the front of the doubly linked list 
    public void addFront (T data) {
        Node <T> newNode = new Node <> (data) ; // created the new node 
        if (head == null) { // means that the list is empty
            head = tail = newNode ;
        } else { // add the newNode to an existing node 
            head.prev = newNode ; // set the current head prev to the newNode 
            newNode.next = head ; // set the next pointer to the head 
            head = newNode ; // make the newNode the head 
        }
        size ++ ; // increment no matter what 
    }
    
    // add to the back of the doubly linked list 
    public void addBack (T data) {
        Node <T> newNode = new Node <> (data) ; // created the newNode 
        if (head == null) { // if the list is empty 
            head = tail = newNode ;
        } else { // add to an existing list 
            newNode.prev = tail ; // point the newNode prev to the current tail 
            tail.next = newNode ; // point current tail next to the newNode 
            tail = newNode ; // make the newNode the tail
        }
        size ++ ; // increment the size 
    }
    
    // add anywhere in the doubly linked list 
    public void addAt (T data , int index) {
        // validate the index , index must be positive and not greater than the size of the linked list 
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException ("Invalid Index Entered.") ;
        }
        // if the index is 0 (means add to front)
        if (index == 0) {
            addFront(data) ; // call function to add to the front 
            return ; // return to exit the current function 
        }
        // if the index is the size (means add to the back) 
        if (index == size) {
            addBack(data) ; // call function to add to the back 
            return ; // return to exit the current fucntion
        }
        
        // transverse the list to a spot before where you want to add in the number 
        Node <T> newNode = new Node <> (data) ; // newNode creation 
        Node <T> current = head ; // start from the head 
        for (int count = 0 ; count < index - 1 ; count ++) { // for loop to stop a stop before index
            current = current.next ; // resets the current to the next node 
        }
        // current is now the node an index before the spot we want to add the newNode 
        Node <T> nextNode = current.next ; // this is the current node at the index we want to add newNode 
        newNode.prev = current ; // point newNode prev to the current node 
        nextNode.prev = newNode ; // point nextNode prev to newNode 
        current.next = newNode ; // point current to newNode 
        newNode.next = nextNode ; // point newNode to nextNode 
        size ++ ; // increment size 
    }
    
    // get the head of the Linked List 
    public Node <T> getHead () {
        if (head == null) {
            return head ; // if the list is empty , return null 
        }
        return head ; // return the head which has the data 
    }
    
    // get the tail of the Linked List 
    public Node <T> getTail () {
        if (tail == null) {
            return tail ; // this returns null 
        }
        return tail ; // return the tail 
    }
    
    // transverse the list from front or back to the desired index 
    public Node <T> getAt (int index) {
        // validate index 
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException ("Invalid Index Entered"); // throw error 
        }
        // transverse from the head
        Node <T> current = head ;
        for (int count = 0; count < index ; count++) {
            current = current.next;
        }
        return current ;
    }
    
    // get the size of the list 
    public int getSize () {
        return size ;
    }
    
    // remove the front of the doubly linked list 
    public Node <T> removeFront () {
        // if the list is empty 
        if (head == null) {
            return head ; // returns null 
        }
        // remove the front (head) by removing the current head 
        Node <T> removedNode = head ;
        head = head.next ; // the new head is the current head's next pointer 
        // if that was the only node (list is now empty)
        if (head == null) {
            tail = null ;
        } else {
            head.prev = null ; // head prev always to null , so change 
        }
        removedNode.next = null ; // garbage collection 
        size -- ; // decrement 
        return removedNode ;
    }
    
    // removed from the back of the doubly linked list 
    public Node <T> removeBack () {
        if (tail == null) { // if the list is empty 
            return tail ;
        }
        // remove the back by removing the tail 
        Node <T> removedNode = tail ;
        tail = tail.prev ;
        if (tail == null) { // if the list becomes empty 
            head = null ;
        } else {
            tail.next = null ;
        }
        removedNode.prev = null ; // garbage collection 
        size -- ; // decrement 
        return removedNode ; // return the removed node 
    }
    
    // remove a node from wherever in the linked list 
    public Node <T> removeAt (int index) {
        // validate index
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException ("Invalid Index Entered") ; // throw error 
        }
        // if they ask to remove the head (head is at 0)
        if (index == 0) {
            return removeFront () ; // call 
        }
        // if they ask to remove the tail (tail is at size)
        if (index == size - 1) {
            return removeBack () ; // call
        }
        // transverse to the index before 
        Node <T> current = head ;
        for (int count = 0 ; count < index - 1 ; count++) {
            current = current.next ;
        }
        Node <T> removedNode = current.next ; // removedNode is the index to the right of current 
        Node <T> nextNode = removedNode.next ; // this is the next node infront of removedNode 
        current.next = nextNode ; // point the current node to the next node over 
        if (nextNode != null) {
            nextNode.prev = current ; // if the next node isnt null 
        }
        removedNode.prev = null ; // garbage collection 
        removedNode.next = null ; // garbage collection 
        size -- ; // decrement 
        return removedNode ; // return the removed node 
    }
    
    // transverse the list and display all data starting from the front 
    public void displayListFront () {
        if (head == null) { // for empty list
            System.out.println ("The list is empty.") ;
        }
        Node <T> current = head ;
        System.out.print ("head -> ") ;
        while (current != null) {
            System.out.print (current.data + " -> ") ;
            current = current.next ;
        }
        System.out.println ("null") ; // end of the list will always point to null 
    }
    
    // transverse the list and display all data starting from the back 
    public void displayListBack () {
        if (tail == null) { // if the list is empty 
            System.out.println ("The list is empty.") ;
        }
        Node <T> current = tail ;
        System.out.print ("null <- ") ; // last node prev will be null 
        while (current != null) {
            System.out.print (current.data) ;
            current = current.prev ;
            if (current != null) {
                System.out.print(" <- ");
            }
        }
        System.out.println (" <- head") ;
    }
}
