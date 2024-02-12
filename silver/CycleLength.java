import java.io.*;
import java.util.*;

public class CycleLength {

    // Function to calculate the cycle length for a given number n
    public static int calculateCycleLength(int n) {
        int cycleLength = 1;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            cycleLength++;
        }
        return cycleLength;
    }
    // Function to find the maximum cycle length between x and y (inclusive)
    public static int findMaxCycleLength(int x, int y) {
        int maxCycleLength = 0;
        for (int i = x; i <= y; i++) {
            int cycleLength = calculateCycleLength(i);
            if (cycleLength > maxCycleLength) {
                maxCycleLength = cycleLength;
            }
        }
        return maxCycleLength;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(reader.readLine()); // Number of test cases
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int maxCycleLength = findMaxCycleLength(x, y);
            ans.add(maxCycleLength);
        }
        for (int x : ans)
        {
            System.out.println(x);
        }
        reader.close();
    }
}
