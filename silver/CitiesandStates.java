
import java.io.*;
import java.util.*;

public class CitiesandStates {
    static class Pair {
        public String city;
        public String state;

        public Pair(String city, String state) {
            this.city = city;
            this.state = state;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int pairNum = Integer.parseInt(read.readLine());
        Pair[] pairs = new Pair[pairNum];
        for (int p = 0; p < pairNum; p++) {
            StringTokenizer cityState = new StringTokenizer(read.readLine());
            String city = cityState.nextToken();
            String state = cityState.nextToken();
            // We only care about the first two letters of the city
            city = city.substring(0, 2);
            pairs[p] = new Pair(city, state);
        }
        int[] seen = new int[(int) Math.pow(26, 4)];
        long total = 0;
        for (Pair p : pairs) {
            if (!p.city.equals(p.state)) {
                total += seen[index(p.state + p.city)];
            }
            seen[index(p.city + p.state)]++;
        }
        PrintWriter out = new PrintWriter(System.out);
        out.println(total);
        out.flush();
        read.close();
        out.close();
    }

    static int index(String s) {
        int ind = 0;
        for (int i = 0; i < s.length(); i++) {
            ind = ind * 26 + (s.charAt(i) - 'A');
        }
        return ind;
    }
}
