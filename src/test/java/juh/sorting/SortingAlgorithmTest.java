package juh.sorting;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import juh.sorting.algorithm.BubbleSort;
import juh.sorting.algorithm.MergeSort;
import juh.sorting.algorithm.QuickSort;

@RunWith(Parameterized.class)
public class SortingAlgorithmTest {

    private static final int MAX_INT = 100;

    private static int[] array10 = new int[10];

    private SortingAlgorithm algo;
    private String algoName;

    public SortingAlgorithmTest(SortingAlgorithm algo, String algoName) {
        this.algo = algo;
        this.algoName = algoName;
    }

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

    @Parameters(name = "{index}: testing {1}")
    public static Collection algorithms() {
        return Arrays.asList(new Object[][] {
                {new BubbleSort(), "BubbleSort"},
                {new MergeSort(), "MergeSort"},
                {new QuickSort(), "QuickSort"},
            });
    }

    @Test
    public void testSort() {
        int[] array = array10.clone();
        int[] sortedArray = algo.sort(array);
        System.out.println("Sorted array (" + algoName + "): " +
                           Arrays.toString(sortedArray));
        assertSorted(sortedArray);
    }

}
