package q2;

import net.jqwik.api.*;
import net.jqwik.api.arbitraries.ArrayArbitrary;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MathFunctionsTest {

    private MathLogger mathLogger;

    @BeforeEach
    public void setUp() {
        mathLogger = mock(MathLogger.class);
    }

    @Property
    public void multiplyByTwoAlwaysReturnsEven(@ForAll int number) {
        int result = MathFunctions.MultiplyByTwo(number);
        assertTrue(result % 2 == 0);

    }

    @Property
    public void generateMultiplicationTableElementsAreMultiples() {
        int number = 5;
        int limit = 10;

        int[] table = MathFunctions.GenerateMultiplicationTable(number, limit);

        for (int value : table) {
            assertTrue(value % number == 0 );
        }
    }

    @Property
    public void isPrimeHasNoDivisorsOtherThanOneAndItself(@ForAll int number) {
        if (number > 1 && MathFunctions.IsPrime(number)) {
            for (int i = 2; i < number; i++) {
                assertTrue(number % i != 0 );
            }
        }
    }

    @Property
    public void calculateAverageIsBetweenMinAndMax(@ForAll int[] numbers) {
        if (numbers.length > 0) {
            double average = MathFunctions.CalculateAverage(numbers);
            int min = Arrays.stream(numbers).min().orElseThrow();
            int max = Arrays.stream(numbers).max().orElseThrow();

            assertTrue(average >= min && average <= max);

        }
    }
}