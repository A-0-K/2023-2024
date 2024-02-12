//import java.io.*;
import java.util.*;

public class cowntact {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int N = in.nextInt();
       String s = in.next();
       //boolean[] a = new boolean[N];
       boolean[] c = new boolean[N];
       int last = N;
       int res = 0;

       for (int i = N - 1; i >= 0; i--) {
           if (s.charAt(i) == '1') {
               if (last == N) {
                   last = i;
               }
               c[i] = true;
               if (i > 0 && !c[i - 1]) {
                   res++;
               }
           } else {
               last = N;
           }
       }

       System.out.println(res);
       in.close();
   }
}