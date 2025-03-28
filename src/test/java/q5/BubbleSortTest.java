package q5;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {
    private BubbleSort bubbleSort;

    @Before
    public void setUp() {
        bubbleSort = new BubbleSort();
    }

    @Test
    public void testSortEmptyArray() {
        Integer[] arr = {};
        assertArrayEquals(new Integer[]{}, bubbleSort.sort(arr));
    }

    @Test
    public void testSortSingleElementArray() {
        Integer[] arr = {1};
        assertArrayEquals(new Integer[]{1}, bubbleSort.sort(arr));
    }

    @Test
    public void testSortSortedArray() {
        Integer[] arr = {1, 2, 3, 4, 5};
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, bubbleSort.sort(arr));
    }

    @Test
    public void testSortReverseArray() {
        Integer[] arr = {5, 4, 3, 2, 1};
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, bubbleSort.sort(arr));
    }

    @Test
    public void testSortArrayWithDuplicates() {
        Integer[] arr = {3, 1, 3, 2, 2};
        assertArrayEquals(new Integer[]{1, 2, 2, 3, 3}, bubbleSort.sort(arr));
    }

    @Test
    public void testSortLargeArray() {
        Integer[] arr = new Integer[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = 1000 - i;
        }
        Integer[] sortedArr = bubbleSort.sort(arr);
        for (int i = 1; i < 1000; i++) {
            assertTrue(sortedArr[i - 1] <= sortedArr[i]);
        }
    }

    @Test
    public void testSortArrayWithOnlyTwoElements() {
        Integer[] arr = {2, 1};
        assertArrayEquals(new Integer[]{1, 2}, bubbleSort.sort(arr));
    }

    @Test
    public void testSortArrayWithIdenticalElements() {
        Integer[] arr = {1, 1, 1, 1};
        assertArrayEquals(new Integer[]{1, 1, 1, 1}, bubbleSort.sort(arr));
    }
}
