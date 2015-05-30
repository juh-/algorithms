package juh.sorting.algorithm;

/**
 * Implementation of Counting Sort.
 *
 * This class does not implement the SortingAlgorithm interface,
 * which is really meant for comparison sort algorithms. Counting
 * Sort is NOT a comparison sort algorithm, and when k = O(n),
 * Counting Sort runs in linear O(n) time. [Add up the time
 * complexities of each of the for loops in search() and you get
 * O(2n + k) = O(n + k) time, which is O(n) if k = O(n).]
 *
 * Counting Sort is fast because it assumes something about the
 * input: that the input consists of integers in a small range.
 *
 * Note that the sort method requires an extra parameter for
 * Counting Sort.
 */
public class CountingSort {

    /**
     * The sort method takes an array 'a' of n integers, which are in
     * the range 0, ..., k - 1
     */
    public int[] sort(int[] a, int k) {
        // create a counter array
        int[] counter = new int[k];

        // set counter[x] = number of elements equal to x in array 'a'
        for (int i = 0; i < a.length; i++) {
            counter[a[i]]++;
        }

        // set counter[x] = number of elements less than or equal to
        // x in array 'a'
        for (int i = 1; i < k; i++) {
            counter[i] += counter[i-1];
        }

        int[] sorted = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            // Place a[i] at the highest possible index in sorted array.
            // This preserves the ordering and makes it a stable sort.
            // Remember to decrement first because it's a 0-indexed array.
            sorted[--counter[a[i]]] = a[i];
        }

        return sorted;
    }
}
