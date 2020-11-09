import java.lang.*;
import java.util.*;

class InsertionSort {
    public static void main(String args[]) {
        int a[] = { 64, 34, 25, 12, 22, 11, 90 };
        insertionSort(a, 7);
        System.out.println(Arrays.toString(a));
    }

    public static void insertionSort(int a[], int n) {
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
}