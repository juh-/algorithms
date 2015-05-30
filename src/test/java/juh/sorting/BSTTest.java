package juh.sorting;

import org.junit.Assert;
import org.junit.Test;

public class BSTTest {

    private static void fill(BST tree, int[] list) {
        for (int i : list) {
            tree.insert(new BSTNode(i));
        }
    }

    private static void assertRepInvariantSatisfied(BST tree) {
        assertRepInvariantSatisfied(tree.root);
    }

    private static void assertRepInvariantSatisfied(BSTNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            //System.out.println("parent key = " + node.key + ", " +
            //                   "left key = " + node.left.key);
            if (node.key < node.left.key) {
                Assert.fail(
                    "Left child's key cannot be greater than " +
                    "parent's key.");
            }
            assertRepInvariantSatisfied(node.left);
        }
        if (node.right != null) {
            //System.out.println("parent key = " + node.key + ", " +
            //                   "right key = " + node.right.key);
            if (node.key > node.right.key) {
                Assert.fail(
                    "Right child's key cannot be less than " +
                    "parent's key.");
            }
            assertRepInvariantSatisfied(node.right);
        }
    }

    @Test
    public void testInsert() {
        BST bst = new BST();
        fill(bst, new int[]{3, 5, 1, 2, 5, 10});
        assertRepInvariantSatisfied(bst);
        Assert.assertEquals(6, bst.size);
    }

    @Test
    public void testFindMin() {
        BST bst = new BST();
        fill(bst, new int[]{3, 5, 1, 2, 5, 10});
        Assert.assertEquals(1, bst.findMin().key);
    }

    @Test
    public void testFind() {
        BST bst = new BST();
        fill(bst, new int[]{3, 5, 1, 2, 5, 10});
        Assert.assertEquals(2, bst.find(2).key);

        Assert.assertNull(bst.find(100));
    }

    @Test
    public void testSuccessor() {
        BST bst = new BST();
        fill(bst, new int[]{3, 5, 1, 2, 5, 10});
        Assert.assertEquals(3, bst.find(2).successor().key);
    }

    @Test
    public void testDelete() {
        BST bst = new BST();
        fill(bst, new int[]{3, 5, 1, 2, 5, 10});
        Assert.assertNull(bst.delete(100));
        Assert.assertEquals(6, bst.size);

        // start with root
        bst.delete(3);
        assertRepInvariantSatisfied(bst);

        bst.delete(10);
        assertRepInvariantSatisfied(bst);

        bst.delete(1);
        assertRepInvariantSatisfied(bst);

        bst.delete(2);
        assertRepInvariantSatisfied(bst);

        bst.delete(5);
        assertRepInvariantSatisfied(bst);

        bst.delete(5);
        assertRepInvariantSatisfied(bst);

        Assert.assertEquals(0, bst.size);
    }
}
