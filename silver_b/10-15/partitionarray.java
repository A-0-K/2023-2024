import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class partitionarray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for (int j = 0; j < n; j++)
            A[j] = Integer.parseInt(st.nextToken());

        int[] backMin = new int[n];
        backMin[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--)
            backMin[i] = min(backMin[i + 1], A[i]);

        int ans = -1;
        int curMax = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            curMax = max(curMax, A[i]);
            if (curMax <= backMin[i + 1]) {
                ans = i + 1;
                break;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
