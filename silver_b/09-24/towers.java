import java.io.*;
import java.util.*;

public class towers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] cubes = Arrays.stream(reader.readLine().split(" "))
                           .mapToInt(Integer::parseInt)
                           .toArray();

        int minTowers = findMinimumTowers(n, cubes);
        System.out.println(minTowers);
    }

    public static int findMinimumTowers(int n, int[] cubes) {
        int[] towers = new int[n];  // Array to represent the top cube of each tower
        int numTowers = 0;          // Number of towers used

        for (int cube : cubes) {
            boolean placed = false;

            // Try to place the current cube on an existing tower
            for (int i = 0; i < numTowers; i++) {
                if (cube <= towers[i]) {
                    towers[i] = cube;
                    placed = true;
                    break;
                }
            }

            // If the cube couldn't be placed on any existing tower, start a new tower
            if (!placed) {
                towers[numTowers] = cube;
                numTowers++;
            }
        }

        return numTowers;
    }
}
