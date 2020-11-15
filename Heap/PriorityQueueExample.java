import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    static class CompareInt implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }

    }

    public static void main(String args[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(10);
        pq.add(30);
        pq.add(15);
        pq.add(45);
        pq.add(5);
        System.out.println("After adding 5 element: " + pq);
        System.out.println("Is queue contains 2: " + pq.contains(2));
        System.out.println("Is queue contains 10: " + pq.contains(10));

        // iterating over priority queue using iterator
        Iterator it = pq.iterator();
        while (it.hasNext())
            System.out.print(it.next() + " ");
        System.out.println();

        pq.remove();
        System.out.println("after removing : " + pq);
        pq.offer(55); // offer is similar to add() but only differnce is it DOES NOT THROWS EXCEPTION
                      // if something goes wrong
        System.out.println("after adding 55: " + pq);
        System.out.println("element(): " + pq.element()); // gives head without removing
        System.out.println("isEmpty(): " + pq.isEmpty());
        System.out.println("pq.toString(): " + pq.toString());
        System.out.println("pq.peek(): " + pq.peek()); // get head
        System.out.println("pq.poll(): " + pq.poll()); // remove head and something went wrong it does not throws
                                                       // EXception
        pq.clear();
        System.out.println("after clear(): " + pq);
        // using comparator for specific insert
        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(new CompareInt());
        pq1.add(10);
        pq1.add(30);
        pq1.add(15);
        pq1.add(45);
        pq1.add(5);
        System.out.println("After adding 5 element: " + pq1);
        System.out.println("pq1.containsAll(pq): " + pq1.containsAll(pq));
        pq1.clear();
        System.out.println("after clear(): " + pq1);

        // using Collections.reverseOrder() in PriorityQueue constructor
        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(Collections.reverseOrder());
        pq2.add(10);
        pq2.add(30);
        pq2.add(15);
        pq2.add(45);
        pq2.add(5);
        System.out.println("After adding 5 element: " + pq2);
        pq2.clear();
        System.out.println("after clear(): " + pq2);
    }
}