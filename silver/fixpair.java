import java.io.*;
import java.util.*;

public class fixpair {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());   //# of integers
        int[] A = new int[N];    //array of the N integers
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int k=0; k<N; k++)
            A[k] = Integer.parseInt(st.nextToken());
        // Check whether each 1 can be followed by a 2
        int swaps = 0;    //# of swaps needed
        long steps = 0;   //total # of steps needed
        // Check the adjacent integer pairs 1-1 and 1-2
        for(int k=0; k<N-1; k++) {
            if(A[k]==1 && A[k+1]==1) {   //for 1-1 pair, report -1
                swaps = -1;
                steps = -1;
                break;
            }
            if(A[k]==1 && A[k+1]==2) {  //for 1-2 pair, set them to 0
                A[k] = 0;
                A[k+1] = 0;
            }
        }
        if(A[N-1]==1) {
            swaps = -1;
            steps = -1;
        }
        // For each "10", find the closest 2 starting from the beginning.
        int lastLoc = -1;  //the location of the last 2 used in swapping
        if(swaps >= 0) {
            for(int k=0; k<N-1; k++) {
                if(A[k]==1 && A[k+1]!=2) {

                    //swap the first available 2 to position k+1
                    for(int j=lastLoc+1; j<N; j++) {
                        if(A[j]==2) {
                            lastLoc = j;
                            A[j] = 0;
                            A[k+1] = 0;

                            swaps++;
                            steps += Math.abs(k+1-j);
                            break;
                        }
                    }
                }
            }
        }
        if(swaps == -1)
            System.out.println("No");
        else
            System.out.println("Yes");

        System.out.println(swaps);
        System.out.println(steps);
        br.close();
    }
}