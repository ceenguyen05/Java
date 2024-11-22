// Binary Search Tree Implementation :
// recursive formulas 
// parent node 
// transversing entire BST in order 
// searching the BST 
// inserting in BST 
// remove from a BST
// retrieve height of BST
// rebalance a tree 

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree
{
	public static void main(String[] args) {
		BST bstClass = new BST () ;
		bstClass.insert (50) ;
		bstClass.insert (20) ;
		bstClass.insert (70) ;
		bstClass.insert (10) ;
		bstClass.insert (30) ;
		bstClass.insert (60) ;
		bstClass.insert (80) ;
		bstClass.insert (75) ;
		bstClass.insert (90) ;
		bstClass.inOrderTraversal () ;
		bstClass.preOrderTraversal () ;
		System.out.println ("Removed Node " + bstClass.remove (10).data) ;
		bstClass.inOrderTraversal () ;
		bstClass.preOrderTraversal () ;
		bstClass.rebalance () ;
		System.out.print("Rebalanced BST: ") ;
		bstClass.preOrderTraversal () ;
		System.out.println("Height of BST: " + bstClass.getHeight ()) ;
	}
}

// created a node class for the BST
// has left and right child nodes , points to null to begin 
// created a parent node reference to retrieve 
class Node {
    int data ;
    Node  left ;
    Node  right ;
    Node parent ;
    
    public Node (int data) {
        this.data = data ;
        this.left = null ;
        this.right = null ;
        this.parent = null ;
    }
}

// created a BST class where the methods will be implemented
// insert , search , retrieve height, remove , transverse , and rebalance 
class BST {
    Node root ;
    
    public BST () {
        this.root = null ;
    }
    
    // insert nodes in BST 
    public void insert (int data) {
        // create your newNode 
        Node newNode = new Node (data) ;
        // if there is nothing in the BST , set the newNode to be the root 
        if (root == null) {
            root = newNode ;
        // if not, find the right place to insert the node recursivly 
        } else {
            recursiveHelper (root, newNode) ;
        }
    }
    
    // a function that recursivly calls itself until it reaches the base case 
    // base is is when a node has a spot to insert either left or right (it will be null)
    private void recursiveHelper (Node current , Node newNode) {
        // check first if the data in newNode is less than the current node 
        if (newNode.data < current.data) {
            // check if the left node is null 
            // if it is set the left node of current to the newNode 
            // then set the parent node of newNode to current 
            if (current.left == null) {
                current.left = newNode ;
                newNode.parent = current ;
            // if not null , base case isnt reached , recurse again 
            } else {
                recursiveHelper (current.left , newNode) ;
            }
        // if the newNode wasnt less than current, means it is greater than
        } else {
            // check if the right node is null
            // if it is then right node of current will be newNode 
            // parent of newNode will be current 
            if (current.right == null) {
                current.right = newNode ;
                newNode.parent = current ;
            } else {
            // if not then recurse 
                recursiveHelper (current.right , newNode) ;
            }
        }
    }
    
    // transverse the BST in order 
    public void inOrderTraversal () {
        // if root is null then BST is empty 
        if (root == null) {
            System.out.println("BST is empty") ;
        // else call the recursive helper 
        } else {
            inOrderHelper (root) ;
            System.out.println() ;
        }
    }
    
    // recursive helper for inOrderTransversal 
    private void inOrderHelper (Node current) {
        // base case is when a child is a leaf 
        if (current != null) {
            // recurses all the left nodes first 
            inOrderHelper(current.left) ; 
            System.out.print(current.data + " ") ;
            // then recurses the right nodes 
            inOrderHelper(current.right) ;
        }
    }
    
    // for preorder (root , left then right branches)
    public void preOrderTraversal () {
        // if root is empty , BST is empty 
        if (root == null) {
            System.out.println("BST is empty") ;
        // else call preOrderHelper 
        } else {
            preOrderHelper (root) ;
            System.out.println() ;
        }
    }
    
