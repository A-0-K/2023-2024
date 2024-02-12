import java.io.*;
import java.util.*;

public class sumofpowersdp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long sum = 0; // Initialize the sum to store the result

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            long a = Long.parseLong(tokenizer.nextToken());
            long b = Long.parseLong(tokenizer.nextToken());
            long k = Long.parseLong(tokenizer.nextToken());

            // Calculate "ai^bi % ki" and add it to the sum
            long result = powMod(a, b, k);
            sum = (sum + result) % (1000000007 + 1000000000); // Take the modulo 7 + 1e9
        }

        System.out.println(sum);
    }

    public static long powMod(long a, long b, long k) {
        // Initialize an array to store the powers of 'a' modulo 'k'
        long[] powers = new long[(int) (b + 1)];
        powers[0] = 1 % k;

        // Precompute powers of 'a' modulo 'k'
        for (int i = 1; i <= b; i++) {
            powers[i] = (powers[i - 1] * (a % k)) % k;
        }

        return powers[(int) b];
    }
}