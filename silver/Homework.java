import java.io.*;
import java.util.*;

public class Homework {
    public static void main(String[] args) throws IOException {
        // Input and output file handling
        BufferedReader br = new BufferedReader(new FileReader("homework.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("homework.out"));
        // Read the number of questions (n) from the input file
        int n = Integer.parseInt(br.readLine());
        long[] questions = new long[n];
        // Read the scores of each question into the 'questions' array
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            questions[i] = Long.parseLong(input[i]);
        }
        // Variables to keep track of the best selection of questions
        int left = -1;
        int right = n;
        // Arrays to store total scores and minimum scores for each question
        long[] total_score = new long[n];
        long[] min_score = new long[n];
        List<Integer> max_score_values = new ArrayList<>();
        // Initialize total and minimum scores for the last question
        total_score[n - 1] = questions[n - 1];
        min_score[n - 1] = questions[n - 1];
        long curr_question, curr_score, idx;
        
        // Calculate total and minimum scores from the second last question to the second question
        for (int i = n - 2; i > 0; i--) {
            curr_question = questions[i];
            // Calculate sum of scores from index i to N
            total_score[i] = curr_question + total_score[i + 1];
            // Calculate minimum score from scores in indexes i to N
            min_score[i] = Math.min(min_score[i + 1], curr_question);
            // Exclude the least score question to calculate average score
            curr_score = total_score[i] - min_score[i];
            idx = (n - (i + 1));

            // Update 'left', 'right', and 'max_score_values' based on the current scores
            if (curr_score * right > left * idx) {
                left = (int) curr_score;
                right = (int) idx;
                max_score_values = new ArrayList<>();
                max_score_values.add(i);
            } else if (curr_score * right == left * idx) {
                max_score_values.add(i);
            }
        }

        // Sort the list of maximum score values
        Collections.sort(max_score_values);

        // Write the selected question indices with maximum scores to the output file
        for (int k : max_score_values) {
            pw.println(k);
        }

        // Close the file readers and writers
        pw.close();
        br.close();
    }
}
