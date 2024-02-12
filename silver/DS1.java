import java.util.*;
public class DS1
{
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
       
        for (int j = 0; j < 6; j++)
        {
            st.push(j);
        }
        //System.out.println(st);
        //System.out.println();
        //System.out.println(st.peek());
        

        for (int j = 0; j<6; j++)
        {
            st.pop();
            //System.out.println(st);
        }

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.push(7); //add to the front
        ad.push(16);
        ad.push(2023);
        System.out.println(ad);

        ad.pop(); //remove from the front
        System.out.println(ad);

        ad.addLast(2024); //append to the end
        System.out.println(ad);

        ad.pollLast(); //remove from the end
        System.out.println(ad);

        //priorityQueue: the element at the front is the smallest
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(7);
        pq.add(2);
        pq.add(16);
        pq.add(2023);
        pq.add(100);
        System.out.println(pq);
		System.out.println(pq.peek());
		
		pq.poll(); //log(n) time
		System.out.println(pq.peek());
    }
}