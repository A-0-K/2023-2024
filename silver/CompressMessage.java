
import java.io.*;


public class CompressMessage {

    public static String compressString(String input) {
        /* 
        if (input == null || input.length() <= 1) {
            return input; // no compression needed for empty or single character strings
        }
        */
        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(input.charAt(i - 1));
                compressed.append(count);
                count = 1;
            }
        }
        // Append the last character and its count
        compressed.append(input.charAt(input.length() - 1));
        compressed.append(count);
        return compressed.toString();
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter a message: ");
            String input = reader.readLine();
            String compressedString = compressString(input);
            System.out.println("Compressed string: " + compressedString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
