import java.io.*;
import java.util.*;

public class bacteria {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int npatch = Integer.parseInt(br.readLine());
        int[] bacteriaLevels = new int[npatch];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < npatch; i++) {
            bacteriaLevels[i] = Integer.parseInt(st.nextToken());
        }

        int result = makeHealthy(npatch, bacteriaLevels);
        System.out.println(result);
    }

    private static int makeHealthy(int npatch, int[] bacteriaLevels) {
        int napplications = 0;

        for (int i = 0; i < npatch - 1; i++) {
            napplications += Math.abs(bacteriaLevels[i]);

            for (int j = i + 1; j < npatch; j++) {
                bacteriaLevels[j] -= (j - i + 1) * bacteriaLevels[i];
            }
        }

        napplications += Math.abs(bacteriaLevels[npatch - 1]);
        return napplications;
    }
}
