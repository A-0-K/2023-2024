import java.io.*;
import java.math.*;
import java.util.*;

public class count {

    public static int[] countDigitsInBase(String num, int base) {
        int[] digitCount = new int[Character.MAX_RADIX + 1]; // Adjusted to handle bases up to Character.MAX_RADIX

        for (int i = 0; i < num.length(); i++) {
            int digit = Character.digit(num.charAt(i), base);
            digitCount[digit]++;
        }

        return digitCount;
    }

    public static int findMostFrequentDigitCount(int n, int b, String s) {
        int[] digitCount = new int[Character.MAX_RADIX + 1]; // Adjusted to handle bases up to Character.MAX_RADIX

        BigInteger startValue = new BigInteger(s, b);

        for (int i = 0; i < n; i++) {
            BigInteger currentValue = startValue.add(BigInteger.valueOf(i));
            String currentValueInBase = currentValue.toString(b);
            int[] digitCountInBase = countDigitsInBase(currentValueInBase, b);

            for (int j = 0; j < digitCountInBase.length; j++) {
                digitCount[j] += digitCountInBase[j];
            }
        }

        return getMax(digitCount);
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = 5;//Integer.parseInt(reader.readLine());

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            String s = input[2];

            int result = findMostFrequentDigitCount(n, b, s);
            results.add(result);
        }

        // Print the results
        for (int i = 0; i < N; i++) {
            System.out.println(results.get(i));
        }

        // Close the BufferedReader
        reader.close();
    }
}