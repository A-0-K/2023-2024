import java.io.*;
import java.util.*;

public class HighCard {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
		int n = Integer.parseInt(br.readLine());
		boolean[] elsieOwns = new boolean[2 * n + 1];
		for (int i = 0; i < n; i++) {
			elsieOwns[Integer.parseInt(br.readLine())] = true;
		}
		List<Integer> bessie = new ArrayList<Integer>();
		List<Integer> elsie = new ArrayList<Integer>();
		int points = 0;
		for (int i = 1; i <= n * 2; i++) {
			// If Elsie doesn't have the card:
			if (elsieOwns[i]) {

				elsie.add(i);
			} else {
				bessie.add(i);
			}
		}
		int bessieIndex = 0;
		int elsieIndex = 0;
		while (bessieIndex < n && elsieIndex < n) {
			// If Bessie wins:
			if (bessie.get(bessieIndex) > elsie.get(elsieIndex)) {
				points++;
				bessieIndex++;
				elsieIndex++;
			} 
            // Otherwise, choose the next highest card from Bessie's hand.
            else {
				bessieIndex++;
			}
		}
		pw.println(points);
		pw.close();
        br.close();
	}
}