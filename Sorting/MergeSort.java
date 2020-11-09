import java.util.Arrays;

public class MergeSort {
    public static void main(String args[]) {
        int a[] = { 64, 34, 25, 12, 22, 11, 90 };
        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int a[], int l, int r) {
        if (r > l) {
            int m = l + (r - l) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);

            merge(a, l, m, r);
        }
    }

    public static void merge(int a[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int left[] = new int[n1];
        int right[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = a[l + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = a[m + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            a[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            a[k] = right[j];
            j++;
            k++;
        }
    }
}