import java.io.*;

public class trapwater {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] elevationStr = br.readLine().split(" "); // Use space as a delimiter
        int[] elevation = new int[N];
        for (int i = 0; i < N; i++) {
            elevation[i] = Integer.parseInt(elevationStr[i]);
        }

        int left = 0, right = N - 1;
        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            if (elevation[left] < elevation[right]) {
                if (elevation[left] > leftMax) {
                    leftMax = elevation[left];
                } else {
                    trappedWater += leftMax - elevation[left];
                }
                left++;
            } else {
                if (elevation[right] > rightMax) {
                    rightMax = elevation[right];
                } else {
                    trappedWater += rightMax - elevation[right];
                }
                right--;
            }
        }

        System.out.println(trappedWater);
    }
}
