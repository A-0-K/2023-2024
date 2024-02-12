import java.io.*;
import java.util.*;
public class NoCarryOver {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();  //integer n1
		String s2 = br.readLine();  //integer n2

		//the right-most digit of n1 is at num1[0]
		ArrayList<Integer> num1 = new ArrayList<>();
		for(int j=0; j<s1.length(); j++)
			num1.add(s1.charAt(s1.length()-1-j) - '0');

		//put the digits of n2 to num2, starting the right-most digit
		ArrayList<Integer> num2 = new ArrayList<>();
		for(int j=0; j<s2.length(); j++)
			num2.add(s2.charAt(s2.length()-1-j) - '0');

		ArrayList<Integer> sum = add(num1, num2);
		for(int j=sum.size()-1; j>=0; j--)
			System.out.print(sum.get(j));
		System.out.println();
		
		ArrayList<Integer> prod = times(num1, num2);
		for(int j=prod.size()-1; j>=0; j--)
			System.out.print(prod.get(j));
		System.out.println();
		
		br.close();
	}

	//num1 contains the digits of integer n1, but the digits are stored backwards.
	//num2 contains the digits of integer n2, but the digits are stored backwards.
	static ArrayList<Integer> add(ArrayList<Integer> num1, ArrayList<Integer> num2) {
		ArrayList<Integer> sum = new ArrayList<Integer>();
		int n = Math.max(num1.size(), num2.size());
		
		for(int j=0; j<n; j++) {
			int d1 = 0, d2 = 0;
			if(j<num1.size()) d1 = num1.get(j);
			if(j<num2.size()) d2 = num2.get(j);
			
			sum.add((d1+d2)%10);
		}

		return sum;
	}
	
	//multiplication without carry over
	static ArrayList<Integer> times(ArrayList<Integer> num1, ArrayList<Integer> num2) {
		//multiples of n1
		ArrayList<ArrayList<Integer>> multiples = new ArrayList<>();
		for(int j=0; j<10; j++)
			multiples.add(new ArrayList<Integer>());
		
		multiples.set(1, num1);
		for(int j=2; j<10; j++)
			multiples.set(j, add(multiples.get(j-1), num1));
		
		ArrayList<Integer> prod = new ArrayList<>();
		int n2 = num2.size();

		//# of positions shifted (or the leading zeros)
		ArrayList<Integer> shift = new ArrayList<>(); 
		for(int j=0; j<n2; j++) {
			int t = num2.get(j);

			//the j-th row in the long multiplication
			ArrayList<Integer> nextRow = new ArrayList<>();
			nextRow.addAll(shift); 
			nextRow.addAll(multiples.get(t));
			
			prod = add(prod, nextRow);
			
			shift.add(0);
		}
		return prod;
	}
}