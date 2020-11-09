import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TOH {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        solveTOH(n, "A", "B", "C");
    }

    public static void solveTOH(int n, String first, String second, String third) {

        if (n == 1) {
            System.out.println("DISC 1 IS MOVED FROM " + first + " => " + third);
            return;
        }
        solveTOH(n - 1, first, third, second);
        System.out.println("DISC " + (n) + " IS MOVED FROM " + first + " => " + third);
        solveTOH(n - 1, second, first, third);
    }
}