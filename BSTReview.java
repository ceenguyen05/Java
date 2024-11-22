// Binary Search Tree Review 
// no comments 

public class BSTReview
{
	public static void main(String[] args) {
		BST bstClass = new BST () ;
		bstClass.add(50) ;
		bstClass.add(30) ;
		bstClass.add(70) ;
		bstClass.add(20) ;
		bstClass.add(40) ;
		bstClass.add(60) ;
		bstClass.add(80) ;
		bstClass.inOrderTraversal() ;
		System.out.println("Current Root: " + bstClass.getRoot().value) ;
		System.out.println("Find value 30 if it exists: " + bstClass.search(30)) ;
		System.out.println("Remove value 60 if it exists: " + bstClass.remove(60)) ;
		bstClass.inOrderTraversal() ;
	}
}

class Node {
    int value ;
    Node left ;
    Node right ;
    Node parent ;
    
    public Node (int value) {
        this.value = value ;
        this.left = null ;
        this.right = null ;
        this.parent = null ;
    }
}

class BST {
    private Node root ;
    
    public BST () {
        this.root = null ;
    }
    
    public Node getRoot () {
        return root ;
    }
    
    public void add(int value) {
        Node newNode = new Node (value) ;
        if (root == null) {
            root = newNode ;
            return ;
        }
        addHelper (root , newNode) ;
    }
    
    private void addHelper (Node current , Node newNode) {
        if (newNode.value < current.value) {
            if (current.left == null) {
                current.left = newNode ;
                newNode.parent = current ;
            } else {
                addHelper(current.left , newNode) ;
            }
        } else {
            if (current.right == null) {
                current.right = newNode ;
                newNode.parent = current ;
            } else {
                addHelper(current.right , newNode) ;
            }
        }
    }
    
    public Node search(int value) {
        if (root == null) {
            return root ;
        } 
        
        if (root.value == value) {
            return root ;
        }
        
        return searchHelper(value , root) ;
    }
    
    private Node searchHelper(int value , Node current) {
        if (current.value == value) {
            return current ;
        }
        
        if (value < current.value) {
            if (current.left != null) {
                return searchHelper(value , current.left) ;
            } else {
                return null ;
            }
        } else {
            if (current.right != null) {
                return searchHelper(value , current.right) ;
            } else {
                return null ;
            }
        }
    }
    
    public Node remove (int value) {
        // store the removed node to return 
        Node removedNode = removeHelper (value , root , null) ;
        return removedNode ;
    }
    
    private Node removeHelper (int value , Node current , Node parent) {
        // if the current is null , than the value is not found in BST
        if (current == null) {
            return current ;
        }
        
        // set parent reference 
        current.parent = parent ;
        
        // search for the value in the BST
        // if value is less than current , search along the left subtree
        // if value is greater than current , search along the right subtree 
        // if the value is found , handle that nodes childs 
        if (value < current.value) {
            return removeHelper (value , current.left , current) ;
        } else if  (value > current.value) {
            return removeHelper (value , current.right , current) ;
        } else {
            // handle the case where the removed node has no children 
            if (current.left == null && current.right == null) {
                if (parent != null ) {
                    if (parent.left == current) {
                        parent.left = null ;
                    } else {
                        parent.right = null ;
                    }
                }
                // garbage collection 
                current.parent = null ;
                return current ;
            // handle if there is one left child 
            } else if  (current.left != null && current.right == null) {
                if (parent != null) {
                    if (parent.left == current) {
                        parent.left = current.left ;
                    } else {
                        parent.right = current.left ;
                    }
                }
                
                // handle the case where the left child isnt null 
                if (current.left != null) {
                    current.left.parent = parent ;
                }
                
                // garbage collection
                current.parent = null ;
                current.left = null ;
                current.right = null ;
                return current ;
            // handle if there is one right child 
            } else if (current.left == null && current.right != null) {
                if (parent.left == current) {
                    parent.left = current.right ;
                } else {
                    parent.right = current.right ;
                }
                
                // if the right child is not null 
                if (current.right != null) {
                    current.right.parent = parent ;
                }
                
                // garbage collection 
                current.parent = null ;
                current.left = null ;
                current.right = null ;
                return current ;
            // if both children are present 
            } else {
                // find the replacement node , go once right and then left until null
                Node replacement = findLeast(current.right) ;
                
                // for the root 
                if (parent == null) {
                    root = replacement ;
                // find which side current is on 
                } else if (parent.left == current) {
                    parent.left = replacement ;
                } else {
                    parent.right = replacement ;
                }
                
                // remove the replacement node from its OG spot 
                removeHelper (replacement.value , replacement.right , replacement) ;
                
                // update links 
                replacement.parent = parent ;
                replacement.left = current.left ;
                replacement.right = current.right ;
                
                // update children references 
                if (replacement.left != null) {
                    replacement.left.parent = replacement ;
                }
                
                if (replacement.right != null) {
                    replacement.right.parent = replacement ;
                }
                
                // garbage collection 
                current.parent = null ;
                current.left = null ;
                current.right = null ;
                return current ;
            }
        }
    }
    
    private Node findLeast (Node current) {
        while (current.left != null) {
            current = current.left ;
        }
        return current ;
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
            System.out.print(current.value + " ") ;
            // then recurses the right nodes 
            inOrderHelper(current.right) ;
        }
    }
}



