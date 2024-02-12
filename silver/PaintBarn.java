import java.io.*;
import java.util.*;

public class PaintBarn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("paintbarn.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // Initialize the 2D prefix sum array
        int[][] prefixSum = new int[1001][1001];
        // Read the rectangles and update the prefix sum array
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            prefixSum[x1][y1]++;
            prefixSum[x2][y2]++;
            prefixSum[x1][y2]--;
            prefixSum[x2][y1]--;
        }
        // Calculate the 2D prefix sum
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                prefixSum[i][j] += prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }
        // Count the area covered by exactly K coats of paint
        int result = 0;
        for (int i = 0; i <= 1000; i++) {
            for (int j = 0; j <= 1000; j++) {
                if (prefixSum[i][j] == K) {
                    result++;
                }
            }
        }
        // Write the result to the output file
        pw.println(result);
        pw.close();
        br.close();
    }
}
