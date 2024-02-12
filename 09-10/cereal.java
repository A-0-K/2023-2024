import java.io.*;

public class cereal {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("cereal.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("cereal.out")));

        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] f = new int[N];
        int[] s = new int[N];
        int[] occ = new int[M + 1];
        int[] ans = new int[N];

        for (int i = 0; i < N; i++) {
            input = reader.readLine().split(" ");
            f[i] = Integer.parseInt(input[0]);
            s[i] = Integer.parseInt(input[1]);
        }

        int cnt = 0;

        for (int i = N - 1; i >= 0; i--) {
            int j = i;
            int pos = f[i];

            while (true) {
                if (occ[pos] == 0) {
                    occ[pos] = j;
                    cnt++;
                    break;
                } else if (occ[pos] < j) {
                    break;
                } else {
                    int k = occ[pos];
                    occ[pos] = j;

                    if (pos == s[k]) {
                        break;
                    }

                    j = k;
                    pos = s[k];
                }
            }
            ans[i] = cnt;
        }

        for (int i = 0; i < N; i++) {
            writer.println(ans[i]);
        }

        reader.close();
        writer.close();
    }
}
