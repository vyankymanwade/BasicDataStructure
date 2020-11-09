import java.io.BufferedReader;
import java.io.InputStreamReader;

class Rank {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(findRank(s));

    }

    public static int findRank(String s) {
        int n = s.length();
        int rank = 1;
        int mul = factorial(n);
        int c[] = new int[256];
        for (int i = 0; i < n; i++) {
            c[s.charAt(i)]++;
        }
        for (int i = 1; i < 256; i++) {
            c[i] = c[i] + c[i - 1];
        }
        for (int i = 0; i < n; i++) {
            mul = mul / (n - i);
            rank += c[s.charAt(i) - 1] * mul;
            for (int j = s.charAt(i); j < 256; j++)
                c[j]--;
        }
        return rank;
    }

    public static int factorial(int n) {
        if (n == 1 || n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}