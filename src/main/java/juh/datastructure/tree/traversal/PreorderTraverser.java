package juh.datastructure.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Performs the pre-order traversal of a binary tree.
 */
public class PreorderTraverser {

    // For testing purposes only
    public static List<Integer> traversedOrder = new ArrayList<>();

    public static void traverse(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        Node current;
        while (!stack.isEmpty()) {
            current = stack.pop();
            process(current);
            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    private static void process(Node node) {
        traversedOrder.add(node.value);
        //System.out.println(node.value);
    }
}
