import java.io.*;
import java.util.*;

public class maxcross {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("maxcross.in"));
		PrintWriter pw = new PrintWriter("maxcross.out");
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[] signals = new int[n + 1];
		int[] presum = new int[n + 1];

		// input broken signals
		for (int i = 0; i < b; i++) { signals[Integer.parseInt(br.readLine())]++; }

		// prefix sums precomputation
		for (int i = 0; i < n; i++) { presum[i + 1] = signals[i + 1] + presum[i]; }

		int ret = n + 1;
		// find the answer
		for (int i = 0; i <= n - k; i++) {
			ret = Math.min(ret, presum[i + k] - presum[i]);
		}
        br.close();
		pw.println(ret);
		pw.close();
	}
}