import java.util.*;

class DequeExample {
    public static void main(String args[]) {
        Deque<Integer> dq = new LinkedList<Integer>();

        // Below methods throws exception when something went wrong
        dq.addFirst(10);
        dq.addFirst(20);
        dq.addLast(30);
        dq.addLast(40);
        System.out.println("after adding 4 element: " + dq);
        dq.removeLast();
        dq.removeFirst();
        System.out.println("after removing first and last: " + dq);
        System.out.println("first element: " + dq.getFirst());
        System.out.println("last element: " + dq.getLast());

        // Below methods DOES NOT throws exception when something went wrong
        Deque<Integer> dq1 = new LinkedList<Integer>();
        dq1.offerFirst(10);
        dq1.offerFirst(20);
        dq1.offerLast(30);
        dq1.offerLast(40);
        System.out.println("after adding 4 element: " + dq1);
        dq1.pollFirst();
        dq1.pollLast();
        System.out.println("after removing first and last: " + dq1);
        System.out.println("first element: " + dq1.peekFirst());
        System.out.println("last element: " + dq1.peekLast());
    }
}