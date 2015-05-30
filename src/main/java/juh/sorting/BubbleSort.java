package juh.sorting;

import java.util.Arrays;

public class BubbleSort implements SortingAlgorithm {

    public int[] sort(int[] list) {
        int len = list.length;
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int n = 0; n < len-1; n++) {
                if (list[n] > list[n+1]) {
                    int tmp = list[n];
                    list[n] = list[n+1];
                    list[n+1] = tmp;
                    swap = true;
                }
            }
        }
        return list;
    }

}
