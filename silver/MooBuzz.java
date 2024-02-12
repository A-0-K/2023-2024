import java.io.*;
public class MooBuzz {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("moobuzz.in"));
		int N = Integer.parseInt(br.readLine());
		br.close();
		int[] first8 = {14, 1, 2, 4, 7, 8, 11, 13};
		int res = 0;
		// Finds the group
		res = (N - 1) / 8;
		// Group every 15 numbers
		res *= 15;
		// Coresponding leftover
		res += first8[N % 8];
		PrintWriter pw = new PrintWriter("moobuzz.out");
		pw.println(res);
		pw.close();
    }
}
