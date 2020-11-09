
public class LinkedListImplementation {
    Node front, rear;
    int size;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public int getFront() {
        if (front == null)
            return -1;
        else {
            return front.data;
        }
    }

    public int getBack() {
        if (front == null)
            return -1;
        else {
            return rear.data;
        }
    }

    public void enqueue(Node newNode) {
        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public int dequeue() {
        if (front == null)
            return -1;
        else {
            int x = front.data;
            front = front.next;
            size--;
            return x;
        }

    }

    public void print() {
        if (front == null)
            return;
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        LinkedListImplementation ll = new LinkedListImplementation();
        ll.enqueue(new Node(10));
        ll.enqueue(new Node(20));
        ll.enqueue(new Node(30));
        System.out.println("size(): " + ll.size);
        System.out.println(ll.getFront());
        ll.dequeue();
        ll.dequeue();
        ll.enqueue(new Node(40));
        ll.print();
        System.out.println(ll.getBack());
        System.out.println("size(): " + ll.size);
    }

}