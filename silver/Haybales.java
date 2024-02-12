import java.io.*;
import java.util.*;

public class Haybales {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] list = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pw.println(countLEQ(list, b) - countLEQ(list, a - 1));
        }
        br.close();
        pw.close();
    }
    public static int countLEQ(int[] list, int limit) {
        if (list[0] > limit) {
            return 0;
        }
        int min = 0;
        int max = list.length - 1;
        // list[min] is guaranteed to be <= limit
        while (min != max) {
            int mid = (min + max + 1) / 2;
            if (list[mid] <= limit) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }
        return min + 1;
    }
}
