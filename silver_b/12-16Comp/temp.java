import java.io.*;
import java.util.*;
public class temp {
    public static int[] howManyTallerThanI(int[] hh, int[] aa) {
        int[] taller = new int[hh.length];

        for (int i = 0; i < hh.length; i++) {
            for (int j = 0; j < hh.length; j++) {
                if (i == j) {
                    continue;
                }
                if (hh[j] > hh[i]) {
                    taller[i]++;
                }
            }
        }

        return taller;
    }

    public static boolean meetRequirement(int[] taller, int[] tt) {
        for (int i = 0; i < taller.length; i++) {
            if (taller[i] != tt[i]) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> minDay(int[] hh, int[] aa, int[] tt) {
        List<Integer> results = new ArrayList<>();
        
        boolean stopIteration = false;
        int day = 0;
        int nRepeat = 0;
        int[] preTaller = new int[tt.length];
        Arrays.fill(preTaller, -1);

        while (!stopIteration) {
            int[] taller = howManyTallerThanI(hh, aa);

            if (Arrays.equals(taller, preTaller)) {
                nRepeat++;
            }

            boolean meet = meetRequirement(taller, tt);

            if (meet) {
                stopIteration = true;
                results.add(day);
                break;
            }

            preTaller = Arrays.copyOf(taller, taller.length);

            if (nRepeat > 20) {
                stopIteration = true;
                results.add(-1);
                break;
            }

            day++;

            for (int i = 0; i < tt.length; i++) {
                hh[i] += aa[i];
            }
        }

        return results;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        List<Integer> outputs = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] hh = new int[n];
            int[] aa = new int[n];
            int[] tt = new int[n];

            // Read space-separated integers for hh
            String[] hhTokens = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                hh[j] = Integer.parseInt(hhTokens[j]);
            }

            // Read space-separated integers for aa
            String[] aaTokens = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                aa[j] = Integer.parseInt(aaTokens[j]);
            }

            // Read space-separated integers for tt
            String[] ttTokens = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                tt[j] = Integer.parseInt(ttTokens[j]);
            }

            List<Integer> result = minDay(hh, aa, tt);
            outputs.addAll(result);
        }

        // Print the results
        for (int output : outputs) {
            System.out.println(output);
        }
    }
}

