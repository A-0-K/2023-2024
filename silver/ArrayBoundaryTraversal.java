import java.util.*;
//import java.io.*;
import static java.lang.Math.*;

public class ArrayBoundaryTraversal {

	public static void main(String[] args) {
		Random gen = new Random(2023);
		int m = 5, n = 6;
		int[][] A = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				A[i][j] = gen.nextInt(20);
		}

		// Rows from top to bottom
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(A[i][j] + " ");
			System.out.println();
		}
		System.out.println();

		// Columns from left to right
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++)
				System.out.print(A[i][j] + " ");
			System.out.println();
		}
		System.out.println();

		// Traverse along the anti-diagonals
		// s = r + c (sum of the row and column indices)
		for (int s = 0; s < m + n - 1; s++) {
			for (int c = max(0, s - m + 1); c <= min(s, n - 1); c++)
				System.out.print(A[s - c][c] + " ");
			System.out.println();
		}

		// Traverse along the diagonals
		for (int s = n-1; s >=-(m-1); s--) {
			for (int r = max(0, -s); r <= min(m-1, n-1-s); r++)
				System.out.print(A[r][s + r] + " ");
			System.out.println();
		}
	}
}
