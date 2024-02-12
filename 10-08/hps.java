import java.io.*;

public class hps {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("hps.in"));

		int n = Integer.parseInt(br.readLine());
		int[] hooves = new int[n + 1];
		int[] paper = new int[n + 1];
		int[] scissors = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			hooves[i] += hooves[i - 1];
			paper[i] += paper[i - 1];
			scissors[i] += scissors[i - 1];

			char action = br.readLine().charAt(0);
			if (action == 'H') {
				paper[i]++;
			} else if (action == 'P') {
				scissors[i]++;
			} else if (action == 'S') {
				hooves[i]++;
			}
		}

		int maxWins = 0;
		for (int i = 1; i <= n; i++) {
			int beforeWins =
			    Math.max(hooves[i], Math.max(paper[i], scissors[i]));
			int afterWins = Math.max(
			    hooves[n] - hooves[i],
			    Math.max(paper[n] - paper[i], scissors[n] - scissors[i]));
			maxWins = Math.max(maxWins, beforeWins + afterWins);
		}

		PrintWriter pw = new PrintWriter("hps.out");
		pw.println(maxWins);
        br.close();
		pw.close();
	}
}