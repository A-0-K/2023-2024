import java.io.*;
import java.util.*;
import static java.lang.Math.*;
public class fixpair2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());   //# of integers
		int[] A = new int[N];    //array of the N integers
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int k = 0; k < N; k++)
			A[k] = Integer.parseInt(st.nextToken());
		
		//list of locations of 1's and 2's
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		for(int j = 0; j < N; j++) {
			if(A[j] == 1)
				list1.add(j);
			else if(A[j] == 2)
				list2.add(j);
		}
		
		boolean pair1 = false;
		int swaps = 0;
		for(int j = 1; j < N; j++) {
			if(A[j] == 1 && A[j - 1] == 1) 
				pair1 = true;
			if(A[j] != 2 && A[j - 1] == 1)
				swaps++;
		}

		boolean check = pair1 || (A[N - 1] == 1);
		long steps = 0; //total # of steps of the swaps
		if(!check) {
			for(int k = 0; k < list1.size(); k++)
				steps += abs(list1.get(k) + 1 - list2.get(k));
		}
		
		if (check) {
			System.out.println("No");
			System.out.println("-1");
			System.out.println("-1");
		} else {
			System.out.println("Yes");
			System.out.println(swaps);
			System.out.println(steps);
		}
		int onesCount = 0;

		for (int num : A) {
			if (num == 1) {
				onesCount++;
			}
		}
		
		int[] sortedA = new int[N];
		int onesIndex = 0;
		int twosIndex = onesCount;

		for (int num : A) {
			if (num == 1) {
				sortedA[onesIndex] = num;
				onesIndex++;
			} else if (num == 2) {
				sortedA[twosIndex] = num;
				twosIndex++;
			}
		}

		// Print the sorted list A
		for (int num : sortedA) {
			System.out.print(num + " ");
		}

		br.close();
	}
}