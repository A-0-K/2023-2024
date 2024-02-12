import java.io.*;
import java.util.*;

public class predictwinner {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] A = new int[N];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(tokenizer.nextToken());
        }        
        boolean result = canPlayer1Win(A);
        System.out.println(result);
    }
    
    public static boolean canPlayer1Win(int[] A) {
        int N = A.length;
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            dp[i][i] = A[i];
        }

        for (int l = 2; l <= N; l++) {
            for (int i = 0; i <= N - l; i++) {
                int j = i + l - 1;
                int score1 = A[i] - dp[i + 1][j];
                int score2 = A[j] - dp[i][j - 1];
                dp[i][j] = Math.max(score1, score2);
            }
        }

        return dp[0][N - 1] >= 0;
    }
}
