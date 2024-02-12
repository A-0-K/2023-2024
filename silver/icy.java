import java.io.*;
import java.util.*;

public class icy {
    static int N, R;
    static char[][] grid = new char[1002][1002];
    static int[][] region = new int[1002][1002];
    static int[] area = new int[1000000];
    static int[] perimeter = new int[1000000];

    public static void visit(int i, int j, int r) {
        Stack<int[]> to_visit = new Stack<>();
        to_visit.push(new int[]{i, j});
        while (!to_visit.isEmpty()) {
            int[] current = to_visit.pop();
            i = current[0];
            j = current[1];
            if (region[i][j] != 0 || grid[i][j] == '.') continue;
            region[i][j] = r;
            area[r]++;
            to_visit.push(new int[]{i - 1, j});
            to_visit.push(new int[]{i + 1, j});
            to_visit.push(new int[]{i, j - 1});
            to_visit.push(new int[]{i, j + 1});
        }
    }

    public static void findPerimeters() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int r = region[i][j];
                if (r == 0) continue;
                if (region[i - 1][j] == 0) perimeter[r]++;
                if (region[i + 1][j] == 0) perimeter[r]++;
                if (region[i][j - 1] == 0) perimeter[r]++;
                if (region[i][j + 1] == 0) perimeter[r]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("perimeter.in"));
        N = Integer.parseInt(fin.readLine());
        String s;
        for (int i = 0; i < N + 2; i++) grid[0][i] = grid[N + 1][i] = '.';
        for (int i = 1; i <= N; i++) {
            grid[i][0] = grid[i][N + 1] = '.';
            s = fin.readLine();
            for (int j = 1; j <= N; j++) grid[i][j] = s.charAt(j - 1);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (grid[i][j] == '#' && region[i][j] == 0) visit(i, j, ++R);
            }
        }

        findPerimeters();

        int best_a = 0, best_p = 0;
        for (int i = 1; i <= R; i++) {
            if (area[i] > best_a || (area[i] == best_a && perimeter[i] < best_p)) {
                best_a = area[i];
                best_p = perimeter[i];
            }
        }

        PrintWriter fout = new PrintWriter(new FileWriter("perimeter.out"));
        fin.close();
        fout.println(best_a + " " + best_p);
        fout.close();
    }
}
