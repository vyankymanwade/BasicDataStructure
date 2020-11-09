import java.io.BufferedReader;
import java.io.InputStreamReader;

class OpenAddressing {
    private int a[];
    private int SIZE;

    public OpenAddressing(int n) {
        SIZE = n;
        a = new int[n];
        for (int i = 0; i < SIZE; i++) {
            a[i] = -1;
        }
    }

    public void insert(int key) {
        int index = hash(key);
        if (a[index] == -1)
            a[index] = key;
        else {
            for (int i = index + 1; i < SIZE; i++) {
                if (a[i] == -1) {
                    a[i] = key;
                    break;
                }
            }
        }
    }

    public boolean search(int key) {
        int index = hash(key);
        if (a[index] == key)
            return true;
        for (int i = 0; i < SIZE; i++) {
            if (a[i] == key)
                return true;
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void delete(int key) {
        int index = hash(key);
        boolean flag = false;
        if (a[index] == key) {
            a[index] = -2;
            flag = true;
        } else {
            for (int i = index + 1; i < SIZE; i++) {
                if (a[i] == key) {
                    a[i] = -2;
                    flag = true;
                    break;
                }
            }
        }
        if (flag == false)
            System.out.println("KEY NOT FOUND");
    }

    public int hash(int key) {
        return (key % SIZE);
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        OpenAddressing o = new OpenAddressing(n);
        o.print();
        o.insert(49);
        o.insert(56);
        o.insert(72);
        o.print();
        System.out.println(o.search(56));
        o.delete(56);
        o.print();
        System.out.println(o.search(56));
        o.print();
    }
}