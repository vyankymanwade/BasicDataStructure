import java.lang.*;
import java.util.*;

class LinearSearch {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int a[] = new int[10];
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        int key = s.nextInt();
        int index = lSearch(a, n, key);
        if (index == -1) {
            System.out.println("Element not found");
        } else
            System.out.println("eleement at :" + index);
    }

    public static int lSearch(int a[], int n, int key) {
        for (int i = 0; i < n; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }
}