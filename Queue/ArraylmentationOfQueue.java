class QueueExample {
    int size;
    final int CAPACITY;
    int a[];

    public QueueExample(int capacity) {
        this.CAPACITY = capacity;
        a = new int[CAPACITY];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean isFull() {
        return (size == CAPACITY);
    }

    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        } else {
            a[size] = x;
            size++;
        }
    }

    public int dequeue() {
        int temp;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            temp = a[0];
            for (int i = 0; i < size - 1; i++) {
                a[i] = a[i + 1];
            }
            size--;
        }
        return temp;
    }

    public int getFront() {
        if (isEmpty())
            return -1;
        else
            return a[0];
    }

    public int getBack() {
        if (isEmpty())
            return -1;
        else
            return a[size - 1];
    }

    public static void main(String args[]) throws Exception {
        QueueExample q = new QueueExample(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println("element removed: " + q.dequeue());
        System.out.println("element removed: " + q.dequeue());
        q.enqueue(40);
        System.out.println("element removed: " + q.dequeue());
    }
}