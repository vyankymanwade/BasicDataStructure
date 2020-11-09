import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Random {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        randomNo(n);
    }

    public static void randomNo(int n) {
        if (n < 0)
            return;
        else {
            System.out.print(n + " ");
            randomNo(n - 1);
            System.out.print(n + " ");
        }
    }
}