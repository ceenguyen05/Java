
public class SinglyLinked
{
	public static void main(String[] args) {
		Linked <Integer> linkedList = new Linked <> () ;
		linkedList.addFirst(10) ;
		linkedList.addLast (1000) ;
		linkedList.addLast (10000) ;
		linkedList.addAt (1,100) ;
		linkedList.display() ;
	}
}

class Node <T> {
    T data ;
    Node <T> next ;
    
    Node (T data) {
        this.data = data ;
        next = null ;
    }
}

class Linked <T> {
    private Node <T> head ;
    private Node <T> tail ;
    private int size ;
    
    Linked () {
        head = null ;
        tail = null ;
        size = 0 ;
    }
    
    public void addFirst (T data) {
        Node newNode = new Node <> (data) ;
        if (head==null) {
            head = tail = newNode ;
        } else {
            newNode.next = head ;
            head = newNode ;
        }
        size++ ;
    }
    
    public void addLast (T data) {
        Node newNode = new Node <> (data) ;
        if (head == null) {
            head = tail = newNode  ;
        } else {
            tail.next = newNode ;
            tail = newNode ;
        }
        size++ ;
    }
    
    public void addAt (int position, T data) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid Position") ;
        } else if (position == 0) {
            addFirst(data) ;
        } else if (position == size) {
            addLast(data) ;
        } else {
            Node <T> newNode = new Node <> (data) ;
            Node <T> current = head ;
            
            for (int count = 0 ; count < position - 1 ; count++) {
                current = current.next ;
            }
            newNode.next = current.next ;
            current.next = newNode ;
        }
        size++ ;
    }
    
    public void display () {
        Node <T> current = head ;
        while (current != null) {
            System.out.print(current.data + " -> ") ;
            current = current.next ;
        }
        System.out.println("null") ;
    }
}