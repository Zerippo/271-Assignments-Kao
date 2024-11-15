/**
 * A simple binary search tree
 */
public class BST {
    /** The entry point to the tree */
    private TreeNode root;
    /** Count of nodes in the tree */
    private int numberOfNodes;
    /** Longest and shortest words stored in the tree */
    private String longest;
    private String shortest;

    /** Default constructor */
    public BST() {
        this.root = null;
        this.numberOfNodes = 0;
        this.shortest = null;
        this.longest = null;
    } // default constructor

    /**
     * Overloaded add to take a string, wrap it into a TreeNode object, and invoke
     * the principal method that adds a note to the tree.
     * 
     * @param word String to add, as a node, to the tree
     * 
     */
    public void add(String word) {
        this.add(new TreeNode(word));
    } // method add

    /**
     * Insert a new node into the tree; the method takes no action if a node with
     * the same payload already exists in the tree.
     * 
     * @param newNode node to insert
     */
    public void add(TreeNode newNode) {
        if (this.root == null) {
            this.root = newNode;
            this.numberOfNodes = 1;
            this.shortest = newNode.getWord();
            this.longest = newNode.getWord();
        } else {
            TreeNode cursor = this.root;
            TreeNode parent = null;
            boolean duplicate = false;
            while (cursor != null && !duplicate) {
                parent = cursor;
                duplicate = newNode.compareTo(cursor) == 0;
                if (newNode.compareTo(cursor) < 0) {
                    cursor = cursor.getLeft();
                } else {
                    cursor = cursor.getRight();
                }
            }
            // The while loop ends when it finds a spot for the new node or when discovering
            // a duplicate entry. If there is a duplicate entry, there will be no insertion.
            if (!duplicate) {
                if (newNode.compareTo(parent) < 0) {
                    parent.setLeft(newNode);
                } else {
                    parent.setRight(newNode);
                }
                // Update the number of nodes in the tree
                this.numberOfNodes++;
                // Check if new node contains a string longer than the longest string
                if (newNode.getWord().length() > this.longest.length()) {
                    this.longest = newNode.getWord();
                }
                // Check if new node has a string shorter than the shortest string
                if (newNode.getWord().length() < this.shortest.length()) {
                    this.shortest = newNode.getWord();
                }
            }
        }
    } // method add

    /**
     * In order traversal of a tree
     * 
     * @return a String[] with the contents of the tree as they appear
     */
    public void traverseInOrder(TreeNode node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            System.out.println(node.getWord());
            traverseInOrder(node.getRight());
        }
    } // method traverseInOrder

    /**
     * Helper method to start in-order traversal
     */
    public void traverseInOrder() {
        if (this.root != null) {
            this.traverseInOrder(this.root);
        }
    } // helper method traverseInOrder

    /**
     * Helper method that initiates removal of a node with a specific string. The
     * method calls an overloaded version of itself to do the actual digging. The
     * overloaded method can focus on the tree itself (starting from this.root) or
     * any subtree thereof.
     * 
     * @param target string contents of node we wish to remove
     * @return the removed node; if no node found, method returns null
     */
    public TreeNode remove(String target) {
        TreeNode removed = null;
        if (target != null && this.root != null) {
            removed = this.remove(target, this.root);
        }
        return removed;
    } // helper method remove

    /**************************************************************************
     * METHOD STUBS FOR ASSIGNMENT DUE 11/15/24. THESE METHODS ARE INCOMPLETE AND,
     * OBVIOUSLY, LACK DOCUMENTATION. AS PART OF THE ASSIGNMENT, YOU'LL PROVIDE THE
     * NECESSARY COMMENTS AND, OF COURSE, SOME AWESOME CODE.
     **************************************************************************/

    public boolean contains(String target) {
        boolean found = false;
        TreeNode current = this.root;
        
        while (current != null && !found) {
            if (current.getWord().equals(target)) {
                found = true;
            } else if (target.compareTo(current.getWord()) < 0) {
                current = current.getLeft(); // go left child if the target is less than the current node
            } else if (target.compareTo(current.getWord() > 0) {
                current = current.getRight(); // goes to the right child if the word is greater than the current word
            }
        }

        return found;
    } // method contains

    public String toString() {
        String result = "";
        if (root != null){
            result ++ "The root is: " + this.root.getWord() + "\n";
            result ++ "Number of nodes: " + this.numberOfNodes + "\n";"
            result ++ "In-order traversal: \n";
            this.traverseInOrder();
        }
        else {
            result ++ "The tree is empty.";
        }
        
        return result;
    } // method toString

    public TreeNode remove(String target, TreeNode belowNode) {            
        TreeNode cursor = root;
        TreeNode parent = null;
        Boolean found = false;

            
        while(current != null && !found){
            parent = current;
            if(current.getWord().equals(target))
                found == true;
            if(target.compareTo(current.getWord()) < 0){
                current = current.getLeft();
            } else(target.compareTo(current.getWord()) > 0){
                current = current.getRight();
            } 
        }// traverses the tree to find the node to remove
    
            
        if (cursor.countChildren() == 0){
            if (parent.hasLeft())
                parent.getLeft() = null;
            else
                parent.getRight() = null;
            
        } else if (cursor.countChildren() == 1){
            if (parent.getLeft().equals(target)){
                if (cursor.getLeft() != null){ // deletes the left left
                    parent.getLeft() = cursor.getLeft();
                    cursor.getLeft() = null;
                }
                else { // deletes the right left
                    parent.getLeft() = cursor.getRight();
                    cursor.getRight() = null;
                }
            } else { //deletes the left right
                if (cursor.getLeft() != null){
                    parent.getRight() = cursor.getLeft();
                    cursor.getLeft() = null;
                } else { // deletes the right right
                    parent.getRight() = cursor.getRight();
                    cursor.getRight() = null;
                }
            }
            
            
        } else {

            TreeNode successor = cursor.getRight();
            while (successor.hasLeft()){
                successor = successor.getLeft();
            }//now has the leftmost word of the right side

            cursor.setWord(successor.getWord()); //sets the cursor to the next value
            remove(successor.getWord(), cursor.getRight()); //removes the successor

        }
        
        
        return cursor;
    } // method remove

    /******************************* Accessors *******************************/

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public String getLongest() {
        return longest;
    }

    public String getShortest() {
        return shortest;
    }
} // class BST
