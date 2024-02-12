import java.io.*;
import java.util.*;

public class Lemonade {
    public static int getMinCowsInLine(int N, int[] cows) {
        // Sort the cows in ascending order of their willingness to wait
        Arrays.sort(cows);
        int cowsInLine = 0; // Variable to keep track of cows in line
        // iterate through the sorted cows in reverse order (largest to smallest willingness)
        for (int i = N - 1; i >= 0; i--) {
            // If the current cow's willingness is greater than or equal to the number of cows in line,
            // add the cow to the line and increment the count of cows in line.
            if (cows[i] >= cowsInLine) {
                cowsInLine++;
            }
        }
        // The final value of cowsInLine represents the minimum possible number of cows who might join the line
        return cowsInLine;
    }
    public static void main(String[] args) throws IOException {
        // Using BufferedReader for input reading
        BufferedReader br = new BufferedReader(new FileReader("lemonade.in"));
        // Read the number of cows (N) from the first line
        int N = Integer.parseInt(br.readLine());
        // Create an array to store the willingness of cows to wait in line
        int[] cows = new int[N];
        // Read the space-separated cow preferences from the second line
        String[] cowPreferences = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(cowPreferences[i]);
        }
        br.close();
        // Calculate the minimum possible number of cows who might join the line
        int minCowsInLine = getMinCowsInLine(N, cows);
        // Using BufferedWriter for output writing
        BufferedWriter bw = new BufferedWriter(new FileWriter("lemonade.out"));
        // Write the minimum possible number of cows to the output file
        bw.write(String.valueOf(minCowsInLine));
        bw.newLine();
        bw.close();
    }
}