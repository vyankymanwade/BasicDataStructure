import java.util.*;

public class SelectionSort {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int a[] = { 64, 34, 25, 12, 22, 11, 90 };
        selectionSort(a, 7);
        System.out.println(Arrays.toString(a));
    }

    public static void selectionSort(int a[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }
}