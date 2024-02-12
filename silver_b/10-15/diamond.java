import java.util.*;
import java.io.*;

public class diamond {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter pw = new PrintWriter(new File("diamond.out"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] diamonds = new int[N];
        for (int x = 0; x < N; x++) {
            diamonds[x] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(diamonds);

        // Save the number of diamonds that can be in one case if diamonds[j] 
        // is the smallest
        int[] counts = new int[N];
        int y = 0;
        for (int x = 0; x < N; x++) {
            while (y < N && diamonds[y] <= diamonds[x] + K)
                y++;
            // y is the first index so that diamonds[y] > diamonds[x] + K
            counts[x] = y - x;
        }

        // smax[j]: the suffix max value of counts[j] ... counts[N-1]
        int[] smax = new int[N];
        smax[N - 1] = counts[N - 1];
        for (int j = N - 2; j >= 0; j--)
            smax[j] = Math.max(smax[j + 1], counts[j]);

        int max = 0;
        for (int i = 0; i < N; i++) {
            // Max # of diamonds in suitcase 1: i, i+1, ..., i+m1 -1
            int m1 = counts[i];

            // Max # of diamonds in suitcase 2: i+m1, ... N-1
            int m2 = i + m1 < N ? smax[i + m1] : 0;

            max = Math.max(max, m1 + m2);
        }

        pw.println(max);
        br.close();
        pw.close();
    }
}
