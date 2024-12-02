// Automated Grading System
// Allows input in the form of grades 
// Implemented as a doubly linked list 
// Able to sort , find the median and mean 
// display all the grades from lowest to highest 
// linked list abilites are just to add and get value after sort nothing special 

public class AutomatedGradingSystem
{
	public static void main(String[] args) {
		Doubly doublyClass = new Doubly () ;
		doublyClass.add (60) ;
		doublyClass.add (58) ;
		doublyClass.add (55) ;
		doublyClass.add (57) ;
		doublyClass.add (60) ;
		doublyClass.add (58) ;
		doublyClass.add (57) ;
		doublyClass.add (55) ;
		doublyClass.add (54) ;
		doublyClass.add (59) ;
		doublyClass.selectionSort () ;
		doublyClass.display () ;
		doublyClass.median () ;
		doublyClass.mean () ;
	}
}

class Node {
    public int data ;
    public Node next ;
    public Node prev ;
    
    public Node (int data) {
        this.data = data ;
        this.next = null ;
        this.prev = null ;
    }
}

class Doubly {
    private Node head ;
    private Node tail ;
    private int size ;
    
    public Doubly () {
        this.head = null ;
        this.tail = null ;
        this.size = 0 ;
    }
    
    // add a value to the linked list 
    public void add (int data) {
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
    
    // sort the linked list from smallest to largest 
    public void selectionSort () {
        // run through the linked lis until it hits null (the end ) , start with the head 
        for (Node current = head ; current != null ; current = current.next) {
            Node min = current ; // get the current node to check and sort spot 
            
            // get the next node and compare the entire rest of the linked, 
            // set the min to the lowest value found
            for (Node temp = current.next ; temp != null ; temp = temp.next) {
                if (temp.data < min.data) {
                    min = temp ;
                }
            }
            // swap the current node with the node we found to be the smallest
            if (min != current) {
                int temp = current.data ;
                current.data = min.data ;
                min.data = temp ;
            }
        }
    }
    
    public void median () {
        int mid = size / 2 ;
        Node current = head ;
        for (int count = 0 ; count < mid ; count++) {
            current = current.next ;
        }
        System.out.println("Median Score: " + current.data) ;
    }
    
    public void mean () {
        int scores = 0 ;
        Node current = head ;
        for (int count = 0 ; count < size ; count++) {
            scores += current.data ;
            current = current.next ;
        }
        double mean = (double)(scores/size) ;
        String newMean = String.format("%.2f" , mean) ;
        System.out.println("Mean: " + newMean) ;
    }
    
    // display the linked list 
    public void display () {
        Node current = head ;
        System.out.println("Midterm Test Resuts:") ;
        while (current != null) {
            System.out.print(current.data + " ") ;
            current = current.next ;
        }
        System.out.println() ;
    }
}



