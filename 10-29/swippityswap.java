import java.io.*;
import java.util.*;

public class swippityswap {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("swap.in"));
        PrintWriter writer = new PrintWriter(new FileWriter("swap.out"));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] cows = new int[N];
        for (int i = 0; i < N; i++) {
            cows[i] = i + 1;
        }

        List<int[]> swaps = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            int L = Integer.parseInt(st.nextToken()) - 1;
            int R = Integer.parseInt(st.nextToken()) - 1;
            swaps.add(new int[] { L, R });
        }

        for (int step = 0; step < K; step++) {
            for (int[] swap : swaps) {
                int left = swap[0];
                int right = swap[1];
                while (left < right) {
                    int temp = cows[left];
                    cows[left] = cows[right];
                    cows[right] = temp;
                    left++;
                    right--;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            writer.println(cows[i]);
        }

        reader.close();
        writer.close();
    }
}
