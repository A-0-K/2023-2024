import java.io.*;
import java.util.*;
public class meeting2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("10.in"));
		int n = Integer.parseInt(br.readLine()); //# of people
		
		int[][] A = new int[n][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int j=0; j<n; j++) //positions
			A[j][0] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int j=0; j<n; j++) //speeds
			A[j][1] = Integer.parseInt(st.nextToken());

		Arrays.sort(A, (p, q)->p[0]-q[0]);
		
		//Find the index j so that meeting place is in [x[j], x[j+1]):
		//   max{ (x[j]-x[k])/v[k], k<=j } <= max{ (x[k]-x[j])/v[k], k>j }
		// but
		//   max{ (x[j+1]-x[k])/v[k], k<=j+1 } > max{ (x[k]-x[j+1])/v[k], k>j+1 }

		//Or find the largest j so that
		//   max{ (x[j]-x[k])/v[k], k<=j } <= max{ (x[k]-x[j])/v[k], k>j }
		int low = 0;
		int high = n-2;
		while(low<high) {
			int mid = (low+high+1)/2;
			
			double m1 = 0; //max traveling time for people on the left (<=mid)
			for(int k=0; k<=mid; k++)
				m1 = Math.max(m1, (A[mid][0]-A[k][0]+.0)/A[k][1]);

			double m2 = 0; //max traveling time for people on the right (>mid)
			for(int k=mid+1; k<n; k++)
				m2 = Math.max(m2, (A[k][0]-A[mid][0]+.0)/A[k][1]);
			
			if(m1>m2) 
				high = mid-1;
			else
				low = mid;
		}
		
		int j = low;

		//Decide what location in [x[j], x[j+1]] to be the meeting place.
		//Or find the largest y in [X[j], x[j+1]) so that
		//   max{ (y-x[k])/v[k], k<=j } <= max{ (x[k]-y)/v[k], k>j }
		low = 0;
		high = 1_000_000_000;
		while(low<high) {
			int mid = (low+high+1)/2;
			
			double x = A[j][0] + mid/1E9 *(A[j+1][0]-A[j][0]);
			
			double m1 = 0;
			for(int k=0; k<=j; k++)
				m1 = Math.max(m1, (x-A[k][0])/A[k][1]);

			double m2 = 0;
			for(int k=j+1; k<n; k++)
				m2 = Math.max(m2, (A[k][0]-x)/A[k][1]);
			
			if(m1>m2) 
				high = mid-1;
			else
				low = mid;
		}

		double x = A[j][0] + low/1E9*(A[j+1][0]-A[j][0]);
		double m1 = 0;
		for(int k=0; k<=j; k++)
			m1 = Math.max(m1, (x-A[k][0])/A[k][1]);

		double m2 = 0;
		for(int k=j+1; k<n; k++)
			m2 = Math.max(m2, (A[k][0]-x)/A[k][1]);
		
		//System.out.println(Math.max(m1, m2));
		System.out.println(m2);
		br.close();
	}
}