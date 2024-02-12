import java.io.*;
import java.util.*;

public class transfnum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String n = tokenizer.nextToken();
            int p = Integer.parseInt(tokenizer.nextToken());

            int result = transformNumber(n, p);
            System.out.println(result);
        }

        reader.close();
    }

    private static int transformNumber(String n, int p) {
        int[] digits = getDigits(n);
        int pthDigit = digits[digits.length - p];
        List<Integer> primeFactors = primeFactors(Integer.parseInt(n));

        for (int i = digits.length - 1; i >= 0; i--) {
            if (i != digits.length - p) {
                digits[i] += pthDigit;
            } else {
                digits[i] = countPrimeFactors(Integer.parseInt(n), primeFactors);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int digit : digits) {
            result.append(digit);
        }

        return Integer.parseInt(result.toString());
    }

    private static int[] getDigits(String n) {
        int[] digits = new int[n.length()];
        for (int i = 0; i < n.length(); i++) {
            digits[i] = Character.getNumericValue(n.charAt(i));
        }
        return digits;
    }

    private static List<Integer> primeFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }
        return factors;
    }

    private static int countPrimeFactors(int num, List<Integer> primeFactors) {
        Set<Integer> uniqueFactors = new HashSet<>(primeFactors);
        return uniqueFactors.size();
    }
}
