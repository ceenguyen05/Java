import java.util.Scanner ;

public class Box
{
	public static void main(String[] args) {
		System.out.println("Hello World") ;
	}
}

// generic class T 
class BoxClass <T> {
    // private membe variables 
    private T item ;
    
    // constructor , places an item in the box 
    BoxClass (T item) {
        this.item = item ;
    }
    
    // getter , gets item from box 
    public T getItem () {
        return item ;
    }
    
    // checks if box is empty 
    public boolean isEmpty () {
        return item == null ; // if it is empty , return true 
    }
    
    // clear rhe box 
    public void clear () {
        item = null ;
    }
}