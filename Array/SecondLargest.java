import java.util.Scanner;

public class SecondLargest {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int a[] = { 10, 12, 10 };
        int sl = -1;
        int l = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[l]) {
                sl = l;
                l = i;
            } else if (a[i] != a[l]) {
                if (sl == -1 || a[i] > a[sl]) {
                    sl = i;
                }
            }
        }
        if (sl == -1)
            System.out.println(sl);
        else
            System.out.println(a[sl]);

    }
}