import java.io.*;
import java.util.*;

public class target2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input T, C, poss, pos, cmd
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] poss = new int[T];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            poss[i] = Integer.parseInt(st.nextToken());
        }

        int pos = 0;
        String cmd = br.readLine();

        // Calculate and output the result
        int result = returnMaxHit(T, C, poss, pos, cmd);
        System.out.println(result);
    }

    public static int returnMaxHit(int T, int C, int[] poss, int pos, String cmd) {
        Set<Integer> targetHitted = new HashSet<>();
        //int posBase;

        // Initial calculation
        //posBase = calculateTargetHitted(targetHitted, C, cmd, pos, poss);

        char[] cmdSet = {'L', 'R', 'F'};
        int maxHit = targetHitted.size();

        // Iterate through each command position and try changing the command
        for (int i = 0; i < cmd.length(); i++) {
            pos = 0;
            String left = cmd.substring(0, i);
            char l = cmd.charAt(i);
            String right = cmd.substring(i + 1);

            for (char lc : cmdSet) {
                Set<Integer> newTargetHitted = new HashSet<>();

                if (lc == l) {
                    continue;
                }

                String leftLc, rightLc;

                if (i == 0) {
                    leftLc = String.valueOf(lc);
                    rightLc = right;
                } else if (i == cmd.length() - 1) {
                    leftLc = left;
                    rightLc = String.valueOf(lc);
                } else {
                    leftLc = left + lc;
                    rightLc = right;
                }

                pos = calculateTargetHitted(newTargetHitted, C, leftLc, pos, poss);
                pos = calculateTargetHitted(newTargetHitted, C, rightLc, pos, poss);
                targetHitted.add(calculateTargetHitted(newTargetHitted, C, leftLc, pos, poss));
                maxHit = Math.max(maxHit, newTargetHitted.size());
            }
        }

        return maxHit;
    }

    public static int calculateTargetHitted(Set<Integer> targetHitted, int C, String cmd, int pos, int[] poss) {
        for (char l : cmd.toCharArray()) {
            if (l == 'L' && pos - 1 >= -C) {
                pos -= 1;
            } else if (l == 'R' && pos + 1 <= C) {
                pos += 1;
            } else if (l == 'F' && contains(poss, pos) && !targetHitted.contains(pos)) {
                targetHitted.add(pos);
            }
        }
        return pos;
    }

    public static boolean contains(int[] array, int key) {
        for (int value : array) {
            if (value == key) {
                return true;
            }
        }
        return false;
    }
}
