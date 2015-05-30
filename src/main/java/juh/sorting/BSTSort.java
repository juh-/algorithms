package juh.sorting;

import java.util.ArrayList;
import java.util.List;

public class BSTSort implements SortingAlgorithm {

    /**
     * Construct a BST from the unordered array and retrieves elements
     * in sorted order by doing an in-order traversal.
     */
    public int[] sort(int[] list) {
        // Contruct a BST
        BST bst = new BST();
        for (int i : list) {
            bst.insert(new BSTNode(i));
        }

        // Fill list in sorted order
        List<Integer> sortedList = new ArrayList<>();
        toInorderList(bst.root, sortedList);

        // Convert List<Integer> to int[]
        int length = sortedList.size();
        int[] sortedArray = new int[length];
        for (int i = 0; i < length; i++) {
            sortedArray[i] = sortedList.get(i);
        }

        return sortedArray;
    }

    /**
     * Does an in-order traversal of the BST rooted at the given node,
     * and appends the keys to the list. The list will be filled in
     * sorted order.
     */
    private void toInorderList(BSTNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        toInorderList(node.left, list);
        list.add(node.key);
        toInorderList(node.right, list);
    }
}
