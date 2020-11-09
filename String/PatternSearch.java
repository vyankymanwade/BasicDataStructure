import java.io.BufferedReader;
import java.io.InputStreamReader;

class Pattern {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String txt = br.readLine();
        String pat = br.readLine();
        patternSearch(txt, pat);
    }

    public static void patternSearch(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        int j;
        for (int i = 0; i <= n - m; i++) {
            for (j = 0; j < m; j++) {
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
            }
            if (j == m)
                System.out.print(i + " ");
        }
    }
}