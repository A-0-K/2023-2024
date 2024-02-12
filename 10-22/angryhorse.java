import java.io.*;
import java.util.*;

public class angryhorse {
    static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        for (int testCase = 1; testCase <= 10; testCase++) {
            String inputFileName = String.format("%02d.in", testCase);

            // Redirect standard input to read from the file
            System.setIn(new FileInputStream(inputFileName));
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String[] dimensions = reader.readLine().split(" ");
            int N = Integer.parseInt(dimensions[0]);
            int M = Integer.parseInt(dimensions[1]);

            char[][] field = new char[N][M];
            for (int i = 0; i < N; i++) {
                String row = reader.readLine();
                field[i] = row.toCharArray();
            }

            int numHorses = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (field[i][j] == 'G') {
                        // Start a BFS from this grass node
                        Queue<int[]> queue = new LinkedList<>();
                        queue.offer(new int[]{i, j});
                        field[i][j] = 'C'; // Mark it as visited

                        while (!queue.isEmpty()) {
                            int[] curr = queue.poll();

                            for (int k = 0; k < 8; k++) {
                                int x = curr[0] + dx[k];
                                int y = curr[1] + dy[k];

                                if (x >= 0 && x < N && y >= 0 && y < M && field[x][y] == 'G') {
                                    queue.offer(new int[]{x, y});
                                    field[x][y] = 'C'; // Mark it as visited
                                }
                            }
                        }

                        numHorses++; // One horse can cover this connected component
                    }
                }
            }

            // Output the result to System.out
            System.out.println(numHorses);

            reader.close();
        }
    }
}