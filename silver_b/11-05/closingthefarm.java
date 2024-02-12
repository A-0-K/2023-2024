import java.io.*;
import java.util.*;

public class closingthefarm {
    static ArrayList<ArrayList<Integer>> adj;
    static Set<Integer> visited;  // Use a set instead of an array
    static boolean[] closed;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("closing.in"));
        PrintWriter out = new PrintWriter("closing.out");

        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new HashSet<>();
        closed = new boolean[n];
        adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<Integer>());

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int[] order = new int[n];
        for (int i = 0; i < n; i++) { order[i] = sc.nextInt() - 1; }

        for (int i = 0; i < n; i++) {
            visited.clear();  // Clear the set for each barn
            dfs(order[n - 1]);  // DFS from the barn that will close last
            // Checks if all unclosed barns have been visited
            if (visited.size() == n - i) {
                out.println("YES");
            } else {
                out.println("NO");
            }
            closed[order[i]] = true;
        }
        out.close();
    }

    static void dfs(int node) {
        if (visited.contains(node) || closed[node]) return;

        visited.add(node);
        for (int neighbor : adj.get(node)) {
            dfs(neighbor);
        }
    }
}
