import java.util.*;
import java.lang.*;

class Input {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str;
        str = s.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int a[] = new int[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            a[i++] = Integer.parseInt(st.nextToken());
        }
    }
}
