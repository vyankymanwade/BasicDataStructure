import java.io.BufferedReader;
import java.io.InputStreamReader;


class Anagram {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        System.out.println(check(s1, s2));
    }

    public static boolean check(String s1, String s2) {
        int a1[] = new int[256];
        int a2[] = new int[256];
        if (s1.length() != s2.length())
            return false;
        for (int i = 0; i < s1.length(); i++) {
            a1[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            a2[s2.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (a1[i] != a2[i])
                return false;
        }
        return true;
    }
}