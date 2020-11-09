import java.lang.*;
import java.util.*;

public class BubbleSort {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int a[] = { 10, 20, 30, 40, 70, 60, 50 }; // 64, 34, 25, 12, 22, 11, 90
        bubbleSort(a, 7);
        System.out.println(Arrays.toString(a));
        optimizedSort(a, 7);
        System.out.println(Arrays.toString(a));
    }

    public static void bubbleSort(int a[], int n) { // if array is already sorted then also it take O(n^2)
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

    }

    public static void optimizedSort(int a[], int n) { // if array is sorted then is will take O(n)
        boolean swapped;
        for (int i = 0; i < n; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped) {
                break;
            }
        }
    }
}