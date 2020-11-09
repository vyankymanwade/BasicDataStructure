import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Reverse {
    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a[] = { 10, 5, 7, 30 };
        reverse(a);
        for (int v : a) {
            System.out.print(v + " ");
        }
    }

    public static void reverse(int a[]) {
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }
}