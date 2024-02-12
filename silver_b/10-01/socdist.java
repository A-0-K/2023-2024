import java.io.*;
import java.util.*;

public class socdist {
	static class Pair implements Comparable<Pair> {
		long first, second;

		public Pair(long x, long y) {
			first = x;
			second = y;
		}

		public int compareTo(Pair x) {
			if (this.first == x.first) return (int)(this.second - x.second);
			return (int)(this.first - x.first);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("socdist.in"));
		PrintWriter pw = new PrintWriter("socdist.out");
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Pair intervals[] = new Pair[m];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			intervals[i] = new Pair(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		}

		Arrays.sort(intervals);
		long lo = 0;
		long hi = intervals[m - 1].second - intervals[0].first + 1;
		while (lo < hi) {
			long mid = lo + (hi - lo + 1) / 2;
			int count = 1;
			int intervalCount = 0;
			long current = intervals[0].first;
			// try to fit the next cow into the earliest patch of grass that's
			// available
			while (current + mid <= intervals[m - 1].second) {
				while (current + mid > intervals[intervalCount].second) {
					intervalCount++;
				}
				current =
				    Math.max(intervals[intervalCount].first, current + mid);
				count++;
				if (count == n) break;
			}
			if (count >= n) lo = mid;
			else hi = mid - 1;
		}
        br.close();
		pw.println(lo);
		pw.close();
	}
}
