import java.util.*;
import java.io.*;
public class bovine {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input N, M, and K
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        // Input weights and counts of cows
        List<Pair> wwaas = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(tokenizer.nextToken());
            int count = Integer.parseInt(tokenizer.nextToken());
            wwaas.add(new Pair(weight, count));
        }
        wwaas.sort(Comparator.comparingInt(pair -> -pair.weight));
        List<Integer> wwaasList = convertToList(wwaas);
        List<Integer> starts = new ArrayList<>();
        int npre = 0;
        for (Pair pair : wwaas){
            starts.add(npre);
            npre += (pair.count);
        }
        /* 
        for (int c : starts){
            System.out.println(c);
        }
        */
        int total = fillTower(M, K, wwaasList, starts);
        
        System.out.println(total);
    }

    static List<Integer> convertToList(List<Pair> wwaas) {
        List<Integer> ret = new ArrayList<>();
        
        for (Pair pair : wwaas) {
            for (int c = 0; c < pair.count; c++) {
                ret.add(pair.weight);
            }
            
        }
        return ret;
    }

    static int fillTower(int M, int K, List<Integer> wwaasList, List<Integer> starts) {
        List<Integer> previousLayer = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            previousLayer.add(wwaasList.get(0) + K);
        }

        int index = 0;
        int indstart = 0;
        List<Integer> tower = new ArrayList<>();
        int total = 0;
        for(int wi = 0; wi < wwaasList.size();){
            if (wwaasList.get(wi) <= previousLayer.get(index) - K) {
                tower.add(wwaasList.get(wi));
                total++;
                index++;
                wi++;
                if (index == M) {
                    index = 0;
                    previousLayer = new ArrayList<>(tower);
                    tower.clear();
                }
                if (wi > starts.get(indstart)){
                    if((indstart+1 < starts.size())&&(wi > starts.get(indstart+1))){
                        indstart++;
                    }
                }
            }
            else {
                indstart++;
                if (indstart < starts.size()){
                    wi = starts.get(indstart);
                }
                else{
                    break;
                }
            }
        }

        return total;
    }

    static class Pair {
        int weight;
        int count;

        public Pair(int weight, int count) {
            this.weight = weight;
            this.count = count;
        }
    }
}