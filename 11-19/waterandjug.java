import java.io.*;
import java.util.*;

public class waterandjug {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Q = Integer.parseInt(br.readLine()); //# of queries
		int ans = 0;
		while(Q-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			if(z==0 || x+y>=z && z%gcd(x, y)==0)
				ans++;
		}
		System.out.println(ans);
		br.close();
	}
	
	static int gcd(int m, int n) {
		if(m==0 || n==0) return m+n;
		return gcd(n, m%n);
	}
}
