import java.util.Scanner;

class MinHeap {
    int a[], size, capacity;

    public MinHeap(int capcity, int size) {
        this.capacity = capacity;
        a = new int[capcity];
        this.size = size;
    }

    public void insert(int data) {
        if (size == capacity)
            return;
        size++;
        a[size - 1] = data;
        for (int i = size - 1; i != 0 && a[parent(i)] > a[i];) {
            int temp = a[parent(i)];
            a[parent(i)] = a[i];
            a[i] = temp;

            i = parent(i);
        }
    }

    public int parent(int i) {
        return ((i - 1) / 2);
    }

    public int left(int i) {
        return (i * 2 + 1);
    }

    public int right(int i) {
        return (i * 2 + 2);
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public int extract() {
        if (size == 0)
            return Integer.MAX_VALUE;
        if (size == 1) {
            size--;
            return a[0];
        }
        int temp = a[0];
        a[0] = a[size - 1];
        size--;
        minHeapify(0);
        return temp;
    }

    public void minHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int minimum = i;
        if (left < size && a[left] < a[i])
            minimum = left;
        if (right < size && a[right] < a[minimum])
            minimum = right;
        if (minimum != i) {
            int temp = a[minimum];
            a[minimum] = a[i];
            a[i] = temp;
            minHeapify(minimum);
        }
    }

    public int getMin() {
        return (a[0]);
    }

    public void decreaseKey(int index, int data) {
        a[index] = data;
        for (int i = index; i != 0 && a[parent(i)] > a[i];) {
            int temp = a[parent(i)];
            a[parent(i)] = a[i];
            a[i] = temp;

            i = parent(i);
        }
    }

    public void delete(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        extract();
    }

    public void buildHeap() {
        for (int i = (this.size - 2) / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        MinHeap mh = new MinHeap(10, 8);
        for (int i = 0; i < 8; i++)  // input-- 10 20 15 40 50 100 25 45
            mh.a[i] = s.nextInt();
        mh.print(); // 10 20 15 40 50 100 25 45 0 0
        mh.insert(12);
        mh.print(); // 10 12 15 20 50 100 25 45 40 0

        MinHeap mh1 = new MinHeap(10, 10); // input -- 20 25 30 35 40 80 32 100 70 60
        for (int i = 0; i < 10; i++)
            mh1.a[i] = s.nextInt();
        System.out.print("before heapify: ");
        mh1.print();
        mh1.minHeapify(0); // assuming the root node is voilating the heap preperty
        System.out.print("after heapify: ");
        mh1.print();
        System.out.println("Minimim from heap: " + mh1.getMin());
        System.out.println("Etracted min: " + mh1.extract());
        System.out.print("after extracting min: ");
        mh1.print();
        mh1.decreaseKey(8, 10);
        System.out.print("after decreasing key at 8 to 10: ");
        mh1.print();
        mh1.delete(3);
        System.out.print("after deleting key at 3: ");
        mh1.print();

        MinHeap mh2 = new MinHeap(10, 6); // input -- 10 5 20 2 4 8
        for (int i = 0; i < 6; i++)
            mh2.a[i] = s.nextInt();

        mh2.buildHeap();
        System.out.println("aftre building Heap: ");

        mh2.print();

    }
}