package juh.sorting.algorithm;

import juh.sorting.SortingAlgorithm;

public class HeapSort implements SortingAlgorithm {

    private int[] sortList;

    /**
     * This implementation of heap sort takes n space, sorting in place.
     * It achieves this by taking advantage of the mutability of the array.
     * The implementation of MaxHeap because isn't strictly safe for use
     * out of the context of HeapSort be cause it doesn't clone the initial
     * unsorted list.
     */
    public int[] sort(int[] list) {
        this.sortList = list.clone();
        MaxHeap heap = new MaxHeap(sortList);
        for (int i = heap.size() - 1; i >= 0; i--) {
            /* Don't need to use the return value because we have a reference
               to the array (sortList) backing MaxHeap, taking advantage of
               the mutability of arrays. */
            heap.extractMax();
        }
        return sortList;
    }

    class MaxHeap {

        private int size; // data[0..size-1] make up the max heap
        private int[] data;

        /**
         * Construct a max heap from an unordered list.
         */
        MaxHeap(int[] list) {
            /* If this were an implementation of MaxHeap not specifically
               for HeapSort, this.data should be list.clone() */
            this.data = list;
            this.size = list.length;

            for (int i = size/2 - 1; i >= 0; i--) {
                heapify(i);
            }
        }

        /**
         * Returns and removes the max element of the heap,
         * and corrects the resulting violation of the max heap
         * property.
         */
        int extractMax() {
            /*
            if (size == 0) {
                throw new NoSuchElementException();
            }
            */
            int max = data[0];
            swap(0, --size); // The swap isn't necessary outside the purpose
                             // of sorting. You could just do
                             //   data[0] = data[--size]. 
                             // But this trick gives MaxHeap.data the
                             // "secret" property that it itself gets
                             // sorted with repeated calls of extractMax()
            heapify(0);
            return max;
        }

        /**
         * Corrects a single violation of the max heap property
         * at the subtree rooted at index i. Assumes that trees
         * rooted at leftChild(i) and rightChild(i) are max heaps.
         */
        void heapify(int i) {
            int largestElementIndex = i; // Assume for now

            int l = leftChild(i);
            if (l < size && data[l] > data[largestElementIndex]) {
                largestElementIndex = l;
            }

            int r = rightChild(i);
            if (r < size && data[r] > data[largestElementIndex]) {
                largestElementIndex = r;
            }

            if (largestElementIndex != i) {
                swap(i, largestElementIndex);
                heapify(largestElementIndex);
            }
        }

        private int size() { return this.size; }
        private int leftChild(int i)  { return 2*i + 1; }
        private int rightChild(int i) { return 2*i + 2; }

        private void swap(int i, int j) {
            int tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }
    }
}
