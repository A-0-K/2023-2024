import java.io.*;

public class multiplesof7 {
     public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String S = reader.readLine();
        long result = countMultipleOf7Pairs(S);

        System.out.println(result);
    }

    static long countMultipleOf7Pairs(String S) {
        int n = S.length();
        long[] countMod = new long[7];
        for (int i = 0; i < 7; i++) {
            countMod[i] = 0;
        }

        long totalCount = 0;
        long currentNum = 0;
        long powerOf10 = 1;

        for (int i = n - 1; i >= 0; i--) {
            int digitValue = S.charAt(i) - '0';
            long contribution = (digitValue * powerOf10) % 7;

            // Update currentNum
            currentNum = (currentNum + contribution) % 7;
            if (currentNum < 0) {
                currentNum += 7; // Ensure currentNum is non-negative
            }

            // Check if currentNum is 0 before accessing countMod
            if (currentNum == 0) {
                totalCount++;
            }

            totalCount += countMod[(int) currentNum];
            countMod[(int) currentNum]++;
            
            // Update powerOf10 for the next iteration
            powerOf10 = (powerOf10 * 10) % 7;
        }

        return totalCount;
    }
}