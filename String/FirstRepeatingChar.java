import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FirstRepeatingChar {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int r = firstRepeatingChar(s);
        if (r == -1)
            System.out.println("-1");
        else
            System.out.println("FIRST REPEATING: " + s.charAt(r));
        int r1 = firstNonRepeatingChar(s);
        if (r1 == -1)
            System.out.println("-1");
        else
            System.out.println("FIRST NON REPEATING: " + s.charAt(r1));

    }

    public static int firstNonRepeatingChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.substring(i, i + 1)))
                return i;
        }
        return -1;
    }

    public static int firstRepeatingChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != s.lastIndexOf(s.substring(i, i + 1)))
                return i;
        }
        return -1;
    }
}