package assignment1;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class DeterministicSelectTest {

    @Test
    void testSingleElement() {
        int[] arr = {42};
        assertEquals(42, DeterministicSelect.select(arr, 0));
    }

    @Test
    void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(1, DeterministicSelect.select(arr, 0));
        assertEquals(3, DeterministicSelect.select(arr, 2)); 
        assertEquals(5, DeterministicSelect.select(arr, 4)); 
    }

    @Test
    void testUnsortedArray() {
        int[] arr = {7, 2, 9, 4, 1, 5};
        assertEquals(1, DeterministicSelect.select(arr, 0)); 
        assertEquals(4, DeterministicSelect.select(arr, 2)); 
        assertEquals(9, DeterministicSelect.select(arr, 5));
    }

    @Test
    void testWithDuplicates() {
        int[] arr = {5, 1, 5, 2, 5, 3};
        Arrays.sort(arr);
        assertEquals(1, DeterministicSelect.select(new int[]{5,1,5,2,5,3}, 0));
        assertEquals(5, DeterministicSelect.select(new int[]{5,1,5,2,5,3}, 3));
        assertEquals(5, DeterministicSelect.select(new int[]{5,1,5,2,5,3}, 4));
    }

    @Test
    void testRandomArrayConsistency() {
        Random random = new Random(42);
        int[] arr = random.ints(100, 0, 1000).toArray();
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        for (int k : new int[]{0, 10, 50, 99}) {
            assertEquals(sorted[k], DeterministicSelect.select(arr.clone(), k));
        }
    }

    @Test
    void testInvalidK() {
        int[] arr = {1, 2, 3};
        assertThrows(IllegalArgumentException.class, () -> DeterministicSelect.select(arr, -1));
        assertThrows(IllegalArgumentException.class, () -> DeterministicSelect.select(arr, 3));
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        assertThrows(IllegalArgumentException.class, () -> DeterministicSelect.select(arr, 0));
    }
}
