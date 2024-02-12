
import java.io.*;
public class CowCensoring2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("censor.in"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("censor.out"));

        String s = reader.readLine();
        String t = reader.readLine();

        StringBuilder censored = new StringBuilder(s);
        int sLength = s.length();
        int tLength = t.length();

        int censoredIndex = sLength - tLength;
        for (int i = sLength - 1; i >= 0; i--) {
            censored.setCharAt(censoredIndex, s.charAt(i));
            if (isMatch(censored, censoredIndex, t)) {
                censoredIndex -= tLength;
            }
        }

        writer.write(censored.substring(censoredIndex + 1));
        writer.newLine();

        reader.close();
        writer.close();
    }

    private static boolean isMatch(StringBuilder censored, int index, String t) {
        int censoredIndex = index;
        for (int i = t.length() - 1; i >= 0; i--) {
            if (censored.charAt(censoredIndex) != t.charAt(i)) {
                return false;
            }
            censoredIndex++;
        }
        return true;
    }
}
