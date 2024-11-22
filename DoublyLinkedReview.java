// doubly linked list review , no comments 

import java.util.NoSuchElementException;

public class DoublyLinkedReview 
{
	public static void main(String[] args) {
		Linked linkedClass = new Linked () ;
		linkedClass.addFront(200) ;
		linkedClass.addFront(150) ;
		linkedClass.addFront(50) ;
		linkedClass.addBack(250) ;
		linkedClass.addAt(1 , 100) ;
		linkedClass.transverse() ;
		
		System.out.println("Current Head: " + linkedClass.getHead().data) ;
		System.out.println("Current Tail: " + linkedClass.getTail().data) ;
		System.out.println("Current Value at Index 3 is: " + linkedClass.getAt(3).data) ;
		System.out.println("Current Size: " + linkedClass.getSize() + "\n") ;
		
		linkedClass.removeHead() ;
		linkedClass.removeTail() ;
		linkedClass.removeAt(1) ;
		linkedClass.addAt(1 , 155) ;
		linkedClass.transverse() ;
		
		System.out.println("Current Head: " + linkedClass.getHead().data) ;
		System.out.println("Current Tail: " + linkedClass.getTail().data) ;
		System.out.println("Current Value at Index 1 is: " + linkedClass.getAt(1).data) ;
		System.out.println("Current Size: " + linkedClass.getSize() + "\n") ;
		
	}
}

class Node {
    int data ;
    Node next ;
    Node prev ;
    
    public Node (int data) {
        this.data = data ;
        this.next = null ;
        this.prev = null ;
    }
}

class Linked {
    private int size ;
    private Node head ;
    private Node tail ;
    
    public Linked () {
        this.size = 0 ;
        this.head = null ;
        this.tail = null ;
    }
    
    public void addFront (int data) {
        Node newNode = new Node (data) ;
        if (head == null) {
            head = tail = newNode ;
        } else {
            newNode.next = head ;
            head.prev = newNode ;
            head = newNode ;
        }
        size++ ;
    }
    
    public void addBack (int data) {
        Node newNode = new Node (data) ;
        if (head == null) {
            head = tail = newNode ;
        } else {
            newNode.prev = tail ;
            tail.next = newNode ;
            tail = newNode ;
        }
        size++ ;
    }
    
    public void addAt (int index , int data) {
        if (index < 0 || index > size ) {
            throw new IndexOutOfBoundsException ("Index is out of bounds for the list") ;
        }
        
        if (index == 0) {
            addFront(data) ;
            return ;
        }
        
        if (index == size) {
            addBack(data) ;
            return ;
        }
        
        Node newNode = new Node (data) ;
        Node current = head ;
        
        for (int count = 0 ; count < index - 1 ; count++) {
            current = current.next ;
        }
        
        newNode.prev = current ;
        newNode.next = current.next ;
        
        if (current.next != null) {
            current.next.prev = newNode ;
        }
        
        current.next = newNode ;
        size++ ;
    }
    
    public Node getHead () {
        return head ;
    }
    
    public Node getTail () {
        return tail ;
    }
    
    public Node getAt (int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException ("Index is out of bounds for the list") ;
        }
        
        if (index == 0) {
            return getHead() ;
        }
        
        if (index == size - 1) {
            return getTail() ;
        }
        
        Node current = head ;
        for (int count = 0 ; count < index ; count++) {
            current = current.next ;
        }
        return current ;
    }
    
    public void removeHead () {
        if (head == null) {
            throw new NoSuchElementException("Cannot remove from an empty list.");
        }
        
        if (size == 1) {
            head = tail = null ;
            size-- ;
            return ;
        }
        
        Node removedNode = head ;
        head = head.next ;
        head.prev = null ;
        removedNode.prev = null ;
        removedNode.next = null ;
        size-- ;
    }
    
    public void removeTail () {
        if (head == null) {
            throw new NoSuchElementException("Cannot remove from an empty list.");
        }
        
        if (size == 1) {
            head = tail = null ;
            size-- ;
            return ;
        }
        
        Node removedNode = tail ;
        tail = tail.prev ;
        tail.next = null ;
        removedNode.prev = null ;
        removedNode.next = null ;
        size-- ;
    }
    
    public void removeAt (int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds for the list.") ;
        }
        
        if (index == 0) {
            removeHead() ;
            return ;
        }
        
        if (index == size - 1) {
            removeTail() ;
            return ;
        }
        
        Node current = head ;
        for (int count = 0 ; count < index - 1 ; count++) {
            current = current.next ;
        }
        
        Node removedNode = current.next ;
        current.next = current.next.next ;
        
        if (current.next != null) {
            current.next.prev = current ;
        }
        removedNode.prev = null ;
        removedNode.next = null ;
        size-- ;
    }
    
    public int getSize() {
        return size ;
    }
    
    public void transverse () {
        System.out.println("LinkedList Contents: ") ;
        Node current = head ;
        for (int count = 0 ; count < size ; count++) {
            System.out.print(current.data + " -> ") ;
            current = current.next ;
        }
        System.out.println("null\n") ;
    }
}
