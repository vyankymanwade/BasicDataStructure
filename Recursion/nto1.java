import java.io.BufferedReader;
import java.io.InputStreamReader;

public class nto1 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nto1(n);
        System.out.println();
        oneTon(n);
    }

    public static void nto1(int n) {
        if (n <= 0)
            return;
        System.out.print(n + " ");
        nto1(n - 1);
    }

    public static void oneTon(int n) {
        if (n <= 0)
            return;
        oneTon(n - 1);
        System.out.print(n + " ");
    }
}