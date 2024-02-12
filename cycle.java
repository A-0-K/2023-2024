import java.io.*;
import java.util.*;

public class cycle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input N and K
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // Input sequence aa
        Set<Integer> aa = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            aa.add(Integer.parseInt(st.nextToken()));
        }

        // Input sequence bb
        Set<Integer> bb = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            bb.add(Integer.parseInt(st.nextToken()));
        }

        int result = maxSame(N, aa, bb);
        System.out.println(result);
    }

    public static int maxSame(int N, Set<Integer> aa, Set<Integer> bb) {
        Set<Integer> nn = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            nn.add(i);
        }

        Set<Integer> notaa = new HashSet<>(nn);
        notaa.removeAll(aa);

        Set<Integer> notbb = new HashSet<>(nn);
        notbb.removeAll(bb);

        Set<Integer> aabb = new HashSet<>(aa);
        aabb.retainAll(bb);

        Set<Integer> notaabb = new HashSet<>(notaa);
        notaabb.retainAll(notbb);

        return aabb.size() + notaabb.size();
    }
}