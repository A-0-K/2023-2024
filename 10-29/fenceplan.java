import java.io.*;
import java.util.*;

public class fenceplan {
    static final int MAX_N = 100000;
    
    static int N, M;
    static List<cow> C = new ArrayList<>();
    static int[] moonet = new int[MAX_N];
    static ArrayList<ArrayList<Integer>> nbrs = new ArrayList<ArrayList<Integer>>();
    static class cow {
        int x1, x2, y1, y2;

        public cow(int x1, int x2, int y1, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
    }

    // Reursively visit cow i in moonet k with bounding box cow
    static void visit(int i, int k, cow cow) {
        moonet[i] = k;
        cow.x1 = Math.min(cow.x1, C.get(i).x1);
        cow.x2 = Math.max(cow.x2, C.get(i).x2);
        cow.y1 = Math.min(cow.y1, C.get(i).y1);
        cow.y2 = Math.max(cow.y2, C.get(i).y2);
        for (int j : nbrs.get(i)) {
            if (moonet[j] == 0)
                visit(j, k, cow);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter fout = new PrintWriter(new FileWriter("fenceplan.out"));
        for(int i = 0; i < MAX_N; i++){
            nbrs.add(new ArrayList<Integer>());
        }
        String[] NM = fin.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        for (int i = 0; i < N; i++) {
            String[] coordinates = fin.readLine().split(" ");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            C.add(new cow(x, x, y, y));
        }

        for(int i = 0; i < N; i++){
            nbrs.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            String[] pair = fin.readLine().split(" ");
            int a = Integer.parseInt(pair[0]) - 1;
            int b = Integer.parseInt(pair[1]) - 1;
            nbrs.get(a).add(b);
            nbrs.get(b).add(a);
        }

        int K = 0;
        int best = 999999999;

        for (int i = 0; i < N; i++) {
            if (moonet[i] == 0) {
                cow cow = new cow(999999999, 0, 999999999, 0);
                visit(i, ++K, cow);
                best = Math.min(best, 2 * (cow.x2 - cow.x1 + cow.y2 - cow.y1));
            }
        }
        fin.close();
        //fout.println(best);
        System.out.println(best);
        fout.close();
    }
}
