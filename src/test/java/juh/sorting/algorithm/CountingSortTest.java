package juh.sorting.algorithm;

import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import juh.sorting.algorithm.CountingSort;

public class CountingSortTest {

    private static final int MAX_INT = 100;

    private static int[] array10 = new int[10];

    @BeforeClass
    public static void initArray() throws Exception {
        fill(array10);
    }

    private static void fill(int[] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(MAX_INT) + 1;
        }
        System.out.println("Random test array: " + Arrays.toString(array));
    }

    private static void assertSorted(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] > list[i+1]) {
                Assert.fail("array not sorted");
            }
        }
    }

    @Test
    public void testCountingSort() {
        int[] array = array10.clone();
        CountingSort algo = new CountingSort();
        int[] sortedArray = algo.sort(array, MAX_INT);
    }

}
