import java.io.*;

public class collectingnumbers {
    public static void main(String[] args) throws IOException {
        for (int testCase = 1; testCase <= 10; testCase++) {
            String inputFile = String.format("%02d.in", testCase);
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            int n = Integer.parseInt(br.readLine());
            String[] numsStr = br.readLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int[] positions = new int[n];
            for (int i = 0; i < n; i++) {
                positions[nums[i] - 1] = i;
            }
            int rounds = 1;
            for (int i = 1; i < n; i++) {
                if (positions[i] < positions[i - 1]) {
                    rounds++;
                }
            }
            br.close();
            System.out.println("Test Case " + testCase + ": " + rounds);
        }
    }
}
