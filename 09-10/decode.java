import java.io.*;
import java.util.*;
public class decode{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        int decodedLength = decodeString(s);
        System.out.println(decodedLength);
    }
    public static int decodeString(String s) {
        Stack<Integer> countStack = new Stack<Integer>();
        Stack<StringBuilder> strStack = new Stack<>();
        int index = 0;
        StringBuilder currentStr = new StringBuilder();
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);
            } else if (c == '[') {
                strStack.push(currentStr);
                currentStr = new StringBuilder();
                index++;
            } else if (c == ']') {
                StringBuilder temp = strStack.pop();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(currentStr);
                }
                currentStr = temp;
                index++;
            } else {
                currentStr.append(c);
                index++;
            }
        }
        return currentStr.length();
    }
}
