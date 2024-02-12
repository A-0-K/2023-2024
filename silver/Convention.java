import java.io.*;
import java.util.*;

public class Convention {
    static int N, M, C;
    static int[] t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("convention.in"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("convention.out"));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        C = Integer.parseInt(input[2]);

        t = new int[N];
        String[] arrInput = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            t[i] = Integer.parseInt(arrInput[i]);
        }

        Arrays.sort(t);
        bw.write(binSearch(0, 1000000000) + "\n");

        br.close();
        bw.close();
    }

    static boolean pos(int wait) {
        int wagons = 1;
        int firstArrival = t[0];
        int firstIndex = 0;

        for (int i = 1; i < N; i++) {
            if (t[i] - firstArrival > wait || i + 1 - firstIndex > C) {
                wagons += 1;
                firstArrival = t[i];
                firstIndex = i;
            }
        }

        return (wagons <= M);
    }

    static int binSearch(int low, int high) {
        if (low == high) return low;
        if (low + 1 == high) {
            if (pos(low)) return low;
            return high;
        }

        int mid = (low + high) / 2;
        if (pos(mid)) return binSearch(low, mid);
        else return binSearch(mid + 1, high);
    }
}
