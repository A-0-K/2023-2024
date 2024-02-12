import java.io.*;
import java.util.*;

public class statistics {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] F = new int[256];
		for(int j=0; j<F.length; j++)
			F[j] = Integer.parseInt(st.nextToken());
	
	    double mn = 256, mx = 0, mean = 0, median = 0, sum = 0;
	    int cnt = 0, mode = 0;
	    for(int i=0; i<F.length; i++) {
	        if(F[i]==0) continue;
	        
	        if(mn == 256) mn = i;
	        mx = i;
	        sum += (double)i * F[i];
	        cnt += F[i];
	        if(F[i] > F[mode]) mode = i;
	    }
	    mean = sum / cnt;
	    
	    //cnt: total number of integers being considered
	
	    int first = (cnt+1)/2, second = (cnt+2)/2, cur = 0;
	    for(int i=0; i<F.length; i++) {
	        if(cur<first && cur+F[i]>=first) median += i/2.0;
	        if(cur<second && cur+F[i]>=second) median += i/2.0;
	        cur += F[i];
	    }
	
	    System.out.println(mn + " " + mx + " " + mean + " " + median
			+ " " + (double)mode);
	    br.close();
	}
}