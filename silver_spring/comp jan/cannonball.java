import java.io.*;
import java.util.*;

public class cannonball {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int startLocation = Integer.parseInt(st.nextToken());

        int[][] locations = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            locations[i][0] = Integer.parseInt(st.nextToken());
            locations[i][1] = Integer.parseInt(st.nextToken());
        }

        int targetsBroken = jumpGame(n, startLocation, locations);
        System.out.println(targetsBroken);
    }

    private static int jumpGame(int n, int startLocation, int[][] locations) {
        int targetsBroken = 0;
        int currentLocation = startLocation - 1;
        int currentPower = 1;
        int forward = 1;

        while (true) {
            if (locations[currentLocation][0] == 1 && currentPower >= locations[currentLocation][1]) {
                targetsBroken++;
            }

            if (locations[currentLocation][0] == 0) {
                currentPower += locations[currentLocation][1];
                forward *= -1;
            }

            currentLocation += forward * currentPower;

            if (currentLocation < 0 || currentLocation >= n) {
                break;
            }
        }

        return targetsBroken;
    }
}
