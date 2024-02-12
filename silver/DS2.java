import java.util.*;
public class DS2 {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
		ts.add(7);
		ts.add(2023);
		ts.add(16);
		System.out.println(ts);
		
		ts.remove(2023);
		System.out.println(ts);
		ts.add(100);

		System.out.println(ts);

		System.out.println(ts.last()); //max value
		System.out.println(ts.first()); //min value
		System.out.println(ts.higher(10)); //16

		System.out.println();
		//do NOT change the value of elements
		//remove the elements from a TreeSet, then make changes, add back to the TreeSet (elements remain sorted)
		
		HashSet<Integer> hs = new HashSet<>();
		hs.add(7);
		hs.add(2023);
		hs.add(16);
		hs.add(7);
		System.out.println(hs);
		
		hs.remove(16);
		System.out.println(hs);
		System.out.println();
		
		//traverse set
		for(Integer x : hs) {
			System.out.print(x + " ");
		}
    }
}
