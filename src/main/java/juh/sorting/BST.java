package juh.sorting;

/**
 * Binary Search Tree implementation.
 * Most of the real work is done in BSTNode.
 */
public class BST {

    BSTNode root;
    int size;

    public BST() {
        // Empty BST is allowed
        this.root = null;
        this.size = 0;
    }

    /**
     * Finds and returns a node with the given key in the BST.
     */
    public BSTNode find(int key) {
        if (this.root == null) {
            return null;
        }
        return this.root.find(key);
    }

    /**
     * Returns the node with the smallest key in the BST.
     */
    public BSTNode findMin() {
        if (this.root == null) {
            return null;
        }
        return this.root.findMin();
    }

    /**
     * Inserts a node into the BST.
     */
    public void insert(BSTNode node) {
        if (this.root == null) {
            this.root = node;
        } else {
            this.root.insert(node);
        }
        this.size++;
    }

    /**
     * Deletes and returns a node with the given key, if it exists,
     * from the BST.
     */
    public BSTNode delete(int key) {
        BSTNode node = find(key);
        if (node == null) {
            return null;
        }

        BSTNode deletedNode;
        if (node == this.root) {
            // make root either child of a temporary root
            BSTNode tempRoot = new BSTNode(0);
            tempRoot.left = this.root;
            this.root.parent = tempRoot;

            // delete the actual root, then assign the BST root to whatever
            // has been promoted as the new root
            deletedNode = this.root.delete();
            this.root = tempRoot.left;

            // if there is a new root
            if (this.root != null) {
                this.root.parent = null;
            }
        } else {
            deletedNode = node.delete();
        }
        this.size--;
        return deletedNode;
    }

    /**
     * Checks that the BST property is satisfied.
     * Internal utility to check implementation for correctness.
     */
    private void checkRepInvariant() {
        if (root != null) {
            this.root.checkRepInvariant();
        }
    }
}
