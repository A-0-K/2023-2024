import java.util.*;
import java.io.*;

public class trafficlights {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("10.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		TreeSet<Integer> lights = new TreeSet<>();
		lights.add(0);
		lights.add(x);
		TreeMap<Integer, Integer> segments = new TreeMap<>();
		segments.put(x, 1);

		long ans = 0;
		st = new StringTokenizer(br.readLine());

		for(int j=0; j<n; j++) {
			int p = Integer.parseInt(st.nextToken());
			int x2 = lights.higher(p);
			int x1 = lights.lower(p);
			int dx = x2 - x1;

			int copy = segments.getOrDefault(dx, 0);
			if(copy==1)
				segments.remove(dx);
			else
				segments.put(dx, copy-1);
			
			copy = segments.getOrDefault(x2-p, 0);
			segments.put(x2-p, copy+1);
			
			copy = segments.getOrDefault(p-x1, 0);
			segments.put(p-x1, copy+1);
			
			ans += segments.lastKey();
			lights.add(p);
		}
        br.close();
		System.out.println(ans);
	}
}