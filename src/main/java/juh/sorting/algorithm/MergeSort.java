package juh.sorting.algorithm;

import juh.sorting.SortingAlgorithm;
import java.util.Arrays;

public class MergeSort implements SortingAlgorithm {

    public int[] sort(int[] list) {
        return mergeSort(list);
    }

    private int[] mergeSort(int[] list) {
        int len = list.length;
        if (len < 2) {
            return list;
        }

        int mid = len / 2;    // floor(len/2)
        int[] left = mergeSort(Arrays.copyOfRange(list, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(list, mid, len));
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int leftLen = left.length;
        int rightLen = right.length;
        int[] merged = new int[leftLen + rightLen];

        int i = 0, l = 0, r = 0;
        while (l < leftLen && r < rightLen) {
            merged[i++] = (left[l] <= right[r]) ? left[l++] : right[r++];
        }
        while (l < leftLen) {
            merged[i++] = left[l++];
        }
        while (r < rightLen) {
            merged[i++] = right[r++];
        }
        return merged;
    }
}
