import java.util.*;

public class course {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[N];
        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(b).add(a);
            inDegree[a]++;
        }

        boolean result = canFinishCourses(N, graph, inDegree);
        System.out.println(result);

        if (result) {
            int[] order = findCourseOrder(N, graph, inDegree);
            for (int course : order) {
                System.out.print(course + " ");
            }
        }
        scanner.close();
    }

    private static boolean canFinishCourses(int N, List<List<Integer>> graph, int[] inDegree) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;

            for (int neighbor : graph.get(course)) {
                if (--inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return count == N;
    }

    private static int[] findCourseOrder(int N, List<List<Integer>> graph, int[] inDegree) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            order.add(course);

            for (int neighbor : graph.get(course)) {
                if (--inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = order.get(N - 1 - i);
        }
        return result;
    }
}
