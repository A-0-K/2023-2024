//import java.util.*;

public class sorting {
    public static void main(String[] args) {
        int[] A = {7, 2, 1, 30, 4, 5, 6, 8, 10};
        for(int k=0; k<A.length-1; k++) {
            for(int j=0; j<A.length-1-k; j++) {
                if(A[j]>A[j+1]) {
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }

        for (int x : A)
        {
            System.out.print(x + " ");
        }
        /*
        int[] B = {7, 2, 1, 30, 4, 5, 6, 8, 10};
        Arrays.sort(B);
        for (int x : B)
        {
            System.out.println(x);
        }
        */
    }
}
