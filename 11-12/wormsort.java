import java.io.*;
import java.util.*;

public class wormsort {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("wormsort.in"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("wormsort.out"));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        int[] positions = new int[N + 1];

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= N; i++) {
            positions[i] = Integer.parseInt(tokenizer.nextToken());
        }

        List<Wormhole> wormholes = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());

            wormholes.add(new Wormhole(a, b, w));
        }

        // If the cows are already sorted, no need for wormholes
        boolean sorted = true;
        for (int i = 1; i <= N; i++) {
            if (positions[i] != i) {
                sorted = false;
                break;
            }
        }

        if (sorted) {
            writer.write("-1");
        } else {
            int low = 1;
            int high = (int) 1e9;
            int result = -1;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (canSortCows(positions, wormholes, mid)) {
                    result = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            // Output the result
            writer.write(Integer.toString(result));
        }

        writer.newLine();
        reader.close();
        writer.close();
    }

    private static boolean canSortCows(int[] positions, List<Wormhole> wormholes, int minWidth) {
        UnionFind unionFind = new UnionFind(positions.length);

        for (Wormhole wormhole : wormholes) {
            if (wormhole.width >= minWidth) {
                unionFind.union(wormhole.a, wormhole.b);
            }
        }

        for (int i = 1; i < positions.length; i++) {
            if (unionFind.find(i) != unionFind.find(positions[i])) {
                return false;
            }
        }

        return true;
    }
}

class Wormhole {
    int a, b, width;

    public Wormhole(int a, int b, int width) {
        this.a = a;
        this.b = b;
        this.width = width;
    }
}

class UnionFind {
    int[] parent;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }
}