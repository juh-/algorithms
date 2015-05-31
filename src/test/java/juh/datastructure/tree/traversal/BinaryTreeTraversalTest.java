package juh.datastructure.tree.traversal;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinaryTreeTraversalTest {

    private static Node root;
    private static final List<Integer> INORDER =
        Arrays.asList(1, 30, 31, 35, 38, 50, 51, 70, 80);
    private static final List<Integer> PREORDER =
        Arrays.asList(50, 30, 1, 35, 31, 38, 70, 51, 80);

    /* Initializes this tree:
     *
     *              50
     *            /    \
     *         30       70
     *       /   \     /   \
     *     1     35   51    80
     *         /   \
     *        31    38
     */
    @BeforeClass
    public static void initTree() {
        Node n50 = new Node(50);
        Node n30 = new Node(30);
        Node n70 = new Node(70);
        Node n1 = new Node(1);
        Node n35 = new Node(35);
        Node n51 = new Node(51);
        Node n80 = new Node(80);
        Node n31 = new Node(31);
        Node n38 = new Node(38);

        n50.left = n30; n50.right = n70;
        
        n30.left = n1; n30.right = n35; n70.left = n51; n70.right = n80;

        n35.left = n31; n35.right = n38;

        root = n50;
    }

    @Test
    public void testInorderTraversal() {
        InorderTraverser inorderTraverser = new InorderTraverser();
        inorderTraverser.traverse(root);
        Assert.assertEquals(INORDER,
                            inorderTraverser.traversedOrder);
    }

    @Test
    public void testPreorderTraversal() {
        PreorderTraverser preorderTraverser = new PreorderTraverser();
        preorderTraverser.traverse(root);
        Assert.assertEquals(PREORDER,
                            preorderTraverser.traversedOrder);
    }
}