    // recursive method for preOrderTransversal
    private void preOrderHelper (Node current) {
        if (current != null) {
            // prints root first
            System.out.print(current.data + " ") ;
            // then the entire left side 
            preOrderHelper(current.left) ;
            // then the right side 
            preOrderHelper(current.right) ;
        }
    }
    
    // searching for a value in the BST 
    public void search (int value) {
        // if the root is null , BST is empty 
        if (root == null) {
            System.out.println("BST is empty") ;
        // check first if the root is the value 
        } else if (value == root.data) {
            System.out.println(value + " was found in the BST at the root") ;
        // else call the recursive helper 
        } else {
            searchHelper(value , root) ;
        }
    }
    
    // helper for search 
    private void searchHelper (int value, Node current) {
        // at the start check if the value is found in the current node 
        if (value == current.data) {
            System.out.println(value + " was found in the BST") ;
        // if not compare if it is less than the current node 
        } else if (value < current.data) {
            // if it is not null recurse 
            if (current.left != null) {
                searchHelper (value , current.left) ;
            // if null and still not found and ends up here, value isnt found 
            } else {
                System.out.println(value + " was not found in the BST") ;
            }
        // this is when value is greater than current node 
        } else {
            // if null then continue to recurse 
            if (current.right != null) {
                searchHelper(value , current.right) ;
            // if ends up here then it means current.right is null and value has not been found
            } else {
                System.out.println(value + " was not found in the BST") ;
            }
        }
    }
    
    // return the removed node 
    public Node remove (int value) {
        return removeHelper (value , root) ;
    } 
    
    // handle cases where the removed node has 0,1, or 2 children 
    private Node removeHelper (int value , Node current) {
        // if the current node is null , value is not found 
        if (current == null) {
            return null ;
        }
        // search for the node in the BST 
        if (value < current.data) {
            current.left = removeHelper(value , current.left) ;
        } else if (value > current.data) {
            current.right = removeHelper(value , current.right) ;
        } else {
            Node removedNode = current ;
            // case 1 : no children 
            if (current.left == null && current.right == null) {
                return null ;
                // case 2 : 1 child 
                } else if (current.left == null) {
                    return current.right ;
                } else if (current.right == null) {
                    return current.left ;
                // case 3 : 2 children 
                } else {
                    Node replacement = newHelper (current.right) ;
                    current.data = replacement.data ;
                    current.right = removeHelper (replacement.data , current.right) ;
                }
            return removedNode ;
        }
        return current ;
    }
    
    // helps find the left most node in the BST 
    private Node newHelper (Node current) {
        while (current.left != null) {
            current = current.left ;
        }
        return current ;
    }
    
    // get the height of the BST 
    public int getHeight () {
        return heightHelper (root) ;
    }
    
    // helper method to recurse to get height 
    private int heightHelper (Node current) {
        // if the BST is empty , height is -1 
        if (current == null) {
            return -1 ;
        }
        // get the height for the left side recursivly
        int leftHeight = heightHelper (current.left) ;
        // get the height for the right side recursivly 
        int rightheight = heightHelper (current.right) ;
        // return the highest depth of each side 
        return Math.max(leftHeight , rightheight) + 1 ;
    }
    
    // rebalance the tree 
    public void rebalance () {
        // create an array list 
        List<Integer> sortedValues = new ArrayList <> () ;
        inOrderToList(root, sortedValues) ;
        root = buildBalancedBST(sortedValues, 0, sortedValues.size() - 1);
    }
    
    private void inOrderToList(Node current, List<Integer> sortedList) {
        if (current == null) {
            return;
        }
        inOrderToList(current.left, sortedList);
        sortedList.add(current.data);
        inOrderToList(current.right, sortedList);
    }
    
    private Node buildBalancedBST(List<Integer> sortedList, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node current = new Node(sortedList.get(mid));

        // Recursively build left and right subtrees
        current.left = buildBalancedBST(sortedList, start, mid - 1);
        current.right = buildBalancedBST(sortedList, mid + 1, end);

        return current;
    }
}



