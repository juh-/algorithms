package juh.sorting.algorithm;

import juh.sorting.SortingAlgorithm;

public class QuickSort implements SortingAlgorithm {

    private int[] a;

    public int[] sort(int[] list) {
        this.a = list;
        quickSort(0, a.length - 1);
        return a;
    }

    private void quickSort(int start, int end) {
        if (start < end) {
            int p = partition(start, end);
            quickSort(start, p-1);
            quickSort(p+1, end);
        }
    }

    private int partition(int start, int end) {
        // for convenience, pick the rightmost element as the pivot
        int pivotIdx = end;
        int pivotVal = a[pivotIdx];

        // the index 'left' corresponds to the rightmost element
        // that is less than or equal to the pivotVal
        int left = start - 1;
        for (int right = start; right < end; right++) {
            if (a[right] <= pivotVal) {
                left++;
                swap(left, right);
            }
        }
        swap(left + 1, pivotIdx);
        return left + 1;
    }

    private void swap(int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
