package juh.datastructure.tree.traversal;

/**
 * Binary tree node.
 */
public class Node {

    Node left;
    Node right;
    Node parent;
    int value;
    
    public Node(int n) {
        this.value = n;
    }

}
