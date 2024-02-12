import java.io.*;
import java.util.*;

public class majority {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] hayPreferences = new int[N];
            for (int i = 0; i < N; i++) {
                hayPreferences[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer> result = findCommonHayTypes(N, hayPreferences);
            printResult(result);
        }
    }

    private static List<Integer> findCommonHayTypes(int N, int[] hayPreferences) {
        Map<Integer, Integer> counter = new HashMap<>();
        int nmajor = (N + 1) / 2;

        for (int hay : hayPreferences) {
            counter.put(hay, counter.getOrDefault(hay, 0) + 1);
            if (counter.get(hay) >= nmajor) {
                return Collections.singletonList(hay);
            }
        }

        return Collections.emptyList();
    }

    private static void printResult(List<Integer> result) {
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for (int hay : result) {
                System.out.print(hay + " ");
            }
            System.out.println();
        }
    }
}