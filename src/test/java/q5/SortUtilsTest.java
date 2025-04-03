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

    @ParameterizedTest
    @MethodSource("provideArraysForSwap")
    public <T> void testSwap(T[] array, int i, int j, T[] expected) {
        SortUtils.swap(array, i, j);
        assertArrayEquals(expected, array);
    }

    @ParameterizedTest
    @MethodSource("provideArraysForSwap")
    public <T> void testSwapFlippedIndices(T[] array, int i, int j, T[] expected) {
        SortUtils.swap(array, j, i);
        assertArrayEquals(expected, array);
    }

    public static Stream<Arguments> provideArraysForSwap() {
        return Stream.of(
                Arguments.of(new Integer[]{1, 2, 3, 4}, 1, 2, new Integer[]{1, 3, 2, 4}),
                Arguments.of(new Integer[]{1, 2, 3, 4}, 0, 3, new Integer[]{4, 2, 3, 1}),
                Arguments.of(new Integer[]{1, 2, 3, 4}, 2, 2, new Integer[]{1, 2, 3, 4}),
                Arguments.of(new String[]{"a", "b", "c", "d"}, 0, 3, new String[]{"d", "b", "c", "a"}),
                Arguments.of(new String[]{null, "b", "c", null}, 0, 3, new String[]{null, "b", "c", null})
        );
    }
}
