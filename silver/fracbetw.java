import java.io.*;
import java.util.*;
public class fracbetw {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); 
        int[] ret = new int[N];
		for(int k=0; k<N; k++) {  
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			//p/q < a/b < r/s
			long max = q + s;

			for(int b=2; b<=max; b++) {
				long low  = (long)p*b/q; 
				long high = ((long)r*b+s-1)/s; 
				
				if(high > low+1) {
					ret[k] = b;
					break;
				}
			}
		}
        for (int n : ret){
            System.out.println(n);
        }
		br.close();
	}
}