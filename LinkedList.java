public class LinkedList {
    public static void main(String [] args) {
        Linked <Integer> linkedList = new Linked<>(); // Create a new linked list
        
        linkedList.addStartNode(-50) ;
        linkedList.addStartNode(-75) ;
        linkedList.addStartNode(-100) ;
        
        linkedList.addEndNode(50) ;
        linkedList.addEndNode(75) ;
        linkedList.addEndNode(100) ;
        
        linkedList.addAt(3,0) ;
        
        linkedList.printList() ;
        
        Node<Integer> head = linkedList.getHead() ; // reference to the head of the node 
        Node<Integer> tail = linkedList.getTail() ; // reference to the tail of the node
        Node<Integer> at = linkedList.getAt(4) ; // reference to the tail of the node
        System.out.println("Head Value: " + head.node) ; // head is the address , .node is the value
        System.out.println("Tail Value: " + tail.node) ; 
        System.out.println("Position 4: " + at.node) ;
        
        linkedList.removeStart() ;
        head = linkedList.getHead() ;
        linkedList.removeEnd () ;
        tail = linkedList.getTail() ;
        System.out.println("Removed Head and Tail") ;
        linkedList.printList() ;
        System.out.println("New Head Value: " + head.node) ;
        System.out.println("New Tail Value: " + tail.node) ;
        linkedList.removeAt(2) ;
        System.out.println("Removed Position 2") ;
        linkedList.printList() ;
        System.out.println("Current Size of LinkedList: " + linkedList.getSize()) ;
    }
}

// generic class for linked list 
class Node <T> {
    T node ; // creates the data for the node 
    Node<T> next ; // reference to the next node in the list 
    
    Node (T node) {
        this.node = node ; // initializes data 
        next = null ; // first next points to null 
    }
}

class Linked<T> {
    private Node<T> head ; // creates the head of the linked list 
    private Node <T> tail ; // creates a tail 
    private int size ;
    
    Linked () {
        head = null ; // inializes the head as null 
        tail = null ;
        size = 0 ;
    }
    
    public void addStartNode (T node) {
        Node<T> newNode = new Node<> (node) ; // creates a new node in the linked list 
        // if linkedlist is empty , both head and tail is the new node 
        if (head == null) {
            head = tail = newNode ;
        } else {
            newNode.next = head ; // links the newNode to the current head 
            head = newNode ; // updates the head to the new node 
        }
        size++ ;
    }
    
    public void addEndNode (T node) {
        Node<T> newNode = new Node<> (node) ; // creates a new node in the linked list 
        if (head == null) {
            head = tail = newNode ; // make the newNode the head & tail if the list is empty to start 
        } else {
            // tail is the last element, so point that to the newNode
            // make the newNode the last element 
            tail.next = newNode ;
            tail = newNode ;
        }
        size++ ;
    }
    
    public void addAt (int position , T node) {
        // error handling 
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        // if want to add at the start 
        if (position == 0) {
            addStartNode(node);
            return;
        }
        // if want to add to the end 
        if (position == size) {
            addEndNode(node);
            return;
        }
        
        Node <T> newNode = new Node <> (node) ; // create new node to add 
        Node <T> currentNode = head ; // set the current node to the head 
        
        // for loop to go get the node right before where the postion for the new node is 
        for (int count = 0 ; count < position - 1 ; count++) {
            currentNode = currentNode.next ;
        }
        // newNode next reference will point to the node currentNode is pointing to which would be 
        // the original node at position 1 
        newNode.next = currentNode.next ;
        // change the pointer of the currentNode to point to the newNode 
        currentNode.next = newNode ;
        size++ ;
    }
    
    // return the address of the head 
    public Node<T> getHead () {
        return head ;
    }
    
    // return the last item in the list 
    public Node<T> getTail () {
        return tail ;
    }
    
    // return the value given postion 
    public Node<T> getAt (int position) {
        // error handling 
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        
        Node <T> currentNode = head ; // set the current node to the head 
        
        // for loop to go get the node right before where the postion for the new node is 
        for (int count = 0 ; count < position ; count++) {
            currentNode = currentNode.next ;
        }
        return currentNode ;
    }
    
    // removes the first element in the linked list 
    public void removeStart () {
        // if the list is empty 
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        
        head = head.next ; // update the head to the next variable 
        // If the list had only one node
        if (head == null) {
            tail = null;
        }
        size-- ;
    }
    
    // removes the last element in the linked list 
    public void removeEnd () {
        // if empty 
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        
        if (head == tail) {
            head = tail = null; // list only has one element
        } else {
            Node<T> current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        size--;
    }
    
    // removes the element at the desired postion 
    public void removeAt (int position) {
        // error handling 
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        
        // if remove at 0
        if (position == 0) {
            removeStart();
            return;
        }
        
        // if remove at end 
        if (position == size - 1) {
            removeEnd();
            return;
        }
        
        Node<T> current = head ;
        // find the node before the node postion you want to remove 
        for (int count = 0 ; count < position - 1 ; count++) {
            current = current.next ;
        }
        // update the refernece of the node before the position to the next next node
        current.next = current.next.next ; 
        size-- ;
    }
    
    public int getSize () {
        return size ;
    }
    
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.node + " -> ") ;
            current = current.next;
        }
        System.out.println("null"); // Indicate the end of the list
    }
}