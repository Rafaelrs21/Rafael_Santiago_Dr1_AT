package q2;

public class MathFunctions {

    private final MathLogger logger;

    public MathFunctions(MathLogger logger) {
        this.logger = logger;
    }

    public static int MultiplyByTwo(int number)
    {
        return number * 2;
    }
    public static int[] GenerateMultiplicationTable(int number, int limit) {
        if (number <= 0 || limit <= 0) {
            throw new IllegalArgumentException("O número e o limite devem ser maiores que zero.");
        }

        int[] result = new int[limit];
        for (int i = 0; i < limit; i++) {
            result[i] = number * (i + 1);
        }

        return result;
    }
    public static boolean IsPrime(int number)
    {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++)
        {
            if (number % i == 0) return false;
        }
        return true;
    }
    public static double CalculateAverage(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }
        double sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum / numbers.length;
    }
}