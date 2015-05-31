package juh.datastructure.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Performs the in-order traversal of a binary tree.
 */
public class InorderTraverser {

    // For testing purposes only
    public static List<Integer> traversedOrder = new ArrayList<>();

    public static void traverse(Node root) {
        Node current = root;
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            if (stack.isEmpty()) {
                break;
            }

            current = stack.pop();
            process(current);
            current = current.right;
        }
    }

    private static void process(Node node) {
        traversedOrder.add(node.value);
        //System.out.println(node.value);
    }
}
