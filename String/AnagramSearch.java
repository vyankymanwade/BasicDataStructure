import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AnagramSearch {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String txt = br.readLine();
        String pattern = br.readLine();
        System.out.println(isAnagramFound(txt, pattern));
    }

    public static boolean areSame(int patCount[], int txtCount[]) {
        for (int i = 0; i < 256; i++) {
            if (patCount[i] != txtCount[i])
                return false;
        }
        return true;
    }

    public static boolean isAnagramFound(String txt, String pattern) {
        int patCount[] = new int[256];
        int txtCount[] = new int[256];
        for (int i = 0; i < pattern.length(); i++) {
            patCount[pattern.charAt(i)]++;
            txtCount[txt.charAt(i)]++;
        }
        for (int i = pattern.length(); i < txt.length(); i++) {
            if (areSame(patCount, txtCount))
                return true;
            txtCount[txt.charAt(i)]++;
            txtCount[txt.charAt(i - pattern.length())]--;
        }
        return false;
    }
}