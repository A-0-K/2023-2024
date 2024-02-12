import java.io.*;
import java.util.*;
class Cow {
    int x, y, power;

    Cow(int x, int y, int power) {
        this.x = x;
        this.y = y;
        this.power = power;
    }
}
public class MooCast {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("moocast.out"));

        int n = Integer.parseInt(br.readLine().trim());
        Cow[] cows = new Cow[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int power = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(x, y, power);
        }

        int maxReachableCows = 0;
        for (int i = 0; i < n; i++) {
            maxReachableCows = Math.max(maxReachableCows, dfs(i, cows, new boolean[n]));
        }

        pw.println(maxReachableCows);
        pw.close();
        br.close();
    }

    static int dfs(int currentCow, Cow[] cows, boolean[] visited) {
        visited[currentCow] = true;
        int reachableCows = 1; // Including the current cow

        for (int i = 0; i < cows.length; i++) {
            if (!visited[i] && canReach(cows[currentCow], cows[i])) {
                reachableCows += dfs(i, cows, visited);
            }
        }

        return reachableCows;
    }
    static boolean canReach(Cow source, Cow target) {
        int dx = source.x - target.x;
        int dy = source.y - target.y;
        int distanceSquared = dx * dx + dy * dy;
        return distanceSquared <= source.power * source.power;
    }
}
