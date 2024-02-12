import java.io.*;
import java.util.*;

public class haybales {

     public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Read input
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int A = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        List<Haybale> haybales = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int position = Integer.parseInt(tokenizer.nextToken());
            int tastiness = Integer.parseInt(tokenizer.nextToken());
            haybales.add(new Haybale(position, tastiness));
        }

        // Sort haybales based on positions
        haybales.sort(Comparator.comparingInt(Haybale::getPosition));
        
        long maxTastiness = 0;

        //int left = 0;
        int right = 0;

        while (right < N) {
            // Check if the haybale is within the range [A-K, A+K]
            if (Math.abs(haybales.get(right).getPosition() - A) <= K) {
                maxTastiness += haybales.get(right).getTastiness();
                right++;
            } else {
                // Move the left pointer if the haybale is outside the range
                //left++;
            }
        }

        // Output the result
        System.out.println(maxTastiness);

        reader.close();
    }
}

class Haybale {
    private int position;
    private int tastiness;

    public Haybale(int position, int tastiness) {
        this.position = position;
        this.tastiness = tastiness;
    }

    public int getPosition() {
        return position;
    }

    public int getTastiness() {
        return tastiness;
    }
}