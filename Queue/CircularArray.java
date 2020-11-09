
public class CircularArray {
    int a[];
    int front, size;
    final int CAPACITY;

    public CircularArray(int capacity) {
        this.CAPACITY = capacity;
        a = new int[CAPACITY];
        size = 0;
        front = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean isFull() {
        return (size == CAPACITY);
    }

    public int getFront() {
        if (isEmpty())
            return -1;
        else
            return a[front];
    }

    public int getBack() {
        if (isEmpty())
            return -1;
        else
            return (a[(front + size - 1) % CAPACITY]);
    }

    public void enqueue(int x) {
        if (isFull())
            return;
        else {
            int rear = (front + size - 1) % CAPACITY;
            rear++;
            a[rear] = x;
            size++;
        }
    }

    public int dequeue() {
        if (isEmpty())
            return -1;
        else {
            int x = a[front];
            front = (front + 1) % CAPACITY;
            size--;
            return x;
        }
    }

    public static void main(String args[]) throws Exception {
        CircularArray c = new CircularArray(5);
        c.enqueue(10);
        c.enqueue(20);
        c.enqueue(30);
        System.out.println(c.dequeue());
        System.out.println(c.dequeue());
        c.enqueue(40);
    }
}