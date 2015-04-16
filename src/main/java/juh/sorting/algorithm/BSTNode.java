package juh.sorting.algorithm;

/**
 * Binary Search Tree Node implementation.
 */
public class BSTNode {

    int key;
    BSTNode parent;
    BSTNode left;
    BSTNode right;

    public BSTNode(int key) {
        this.key = key;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    /**
     * Finds and returns the node with the given key from the subtree
     * rooted at this node.
     * Runs in O(h) time.
     */
    public BSTNode find(int key) {
        if (key == this.key) {
            return this;
        } else if (key < this.key) {
            if (this.left == null) {
                return null;
            } else {
                return this.left.find(key);
            }
        } else {
            // if key > this.key
            if (this.right == null) {
                return null;
            } else {
                return this.right.find(key);
            }
        }
    }

    /**
     * Returns the node with the smallest key in the subtree
     * rooted at this node.
     * Runs in O(h) time.
     */
    public BSTNode findMin() {
        // keep going left until a leaf is found
        BSTNode current = this;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    /**
     * Returns the node with the next larger key in the BST.
     * Runs in O(h) time.
     */
    public BSTNode successor() {
        // If current node has a right subtree, successor is the min
        // of the right subtree.
        if (this.right != null) {
            return this.right.findMin();
        }

        // Go up tree until we encounter a node that is the left child
        // of its parent (it might the current node). i.e., look for the
        // first less-than-or-equal-to relation. The successor is
        // the parent of that node.
        BSTNode current = this;
        while (current.parent != null && current == current.parent.right) {
            current = current.parent;
        }
        return current.parent;
    }

    /**
     * Inserts a node into the subtree rooted at this node.
     * Runs O(h) time.
     */
    public void insert(BSTNode node) {
        if (node == null) {
            return;
        }
        if (node.key <= this.key) {
            if (this.left == null) {
                this.left = node;
                node.parent = this;
                return;
            } else {
                this.left.insert(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
                node.parent = this;
                return;
            } else {
                this.right.insert(node);
            }
        }
    }

    /**
     * Deletes and returns this node.
     * Runs in O(1) if fewer than 2 children;
     *         O(h) if 2 children because of call to successor()
     */
    public BSTNode delete() {
        BSTNode replacement;
        if (this.left == null || this.right == null) {
            // If not a node with two children:
            // node will be replaced by whichever child exists
            if (this.left != null) {
                replacement = this.left;
            } else if (this.right != null) {
                replacement = this.right;
            } else {
                replacement = null;
            }

            if (this == this.parent.left) {
                this.parent.left = replacement;  // if left child
            } else {
                this.parent.right = replacement; // if right child
            }

            if (replacement != null) {
                replacement.parent = this.parent;
            }
            return this;
        } else {
            // If there are two children:
            // Replace with successor and delete the successor.
            // The successor is the MIN of the right subtree, meaning
            // it can have at most one child (no left child), which will
            // make its deletion the above, simpler case
            replacement = this.successor();
            this.key = replacement.key; // if value exists, copy that too
            return replacement.delete();
        }
    }

    /**
     * Checks that the BST property is satisfied.
     * Internal utility to check implementation for correctness.
     */
    void checkRepInvariant() {
        if (this.left != null) {
            //System.out.println("parent key = " + this.key + ", " +
            //                   "left key = " + this.left.key);
            if (this.key < this.left.key) {
                throw new RuntimeException(
                    "Left child's key cannot be greater than " +
                    "parent's key.");
            }
            this.left.checkRepInvariant();
        }
        if (this.right != null) {
            //System.out.println("parent key = " + this.key + ", " +
            //                   "right key = " + this.right.key);
            if (this.key > this.right.key) {
                throw new RuntimeException(
                    "Right child's key cannot be less than " +
                    "parent's key.");
            }
            this.right.checkRepInvariant();
        }
    }

}
