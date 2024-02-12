import java.io.*;
import java.util.*;

public class PairUp {
    public static void main(String[] args) throws IOException {
        BufferedReader io = new BufferedReader(new FileReader("pairup.in"));
        int N = Integer.parseInt(io.readLine().trim());
        List<Pair> milk = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer tok = new StringTokenizer(io.readLine());
            int freq = Integer.parseInt(tok.nextToken());
            int amt = Integer.parseInt(tok.nextToken());
            milk.add(new Pair(freq, amt));
        }
        Collections.sort(milk);
        //System.out.println(milk.toString());
        int ret = 0;
        int left = 0, right = N - 1;
        while (left <= right) {
            // how many cows have been grouped together.
            int numPaired = Integer.min(milk.get(left).freq, milk.get(right).freq);
            if (left == right) {
                numPaired /= 2;
            }
            ret = Integer.max(ret, milk.get(left).amt + milk.get(right).amt);
            milk.get(left).freq -= numPaired;
            milk.get(right).freq -= numPaired;
            // If there are no more cows which have this milk output,
            // we can increment/decrement the left/right pointer.
            if (milk.get(left).freq == 0) {
                left++;
            }
            if (milk.get(right).freq == 0) {
                right--;
            }
        }

        PrintWriter out = new PrintWriter(new FileWriter("pairup.out"));
        out.println(ret);
        out.close();
        io.close();
    }

}

class Pair implements Comparable<Pair> {
    public int freq, amt;

    public Pair(int freq, int amt) {
        this.freq = freq;
        this.amt = amt;
    }

    public int compareTo(Pair other) {
        return Integer.compare(this.amt, other.amt);
    }
    /* 
    @Override
    public String toString() {
        return ("Pair" + this.freq + this.amt);
    }
    */
}
