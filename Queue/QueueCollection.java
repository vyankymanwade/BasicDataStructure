import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueCollection {
    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        System.out.println("after adding 4 element: " + q);
        System.out.println("remove 30: " + q.remove(30));
        System.out.println("after removing 30: " + q);
        System.out.println("after removing front element: " + q.poll()); // poll() will remove front element from queue

        System.out.println("after removing front queue is :" + q);
        q.add(50);
        System.out.println("size after adding 50: " + q.size());

        // Queue Traversal
        Iterator i = q.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
    }
}