import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Palindrome {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(check(s, 0, s.length() - 1));

    }

    public static boolean check(String s, int l, int r) {
        if (l > r)
            return true;
        if (s.charAt(l) != s.charAt(r))
            return false;
        return check(s, l + 1, r - 1);
    }
}