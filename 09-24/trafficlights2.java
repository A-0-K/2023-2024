import java.io.*;
import java.util.*;

public class trafficlights2 {
    static int n;
    static int m;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("03.in"));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int x = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int ret = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(x);
        int[] arr = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }
        int ans = 0;
        int prev = 0;
        for (int curr : set){
            ans = Math.max(ans, curr-prev);
            prev = curr;
        }
        int[] out = new int[n];
        out[n-1] = ans;
        for (int i=n-1; i>0; i--){
            int curr = arr[i];
            set.remove(curr);
            ans = Math.max(set.ceiling(curr)-set.floor(curr), ans);
            out[i-1] = ans;
        }
        for (int i : out){
            ret+=i;
        }
        System.out.println(ret);
        reader.close();
    }
}
