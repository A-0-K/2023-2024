import java.io.*;
import java.util.*;
import java.math.*;

public class transformnumber {
     public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            BigInteger N = new BigInteger(tokenizer.nextToken());
            int P = Integer.parseInt(tokenizer.nextToken());
            BigInteger transformedValue = transformNumber(N, P);
            System.out.println(transformedValue);
        }

        reader.close();
    }

    private static BigInteger transformNumber(BigInteger N, int P) {
        if (P > N.toString().length()) {
            // P is greater than the length of N, return N as is
            return N;
        }

        List<Integer> primeFactors = primeFactors(N.intValue());
        int[] digits = getDigits(N);

        int pthDigit = digits[digits.length - P];

        for (int i = digits.length - 1; i >= 0; i--) {
            if (i != digits.length - P) {
                digits[i] += pthDigit;
            } else {
                digits[i] = countPrimeFactors(N.intValue(), primeFactors);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int digit : digits) {
            result.append(digit);
        }

        return new BigInteger(result.toString());
    }

    private static List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        return factors;
    }

    private static int[] getDigits(BigInteger n) {
        String numberString = n.toString();
        int[] digits = new int[numberString.length()];
        for (int i = 0; i < numberString.length(); i++) {
            digits[i] = Character.getNumericValue(numberString.charAt(i));
        }
        return digits;
    }

    private static int countPrimeFactors(int n, List<Integer> primeFactors) {
        Set<Integer> uniqueFactors = new HashSet<>(primeFactors);
        return uniqueFactors.size();
    }
}