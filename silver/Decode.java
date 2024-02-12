import java.io.*;
import java.util.*;

public class Decode {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int currentCount = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentCount = currentCount * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(currentCount);
                stringStack.push(currentString.toString());
                currentCount = 0;
                currentString = new StringBuilder();
            } else if (c == ']') {
                StringBuilder decodedString = new StringBuilder(stringStack.pop());
                int repeatCount = countStack.pop();
                for (int i = 0; i < repeatCount; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(c);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String encodedString = reader.readLine();
        String decodedString = decodeString(encodedString);
        System.out.println(decodedString);
        reader.close();
    }
}
