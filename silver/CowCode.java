import java.io.*;

public class CowCode {
    public static char findNthCharacter(String s, long n) {
        long size = s.length(); // Initial size of the string
        // Double the size of the string until it becomes greater than or equal to N
        while (size < n) {
            size *= 2;
        }
        // Perform a binary search to find the character at N-th position
        while (n > s.length()) {
            if (n <= size / 2) {
                size /= 2; // Move to the left half of the string
            } else if (n == size / 2 + 1) {
                n = size / 2; // Move to the middle of the string
            } else {
                n -= (size / 2 + 1); // Move to the right half of the string
                size /= 2;
            }
        }
        return s.charAt((int)(n - 1)); // Return the N-th character of the infinite code string
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowcode.in"));
        String inputLine = br.readLine();
        String[] input = inputLine.split(" ");
        String s = input[0];
        long n = Long.parseLong(input[1]);
        char result = findNthCharacter(s, n);
        PrintWriter pw = new PrintWriter("cowcode.out");
		pw.println(result);
		pw.close();
        br.close();
    }
}
