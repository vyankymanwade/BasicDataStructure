import java.util.Arrays;

class Merge {
    public static void main(String args[]) {
        int a[] = { 10, 15, 20, 40 };
        int b[] = { 5, 6, 6, 10, 15 };
        int m = 4;
        int n = 5;

        // merge(a, b, m, n);
        efficientMerge(a, b, m, n);
    }

    public static void merge(int a[], int b[], int m, int n) { // (m+n)LOG(m+n)
        int c[] = new int[m + n];
        for (int i = 0; i < m; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < n; i++) {
            c[m + i] = b[i];
        }
        Arrays.sort(c);
        System.out.println(Arrays.toString(c));
    }

    public static void efficientMerge(int a[], int b[], int m, int n) {
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (a[i] > b[j]) {
                System.out.print(b[j] + " ");
                j++;
            } else {
                System.out.print(a[i] + " ");
                i++;
            }
        }
        while (i < m) {
            System.out.print(a[i] + " ");
            i++;
        }
        while (j < n) {
            System.out.print(b[j] + " ");
            j++;
        }
    }
}