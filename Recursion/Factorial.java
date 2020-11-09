import java.io.BufferedReader;
import java.io.InputStreamReader;

class Factorial {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = factorial(n);
        System.out.println(ans);
        int ans2 = tailRecursive(n, 1);
        System.out.println(ans2);
    }

    public static int tailRecursive(int n, int k) {
        if (n <= 0)
            return k;
        return tailRecursive(n - 1, n * k);
    }

    public static int factorial(int n) {
        if (n == 1 || n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}