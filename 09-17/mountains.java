import java.io.*;
import java.util.*;

public class mountains {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
		int mountainNum = Integer.parseInt(br.readLine());

		Mountain[] mountains = new Mountain[mountainNum];
		for (int m = 0; m < mountainNum; m++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// store the mountains by the interval they cover
			mountains[m] = new Mountain(x - y, x + y);
		}
		Arrays.sort(mountains);

		int rightmost = -1;
		int visibleNum = 0;
		for (Mountain m : mountains) {
			if (m.end > rightmost) {
				visibleNum++;
				rightmost = m.end;
			}
		}

		PrintWriter pw = new PrintWriter("mountains.out");
		pw.println(visibleNum);
		pw.close();
        br.close();
	}
}

class Mountain implements Comparable<Mountain> {
	public int start, end;

	public Mountain(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int compareTo(Mountain other) {
		// sort by start and tiebreak by putting the larger mountains first
		if (this.start != other.start) {
			return Integer.compare(this.start, other.start);
		}
		return Integer.compare(other.end, this.end);
	}
}