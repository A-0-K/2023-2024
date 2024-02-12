import java.io.*;
public class CowCensoring {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("censor.in"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("censor.out"));
        String s = reader.readLine();
        String t = reader.readLine();
        
        StringBuilder censored = new StringBuilder();
        censored.append(s.substring(0, t.length() - 1));

        for (int x = t.length() - 1; x < s.length(); x++) {
            censored = censored.append(s.charAt(x));
            if (censored.length() >= t.length()) {
                String check = censored.substring(censored.length() - t.length());
                if (check.equals(t)) {
                    censored.delete(censored.length() - t.length(), censored.length());
                }
            }
        }
        writer.write(censored.toString());
        writer.newLine();
        reader.close();
        writer.close();
    }
}