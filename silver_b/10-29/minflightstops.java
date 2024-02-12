import java.io.*;
import java.util.*;

public class minflightstops {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        List<List<Integer>> flights = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            flights.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] ft = reader.readLine().split(" ");
            int from = Integer.parseInt(ft[0]);
            int to = Integer.parseInt(ft[1]);
            flights.get(from).add(to);
        }

        String[] srcDst = reader.readLine().split(" ");
        int src = Integer.parseInt(srcDst[0]);
        int dst = Integer.parseInt(srcDst[1]);

        int stops = minStops(flights, src, dst);
        System.out.println(stops);
    }

    public static int minStops(List<List<Integer>> flights, int src, int dst) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int stops = 0;

        queue.offer(src);
        visited.add(src);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currCity = queue.poll();
                if (currCity == dst) {
                    return stops;
                }
                for (int neighbor : flights.get(currCity)) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            stops++;
        }

        return -1; // No route found
    }
}
