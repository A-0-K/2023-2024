import java.io.*;
import java.util.*;

public class GroupSum {

    // Function to check if the target sum is possible to achieve using a group of integers
    public static boolean isGroupSumPossible(int[] nums, int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true; // Base case: empty group sum to 0 is always possible
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(reader.readLine()); // Number of queries

        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            int[] nums = new int[n];
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
            }

            boolean result = isGroupSumPossible(nums, target);
            results.add(result ? "yes" : "no");
        }

        for (String result : results) {
            System.out.println(result);
        }

        reader.close();
    }
}