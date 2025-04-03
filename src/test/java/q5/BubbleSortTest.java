package q5;

import static org.junit.Assert.*;
import org.junit.Test;

public class BubbleSortTest {

    private BubbleSort bubbleSort = new BubbleSort();

    @Test
    public void testEmptyArray() {
        Integer[] inputArray = {};
        Integer[] expectedOutput = {};
        assertArrayEquals( expectedOutput, bubbleSort.sort(inputArray));
    }

    @Test
    public void testSingleElementArray() {
        Integer[] inputArray = {4};
        Integer[] expectedOutput = {4};
        assertArrayEquals( expectedOutput, bubbleSort.sort(inputArray));
    }

    @Test
    public void testSortedArray() {
        Integer[] inputArray = {1, 2, 3, 4, 5};
        Integer[] expectedOutput = {1, 2, 3, 4, 5};
        assertArrayEquals( expectedOutput, bubbleSort.sort(inputArray));
    }

    @Test
    public void testReverseSortedArray() {
        Integer[] inputArray = {5, 4, 3, 2, 1};
        Integer[] expectedOutput = {1, 2, 3, 4, 5};
        assertArrayEquals( expectedOutput, bubbleSort.sort(inputArray));
    }

    @Test
    public void testArrayWithDuplicates() {
        Integer[] inputArray = {3, 1, 2, 3, 1};
        Integer[] expectedOutput = {1, 1, 2, 3, 3};
        assertArrayEquals( expectedOutput, bubbleSort.sort(inputArray));
    }

    @Test
    public void testArrayWithNegativeNumbers() {
        Integer[] inputArray = {4, -2, 7, -5, 0, 3};
        Integer[] expectedOutput = {-5, -2, 0, 3, 4, 7};
        assertArrayEquals( expectedOutput, bubbleSort.sort(inputArray));
    }

    @Test
    public void testArrayWithLargeNumbers() {
        Integer[] inputArray = {1000000, 500, 200000, -10000, 999999};
        Integer[] expectedOutput = {-10000, 500, 200000, 999999, 1000000};
        assertArrayEquals( expectedOutput, bubbleSort.sort(inputArray));
    }

    @Test
    public void testUnsortedArray() {
        Integer[] inputArray = {4, 23, -6, 78, 1, 54, 23, -6, -231, 9, 12};
        Integer[] expectedOutput = {-231, -6, -6, 1, 4, 9, 12, 23, 23, 54, 78};
        assertArrayEquals( expectedOutput, bubbleSort.sort(inputArray));
    }

    @Test
    public void testStringArray() {
        String[] inputArray = {"z", "b", "c", "a"};
        String[] expectedOutput = {"a", "b", "c", "z"};
        assertArrayEquals( expectedOutput, bubbleSort.sort(inputArray));
    }
}
