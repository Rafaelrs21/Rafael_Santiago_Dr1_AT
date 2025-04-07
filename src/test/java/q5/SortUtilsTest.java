package q5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SortUtilsTest {

    @Test
    public void testLess() {
        assertTrue(SortUtils.less(1, 2));
        assertFalse(SortUtils.less(2, 1));
        assertFalse(SortUtils.less(2, 2));
    }

    @Test
    public void testGreater() {
        assertTrue(SortUtils.greater(3, 2));
        assertFalse(SortUtils.greater(2, 3));
        assertFalse(SortUtils.greater(3, 3));
    }

    @Test
    public void testGreaterOrEqual() {
        assertTrue(SortUtils.greaterOrEqual(3, 2));
        assertTrue(SortUtils.greaterOrEqual(2, 2));
        assertFalse(SortUtils.greaterOrEqual(1, 2));
    }


    @Test
    public void isSortedEmptyArray() {
        Double[] emptyArray = {};
        assertTrue(SortUtils.isSorted(emptyArray));
    }

    @Test
    public void isSortedWithSingleElement() {
        Double[] singleElementArray = {1.0};
        assertTrue(SortUtils.isSorted(singleElementArray));
    }

    @Test
    public void isSortedArrayTrue() {
        Integer[] array = {1, 1, 2, 3, 5, 8, 11};
        assertTrue(SortUtils.isSorted(array));
    }

    @Test
    public void isSortedArrayFalse() {
        Double[] array = {1.0, 3.0, -0.15};
        assertFalse(SortUtils.isSorted(array));
    }

    @Test
    public void isSortedListTrue() {
        List<Integer> list = List.of(1, 1, 2, 3, 5, 8, 11);
        assertTrue(SortUtils.isSorted(list));
    }

    @Test
    public void isSortedListFalse() {
        List<Double> list = List.of(1.0, 3.0, -0.15);
        assertFalse(SortUtils.isSorted(list));
    }

    @Test
    public void testSwapIntegers() {
        Integer[] array = {1, 2, 3, 4};
        SortUtils.swap(array, 1, 2);
        assertArrayEquals(new Integer[]{1, 3, 2, 4}, array);
    }

    @Test
    public void testSwapSameIndex() {
        Integer[] array = {1, 2, 3, 4};
        SortUtils.swap(array, 2, 2);
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, array);
    }

    @Test
    public void testSwapStrings() {
        String[] array = {"a", "b", "c", "d"};
        SortUtils.swap(array, 0, 3);
        assertArrayEquals(new String[]{"d", "b", "c", "a"}, array);
    }

    @Test
    public void testSwapWithNulls() {
        String[] array = {null, "b", "c", null};
        SortUtils.swap(array, 0, 3);
        assertArrayEquals(new String[]{null, "b", "c", null}, array);
    }
}