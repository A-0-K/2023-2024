import java.io.*;
import java.util.*;

public class targetpractice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input T and C
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // Input target locations
        int[] targets = new int[T];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        // Input command string
        String commands = br.readLine();

        // Output the result
        int maxTargets = findMaxTargets(T, C, targets, commands);
        System.out.println(maxTargets);
    }

    public static int findMaxTargets(int T, int C, int[] targets, String commands) {
        int maxTargets = 0;

        // Simulate Bessie's actions and count the initial number of targets hit
        int currentPos = 0;
        boolean[] hitTargets = new boolean[T];
        for (int i = 0; i < C; i++) {
            char command = commands.charAt(i);
            if (command == 'F' && !hitTargets[currentPos]) {
                hitTargets[currentPos] = true;
                maxTargets++;
            } else if (command == 'L') {
                currentPos = Math.max(currentPos - 1, 0); // Ensure the position is non-negative
            } else if (command == 'R') {
                currentPos++;
            }
        }

        // Try changing each command to a different command and check if it improves the result
        for (int i = 0; i < C; i++) {
            char originalCommand = commands.charAt(i);

            // Try changing the command to 'F' and simulate Bessie's actions
            commands = commands.substring(0, i) + 'F' + commands.substring(i + 1);
            currentPos = 0;
            hitTargets = new boolean[T];
            int targetsHit = 0;

            for (int j = 0; j < C; j++) {
                char command = commands.charAt(j);
                if (command == 'F' && !hitTargets[currentPos]) {
                    hitTargets[currentPos] = true;
                    targetsHit++;
                } else if (command == 'L') {
                    currentPos = Math.max(currentPos - 1, 0); // Ensure the position is non-negative
                } else if (command == 'R') {
                    currentPos++;
                }
            }

            // Update the maximum number of targets hit
            maxTargets = Math.max(maxTargets, targetsHit);

            // Restore the original command for the next iteration
            commands = commands.substring(0, i) + originalCommand + commands.substring(i + 1);
        }

        return maxTargets;
    }
}