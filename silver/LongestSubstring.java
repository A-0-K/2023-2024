import java.io.*;
import java.util.*;

public class LongestSubstring {
    public static String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] checked = new boolean[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            count[c - 'a']--;
            if (checked[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                checked[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            checked[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String result = removeDuplicateLetters(s);
        System.out.println(result);
    }
}

