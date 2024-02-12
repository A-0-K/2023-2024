import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class subarray {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("10.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken()); 

		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int j=0; j<N; j++)
			A[j] = Integer.parseInt(st.nextToken());

	    long[] sb = new long[N+1];
	    for(int i=1; i<=N; i++)
			sb[i] = sb[i-1] + A[i-1];

	   	int ans = Integer.MAX_VALUE;
	    ArrayDeque<Integer> arr = new ArrayDeque<>();

	    for(int i=0; i<=N; i++) {
	        while(!arr.isEmpty() && sb[i] - sb[arr.getFirst()] >= T) {
	            ans = min(ans, i-arr.removeFirst());
	        }
	
	        while(!arr.isEmpty() && sb[i] <= sb[arr.getLast()]) {
	            arr.removeLast();
	        }
	
	        arr.add(i);
	    }
	    if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
	    br.close();
	}
}