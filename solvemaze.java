import java.io.*;
import java.util.*;

public class solvemaze {
    static int N, n, m, flag;
    static char[][] a = new char[100][100];
    static int[][] b = new int[100][100];
    static int[][] v = new int[100][100];

    static void dfs(int x, int y) {
        if (b[x][y] != 0 || v[x][y] != 0) {
            return;
        }
        v[x][y] = 1;
        if (x + 1 <= n)
            dfs(x + 1, y);
        if (x - 1 >= 1)
            dfs(x - 1, y);
        if (y + 1 <= m)
            dfs(x, y + 1);
        if (y - 1 >= 1)
            dfs(x, y - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            for (int i = 0; i <= n + 1; i++)
                for (int j = 0; j <= m + 1; j++)
                    b[i][j] = v[i][j] = 0;

            for (int i = 1; i <= n; i++) {
                String row = " " + br.readLine();
                for (int j = 1; j <= m; j++) {
                    a[i][j] = row.charAt(j);
                }
            }

            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= m; j++) {
                    if (a[i][j] == '#')
                        b[i][j] = 1;
                    if (a[i][j] == 'B')
                        b[i][j + 1] = b[i + 1][j] = b[i][j - 1] = b[i - 1][j] = 1;
                }

            flag = 0;
            dfs(n, m);

            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= m; j++)
                    if (a[i][j] == 'G' && v[i][j] == 0)
                        flag = 1;

            System.out.println((flag == 1) ? "No" : "Yes");
        }
        br.close();
    }
}
