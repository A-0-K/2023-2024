import java.io.*;
import java.util.*;

public class acowdameia {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int l = Integer.parseInt(tokenizer.nextToken());

        Integer[] publications = new Integer[n];
        tokenizer = new StringTokenizer(in.readLine());

        for (int j = 0; j < n; j++) {
            publications[j] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(publications, Comparator.reverseOrder());

        int upper = n;
        int lower = 0;

        while (upper > lower) {
            int mid = (upper + lower + 1) / 2;
            long needed = 0;

            for (int j = 0; j < mid; j++) {
                needed += (long) Math.max(0, mid - publications[j]);
            }

            if (needed <= ((long) k) * ((long) l) && publications[mid - 1] + k >= mid) {
                lower = mid;
            } else {
                upper = mid - 1;
            }
        }

        System.out.println(upper);
    }
}