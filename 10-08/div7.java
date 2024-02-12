import java.io.*;
import java.util.*;

public final class div7 {
	private static final int MOD = 7;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("div7.in"));
		int cowNum = Integer.parseInt(br.readLine());
		int maxLen = 0;
		// first[i] stores the index of the first time a prefix sum % 7 == i
		int[] first = new int[MOD];
		Arrays.fill(first, -1);
		first[0] = 0;

		int runningMod = 0;
		for (int c = 0; c < cowNum; c++) {
			int cow = Integer.parseInt(br.readLine());
			runningMod = (runningMod + cow) % MOD;
			if (first[runningMod] == -1) {
				first[runningMod] = c;
			} else {
				maxLen = Math.max(maxLen, c - first[runningMod]);
			}
		}
		PrintWriter written = new PrintWriter("div7.out");
        br.close();
		written.println(maxLen);
		written.close();
	}
}