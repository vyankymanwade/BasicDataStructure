import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PossibleString {
    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "ABC";
        possible("ABC", " ", 0);
    }

    public static void possible(String s, String res, int index) {
        if (index == s.length()) {
            System.out.print(res + " ");
            return;
        }
        possible(s, res, index + 1);
        possible(s, res + s.charAt(index), index + 1);
    }
}