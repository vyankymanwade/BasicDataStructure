import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class DeleteMidOfStack {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<Integer>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int item = Integer.parseInt(br.readLine());
            s.push(item);
        }
        deleteMid(s, (s.size() / 2) + 1);
        System.out.println(s);
    }

    public static void deleteMid(Stack<Integer> s, int mid) {
        if (mid == 1) {
            s.pop();
            return;
        }
        int temp = s.pop();
        deleteMid(s, mid - 1);
        s.push(temp);
    }
}