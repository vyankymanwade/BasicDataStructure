import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaxCut {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        System.out.println("max cut: " + maxCut(n, a, b, c));
        // System.out.println(max(5, 10, 13));
    }

    public static int maxCut(int n, int a, int b, int c) {
        if (n == 0)
            return 0;
        if (n < 0)
            return -1;
        int result = max(maxCut(n - a, a, b, c), maxCut(n - b, a, b, c), maxCut(n - c, a, b, c));
        if (result == -1)
            return -1;
        return (result + 1);
    }

    public static int max(int a, int b, int c) {
        return ((a > b) ? (a > c ? a : c) : (b > c ? b : c));
    }
}