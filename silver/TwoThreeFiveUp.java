import java.io.*;

public class TwoThreeFiveUp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("02.in"));
        int q = Integer.parseInt(reader.readLine()); // Number of queries

        int[] uglyNumbers = new int[1500];
        uglyNumbers[0] = 1;

        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;

        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        for (int i = 1; i < 1500; i++) {
            int nextUglyNumber = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            uglyNumbers[i] = nextUglyNumber;

            if (nextUglyNumber == nextMultipleOf2) {
                index2++;
                nextMultipleOf2 = uglyNumbers[index2] * 2;
            }

            if (nextUglyNumber == nextMultipleOf3) {
                index3++;
                nextMultipleOf3 = uglyNumbers[index3] * 3;
            }

            if (nextUglyNumber == nextMultipleOf5) {
                index5++;
                nextMultipleOf5 = uglyNumbers[index5] * 5;
            }
        }
        PrintWriter out = new PrintWriter(new File("022.out"));
        for (int i = 0; i < q; i++) {
            int n = Integer.parseInt(reader.readLine()); // n-th number
            //System.out.println(uglyNumbers[n - 1]);
            out.println(uglyNumbers[n - 1]);
        }
        out.close();
        reader.close();
    }
}
