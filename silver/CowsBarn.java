import java.io.*;
import java.util.*;
public class CowsBarn {
    // Function to calculate the sum of squares from 1 to v (inclusive)
    public static long sumn2(long v) {
        return v * (v + 1) * (2 * v + 1) / 6;
    }
    public static void main(String[] args) throws IOException {
        // Open the input file "cbarn.in" for reading
        BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
        // Read the first line containing the number of rooms N
        int N = Integer.parseInt(br.readLine());
        // Create a list to store the number of cows in each room
        List<Long> A = new ArrayList<>();
        // Variable to store the number of cows lined up outside the barn
        long c = 0;
        // Read the second line containing the number of cows lined up outside each room
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A.add(Long.parseLong(st.nextToken()));
            // Calculate the value of 'c', which represents the number of cows lined up outside
            // the barn after cows from room 'i' have entered the barn.
            c = Math.max(0L, c + A.get(i) - 1);
        }
        // Close the input file after reading
        br.close();
        // Rotate the list 'A' to find the optimal starting position for the first door.
        // The idea is to find the position such that after distributing cows to the rooms,
        // the number of cows lined up outside the barn is minimized.
        for (int i = 0; ; i++) {
            if (c == 0) {
                // Once we find the optimal starting position, rotate the list 'A' accordingly.
                Collections.rotate(A, -i);
                break;
            }
            c = Math.max(0L, c + A.get(i) - 1);
        }
        // Calculate the minimum energy needed to distribute cows to each room.
        long result = 0;
        for (int i = 0; i < N; i++) {
            // Calculate the energy needed to move cows from the outside to room 'i'.
            result += sumn2(A.get(i) + c - 1) - sumn2(c - 1);
            // Update 'c' to represent the number of cows lined up outside the barn
            // after cows from room 'i' have entered the barn.
            c = Math.max(0L, c + A.get(i) - 1);
        }
        // Open the output file "cbarn.out" for writing
        BufferedWriter bw = new BufferedWriter(new FileWriter("cbarn.out"));
        // Write the result to the output file and close it.
        bw.write(result + "\n");
        bw.close();
    }
}
