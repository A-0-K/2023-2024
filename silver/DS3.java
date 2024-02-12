import java.util.*;
public class DS3 {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
		hm.put("bronze", 1);
		hm.put("silver", 2);
		hm.put("gold", 3);
		hm.put("platinum", 4);
		hm.put("camp", 5);
		hm.put("team", 6);
		hm.put("ioi", 7);
		System.out.println(hm);
		
		TreeMap<String, Integer> tm = new TreeMap<>();
		tm.put("bronze", 1);
		tm.put("silver", 2);
		tm.put("gold", 3);
		tm.put("platinum", 4);
		tm.put("camp", 5);
		tm.put("team", 6);
		tm.put("ioi", 7);
		System.out.println(tm);
		
		tm.put("ioi", 100);
		System.out.println(tm);

		System.out.println(tm.get("camp"));
		System.out.println(tm.lastKey());
		System.out.println(tm.firstKey());
		System.out.println(tm.higherKey("iron"));
    }
}
