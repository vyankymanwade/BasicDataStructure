import java.io.BufferedReader;
import java.io.InputStreamReader;

class Sum {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = sum(n);
        System.out.println(result);
    }

    public static int sum(int n) {
        if (n == 0)
            return 0;
        return (n % 10 + sum(n / 10));
    }
}