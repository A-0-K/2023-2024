import java.io.*;
import java.util.*;
public class sumdivp {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int j=0; j<N; j++)
			A[j] = Integer.parseInt(st.nextToken());
		br.close();

		int[] mod = new int[N+1];
	    for(int i=0; i<N; i++) {
	        mod[i+1] = ((mod[i] + A[i]) % P + P) % P;
	    }

	    int ans = 0;
	    if(mod[N] != 0) {
		    HashMap<Integer, Integer> map = new HashMap<>();
		    map.put(0, 0);
		    int res = N;
		    for(int i=1; i<=N; i++){
		        int temp = ((mod[i] -  mod[N]) % P + P) % P;
		        if(map.containsKey(temp)){
		            int len = i - map.get(temp);
		            res = Math.min(len, res);
		        }
		        map.put(mod[i], i);
	
		    }
		    ans = (res==N ? -1 : res);
	    }
	    System.out.println(ans);
	}
}