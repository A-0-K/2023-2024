import java.io.*;

public class meetingplace {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("10.in"));
        
        int n = Integer.parseInt(br.readLine());
        
        String[] xCoordinates = br.readLine().split(" ");
        String[] speeds = br.readLine().split(" ");
        
        double[] x = new double[n];
        double[] v = new double[n];
        
        for (int i = 0; i < n; i++) {
            x[i] = Double.parseDouble(xCoordinates[i]);
            v[i] = Double.parseDouble(speeds[i]);
        }
        
        double low = 0.0;
        double high = 1e12; // A large upper bound for binary search
        
        while (high - low > 1e-6) {
            double mid = (low + high) / 2;
            
            double leftBound = Double.NEGATIVE_INFINITY;
            double rightBound = Double.POSITIVE_INFINITY;
            
            for (int i = 0; i < n; i++) {
                leftBound = Math.max(leftBound, x[i] - v[i] * mid);
                rightBound = Math.min(rightBound, x[i] + v[i] * mid);
            }
            
            if (leftBound <= rightBound) {
                high = mid;
            } else {
                low = mid;
            }
        }
        
        double result = Math.ceil(low);
        br.close();
        System.out.println(result);
    }
}
