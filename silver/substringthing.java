
import java.io.*;
import java.util.*;


public class substringthing {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();

        ArrayList<String> words = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens())
        {
            String w = st.nextToken();
            words.add(w);
        }

        words.clear();
        for(int j = 0; j < str.length();)
        {
            char ch = str.charAt(j);
            if(ch==' ') {j++; continue;}
            int k = j+1;
            while(k<str.length()&&str.charAt(k)!=' ')
            {
                k++;
            }
            words.add(str.substring(j, k));
            j = k;
        }

        for(int j = words.size()-1; j>=0; j--)
        {
            System.out.print(words.get(j) + " ");
        }
        System.out.println();

    }
}
