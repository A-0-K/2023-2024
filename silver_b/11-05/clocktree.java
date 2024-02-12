import java.io.*;
import java.util.*;

public class clocktree {
    static int[] clocks;
    static List<List<Integer>> adj;
    static int sum0 = 0, sum1 = 0, nodes0 = 0, nodes1 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("clocktree.in"));
        PrintWriter pw = new PrintWriter(new File("clocktree.out"));

        int n = Integer.parseInt(br.readLine());
        String[] clockSettings = br.readLine().split(" ");
        clocks = new int[n];
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            clocks[i] = Integer.parseInt(clockSettings[i]);
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]) - 1;
            int b = Integer.parseInt(ab[1]) - 1;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        dfs(0, 0, -1);

        // same mod means you can start anywhere
        if ((sum0 % 12) == (sum1 % 12)) {
            pw.println(n);
        }
        // if group0 is 1 smaller than group1, we must start from group1
        else if ((sum0 + 1) % 12 == (sum1 % 12)) {
            pw.println(nodes1);
        }
        // if group1 is 1 smaller than group0, we must start from group0
        else if ((sum0 % 12) == ((sum1 + 1) % 12)) {
            pw.println(nodes0);
        }
        // no way to get all clocks pointing to 12
        else {
            pw.println(0);
        }

        pw.close();
        br.close();
    }

    static void dfs(int i, int color, int par) {
        // update color/sum
        if (color == 0) {
            nodes0++;
            sum0 += clocks[i];
        } else {
            nodes1++;
            sum1 += clocks[i];
        }

        for (int j : adj.get(i)) {
            if (j != par) {
                // swap colors for the child
                dfs(j, 1 - color, i);
            }
        }
    }
}
