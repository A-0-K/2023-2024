import java.io.*;
import java.util.*;

public class beautysumII {
    static int sumOfBeauty(int[] a, int n) {
        int ans = 0; // stores the sum of beauty in the array

        for (int i = 1; i < n - 1; i++) {
            boolean flag = true;

            for (int j = 0; j < i; j++) { // checking left side
                if (a[j] >= a[i])
                    flag = false;
            }

            for (int k = i + 1; k < n; k++) { // checking right side
                if (a[k] <= a[i])
                    flag = false;
            }

            if (flag)
                ans += 2;
            else if (a[i - 1] < a[i] && a[i + 1] > a[i])
                ans += 1;
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(sumOfBeauty(a, n));
    }
}
