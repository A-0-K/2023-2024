import java.io.*;

public class collectingnumbers2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int rounds = 1;
        int maxNext = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > maxNext) {
                maxNext = arr[i];
            }
            if (arr[i] == maxNext) {
                rounds++;
            }
        }

        System.out.println(rounds);
    }
}
//now suppose you can collect numbers, in each round, in increasing order, not necessily continuous. What is the min number of rounds to pick all the numbers?