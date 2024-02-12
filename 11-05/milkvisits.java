import java.io.*;
import java.util.*;

public class milkvisits {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int farmNum = Integer.parseInt(st.nextToken());
		int queryNum = Integer.parseInt(st.nextToken());

		String farms = br.readLine();

		ArrayList<ArrayList<Integer>> neighbors = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < farmNum; i++){
			neighbors.add(new ArrayList<Integer>());
		}
		for (int f = 0; f < farmNum - 1; f++) {
			StringTokenizer road = new StringTokenizer(br.readLine());
			int f1 = Integer.parseInt(road.nextToken()) - 1;
			int f2 = Integer.parseInt(road.nextToken()) - 1;
			neighbors.get(f1).add(f2);
			neighbors.get(f2).add(f1);
		}
		// Process the tree & detect the different components
		int componentNum = 0;
		int[] component = new int[farmNum];
		Arrays.fill(component, -1);
		for (int f = 0; f < farmNum; f++) {
			// Don't process a farm if it's been visited already
			if (component[f] != -1) { continue; }
			ArrayDeque<Integer> frontier = new ArrayDeque<>();
			frontier.add(f);
			char type = farms.charAt(f);
			while (!frontier.isEmpty()) {
				int curr = frontier.poll();
				// Assign the current component number to the farm
				component[curr] = componentNum;
				for (int n : neighbors.get(curr)) {
					// Visit a neighbor if it's new & is of the same type
					if (farms.charAt(n) == type && component[n] == -1) {
						frontier.add(n);
					}
				}
			}
			componentNum++;
		}
		PrintWriter pw = new PrintWriter("milkvisits.out");
		for (int q = 0; q < queryNum; q++) {
			StringTokenizer query = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(query.nextToken()) - 1;
			int b = Integer.parseInt(query.nextToken()) - 1;
			char milk = query.nextToken().charAt(0);

			if (component[a] == component[b]) {
				/*
				 * If a & b are in the same component,
				 * check if the milk type is the same as the one the farmer
				 * likes
				 */
				pw.print(farms.charAt(a) == milk ? 1 : 0);
			} else {
				// Output 1 otherwise because both milk types will be visited
				pw.print(1);
			}
		}
		br.close();
		pw.close();
	}
}