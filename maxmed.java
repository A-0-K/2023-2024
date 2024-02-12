import java.io.*;
import java.util.*;

public class maxmed {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int[] b = Arrays.copyOfRange(a, n / 2, a.length);
        int m = b[0];
        int i = 0;

        for (int x : b) {
            int y = (i < n / 2) ? a[i] : Integer.MAX_VALUE;
            i++;
            int d = Math.min(y - x, k / i);
            m += d;
            k -= d * i;
        }

        System.out.println(m);
    }
}
