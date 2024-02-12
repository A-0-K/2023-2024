import java.io.*;
import java.util.*;
public class TwoThreeFive {
static HashSet<Integer> hm = new HashSet<>();
    public static void main(String[] args) throws IOException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader("02.in"));
        int q = Integer.parseInt(reader.readLine()); // Number of queries
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        hm.add(1);
        for (int i = 0; i < q; i++) {
            int n = Integer.parseInt(reader.readLine()); // n-th number

            int count = 0;
            int number = 1;

            while (count < n) {
                if (isTwoThreeFiveNumber(number)) {
                    count++;
                }
                number++;
            }

            ad.addLast(number - 1);
        }
        PrintWriter out = new PrintWriter(new File("022.out"));
        for (Integer i : ad){
            //System.out.println(i);
            out.println(i);
        }
        out.close();
        reader.close();
    }

    // Check if a number is a 2-3-5 number
    private static boolean isTwoThreeFiveNumber(int number) {
        if (number %2==0 && hm.contains(number/2)){
            hm.add(number);
            return true;
        }
        if (number %3==0 && hm.contains(number/3)){
            hm.add(number);
            return true;
        }
        if (number %5==0 && hm.contains(number/5)){
            hm.add(number);
            return true;
        }
        while (number % 2 == 0) {
            number /= 2;
        }

        while (number % 3 == 0) {
            number /= 3;
        }

        while (number % 5 == 0) {
            number /= 5;
        }

        return number == 1;
    }
}

