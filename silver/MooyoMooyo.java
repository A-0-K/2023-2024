import java.io.*;
import java.util.*;

public class MooyoMooyo {
    static int N, K;
    static int[][] board = new int[100][10];
    static int[][] region = new int[100][10];
    static int[] regsizes = new int[1001];

    public static void gravity() {
        for (int j = 0; j < 10; j++) {
            int top = N - 1, bottom = N - 1;
            while (top >= 0) {
                while (top >= 0 && board[top][j] == 0) top--;
                if (top >= 0) board[bottom--][j] = board[top--][j];
            }
            while (bottom >= 0) board[bottom--][j] = 0;
        }
    }

    public static void visit(int i, int j, int r, int c) {
        if (i < 0 || i >= N || j < 0 || j > 9 || board[i][j] != c || region[i][j] != 0) return;
        region[i][j] = r;
        regsizes[r]++;
        visit(i - 1, j, r, c);
        visit(i + 1, j, r, c);
        visit(i, j - 1, r, c);
        visit(i, j + 1, r, c);
    }

    public static boolean iterate() {
        int r = 1;
        for (int i = 0; i < N; i++)
            Arrays.fill(region[i], 0);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < 10; j++)
                if (board[i][j] != 0 && region[i][j] == 0) visit(i, j, r++, board[i][j]);
        boolean progress = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] != 0 && regsizes[region[i][j]] >= K) {
                    board[i][j] = 0;
                    progress = true;
                }
            }
        }
        gravity();
        Arrays.fill(regsizes, 0);
        return progress;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("mooyomooyo.in"));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String s = fin.readLine();
            for (int j = 0; j < 10; j++) board[i][j] = s.charAt(j) - '0';
        }

        while (iterate());

        PrintWriter fout = new PrintWriter(new FileWriter("mooyomooyo.out"));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) fout.print(board[i][j]);
            fout.println();
        }
        fin.close();
        fout.close();
    }
}
