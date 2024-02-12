import java.io.*;
import java.util.*;
public class AngryCows {
    public static void main(String[] args) throws IOException {
        // Input and Output file paths
        BufferedReader br = new BufferedReader(new FileReader("angry.in"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("angry.out"));
        // Read the first line containing n (number of cows) and k (number of cannons)
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        // Array to store the positions of cows
        int[] ar = new int[n];
        // Read the positions of cows and store them in the array
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(br.readLine());
        }
        // Sort the array of cow positions in ascending order
        Arrays.sort(ar);
        // Binary search to find the minimum power required to clear all the cows
        int low = 1;
        int high = (int) 1e9; // Maximum possible power (10^9)
        int store = (int) 1e9; // Store the final answer
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int i = 0;
            // loop through the cannons to check if each can explode the cows
            for (int kas = 0; kas < k && i < n; kas++) {
                int hasta = ar[i];
                hasta += mid * 2;
                // Increment 'i' to find the farthest cow that can be exploded by thighs cannon
                while (i < n - 1 && ar[i + 1] <= hasta) {
                    i++;
                }
                i++;
            }
            // Check if all the cows have been explowded
            boolean ok = (i >= n);
            if (ok) {
                // If all cows are explowded, update the storeution and reduce the power
                store = Math.min(store, mid);
                high = mid - 1;
            } else {
                // If not all cows are explowded, increase the power
                low = mid + 1;
            }
        }
        // Write the minimum power required to explowde all the cows into the output file
        bw.write(store + "\n");
        bw.flush();
        // Close the input and output streams
        br.close();
        bw.close();
    }
}
