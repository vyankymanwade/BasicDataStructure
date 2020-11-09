import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IsStringRotationOfAnother {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        System.out.println(isRotation(s1, s2));
    }

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        s1 = s1 + s1;
        if (s1.indexOf(s2) < 0)
            return false;
        else
            return true;
    }
}