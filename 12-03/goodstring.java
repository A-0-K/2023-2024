import java.io.*;

public class goodstring {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        int totalOutput = 0;

        for (int i = 0; i < T; i++) {
            totalOutput += solve(reader.readLine());
        }

        System.out.println(totalOutput);
    }

    static int solve(String s) {
        int ans = 0;
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                ans = Math.max(ans, countErasures(s, x, y));
            }
        }
        return s.length() - ans;
    }

    static int countErasures(String s, int x, int y) {
        int res = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c - '0' == x) {
                ++res;
                int temp = x;
                x = y;
                y = temp;
            }
        }
        if (x != y && res % 2 == 1) {
            --res;
        }
        return res;
    }
}