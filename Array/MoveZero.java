import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MoveZero {
    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a[] = { 8, 5, 0, 10, 0, 20 };
        // naive(a);
        efficient(a);
        for (int v : a) {
            System.out.print(v + " ");
        }
    }

    public static void naive(int a[]) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j] != 0) {
                        int temp = a[j];
                        a[j] = a[i];
                        a[i] = temp;
                        break;
                    }
                }
            }
        }
    }

    public static void efficient(int a[]) {
        int countOfNonZero = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                int temp = a[countOfNonZero];
                a[countOfNonZero] = a[i];
                a[i] = temp;
                countOfNonZero++;
            }
        }
    }
}