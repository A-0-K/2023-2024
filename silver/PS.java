
import java.io.*;

public class PS {
    public int longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 0;
        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            maxLength = 1;
        }
        // Check for palindromic substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLength = 2;
            }
        }
        // Check for palindromic substrings of length greater than 2
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    maxLength = Math.max(maxLength, len);
                }
            }
        }
        return maxLength;
    }
    public static void main(String[] args) throws IOException {
        PS solution = new PS();
        // Read input using BufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the string: ");
        String s = reader.readLine();
        int maxLength = solution.longestPalindrome(s);
        System.out.println("Max length of any palindromic substring: " + maxLength);
    }
}
