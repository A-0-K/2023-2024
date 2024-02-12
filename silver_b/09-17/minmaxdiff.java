import java.io.*;
import java.util.Arrays;

public class minmaxdiff {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] A = new int[N];

        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        int minMaxDiff = findMinMaxDifference(A);
        System.out.println(minMaxDiff);
    }

    public static int findMinMaxDifference(int[] A) {
        Arrays.sort(A); // Sort the array in ascending order

        int n = A.length;
        int minDiff = Integer.MAX_VALUE;

        // Scenario 1: Change the second-largest element
        minDiff = Math.min(minDiff, A[n - 2] - A[0]);

        // Scenario 2: Change the third-largest element
        minDiff = Math.min(minDiff, A[n - 3] - A[0]);

        // Scenario 3: Change the fourth-largest element (if available)
        if (n >= 4) {
            minDiff = Math.min(minDiff, A[n - 4] - A[0]);
        }

        return minDiff;
    }
}
