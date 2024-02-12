import java.io.*;
import java.util.*;

public class sumofpowers {
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
        if (b == 0) {
            return 1 % k;
        }

        long result = 1;
        a = a % k;

        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % k;
            }
            b = b >> 1;
            a = (a * a) % k;
        }

        return result;
    }
}