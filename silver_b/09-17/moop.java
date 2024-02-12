import java.io.*;
import java.util.*;

public class moop {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("moop.in"));
        PrintWriter writer = new PrintWriter(new FileWriter("moop.out"));

        int N = Integer.parseInt(reader.readLine());
        int[] x = new int[N];
        int[] y = new int[N];
        int[] cid = new int[N];
        int[] minl = new int[N];
        int[] maxr = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
            cid[i] = i;
        }

        sort(cid, x, y);

        minl[0] = y[cid[0]];
        for (int i = 1; i < N; i++) {
            minl[i] = Math.min(minl[i - 1], y[cid[i]]);
        }

        maxr[N - 1] = y[cid[N - 1]];
        for (int i = N - 2; i >= 0; i--) {
            maxr[i] = Math.max(maxr[i + 1], y[cid[i]]);
        }

        int ans = 1;
        for (int i = 0; i < N - 1; i++) {
            if (minl[i] > maxr[i + 1]) {
                ans++;
            }
        }

        writer.println(ans);
        writer.close();
        reader.close();
    }

    public static void sort(int[] cid, int[] x, int[] y) {
        Integer[] cids = new Integer[cid.length];
        for (int i = 0; i < cid.length; i++) {
            cids[i] = cid[i];
        }

        Arrays.sort(cids, (a, b) -> {
            if (x[a] == x[b]) return Integer.compare(y[a], y[b]);
            return Integer.compare(x[a], x[b]);
        });

        for (int i = 0; i < cid.length; i++) {
            cid[i] = cids[i];
        }
    }
}
