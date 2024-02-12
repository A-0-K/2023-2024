//import java.io.*;
import java.util.*;

public class ninetynine {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String cards = "0123456789TJQKA";
		
		ArrayList<ArrayList<Integer>> orig = new ArrayList<>();
		orig.add(new ArrayList<>());
		orig.add(new ArrayList<>());
		
		for(int j=0; j<5; j++) {
			char ch = in.next().charAt(0);
			orig.get(0).add(cards.indexOf(ch));
		}
		Collections.sort(orig.get(0));

		for(int j=0; j<5; j++) {
			char ch = in.next().charAt(0);
			orig.get(1).add(cards.indexOf(ch));
		}
		Collections.sort(orig.get(1));

		for(int i=0; i<5; i++) { //5 rows from the input
			ArrayList<ArrayList<Integer>> p = new ArrayList<>();
			p.add(new ArrayList<>());
			p.add(new ArrayList<>());
			p.get(0).addAll(orig.get(0));
			p.get(1).addAll(orig.get(1));
			
			int[] A = new int[11];
			for(int j=0; j<11; j++) {
				String tmp = in.next();
				if(j==0)
					A[j] = Integer.parseInt(tmp.substring(0, tmp.length()-1));
				else
					A[j] = cards.indexOf(tmp.charAt(0));
			}
				
			int total = A[0];
			
			for(int j=0; j<11; j++) {
				total = add(total, p.get(j%2).get(2));
				if(total>99) {
					System.out.println(total + ", Player #" + (2-j%2));
					break;
				}
				
				p.get(j%2).remove(2);
				p.get(j%2).add(A[j+1]);
				Collections.sort(p.get(j%2));
			}
		}

		in.close();
	}
	
	static int add(int total, int card) {
		int ans = total;
		if(card==9)
			;
		else if(card==10)
			ans -= 10;
		else if(card==7) {
			if(ans+7<=99)
				ans += 7;
			else
				ans += 1;
		}
		else
			ans += card;
		
		if(total<=33 && ans>=34 || total>=34 && ans<=33)
			ans += 5;
		
		if(total<=55 && ans>=56 || total>=56 && ans<=55)
			ans += 5;

		if(total<=77 && ans>=78 || total>=78 && ans<=77)
			ans += 5;
		return ans;
	}
}