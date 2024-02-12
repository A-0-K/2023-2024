import java.io.*;
import java.util.*;

public class NoTimeToPaint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int Q = Integer.parseInt(tokenizer.nextToken());

        String colors = " " + br.readLine();

        int[] last = new int[26]; // Store the last occurrence of each letter
        int[] prefix = new int[N + 1]; // Number of distinct colors to the left of each position

        for (int j = 1; j <= N; j++) {
            prefix[j] = prefix[j - 1]; // Initialize prefix count with previous value
            int letter = colors.charAt(j) - 'A'; // Calculate the index of the current letter

            boolean isLeft = last[letter] == 0; // Check if it's the leftmost occurrence
            for (int lighter = 0; lighter < letter; lighter++) {
                if (last[lighter] > last[letter]) {
                    isLeft = true; // Check if any lighter letter occurred after the current letter
                }
            }

            if (isLeft) {
                prefix[j]++; // Increment prefix count if a new distinct color is found to the left
            }

            last[letter] = j; // Update the last occurrence of the current letter
        }

        Arrays.fill(last, N + 1); // Reset the last occurrence array
        int[] suffixes = new int[N + 2]; // Number of distinct colors to the right of each position

        for (int j = N; j >= 1; j--) {
            suffixes[j] = suffixes[j + 1]; // Initialize suffix count with previous value
            int letter = colors.charAt(j) - 'A'; // Calculate the index of the current letter

            boolean isRight = last[letter] == N + 1; // Check if it's the rightmost occurrence
            for (int lighter = 0; lighter < letter; lighter++) {
                if (last[lighter] < last[letter]) {
                    isRight = true; // Check if any lighter letter occurred before the current letter
                }
            }

            if (isRight) {
                suffixes[j]++; // Increment suffix count if a new distinct color is found to the right
            }

            last[letter] = j; // Update the last occurrence of the current letter
        }

        StringBuilder ans = new StringBuilder(); // Store the answers

        for (int j = 1; j <= Q; j++) {
            tokenizer = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            ans.append(prefix[a - 1] + suffixes[b + 1]).append('\n'); // Retrieve the result for the query
        }

        System.out.print(ans); // Print the final results
    }
}
