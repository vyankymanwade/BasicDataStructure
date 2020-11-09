import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ReverseStack {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<Integer>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int item = Integer.parseInt(br.readLine());
            s.push(item);
        }
        reverseStack(s);
        System.out.println(s);
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.size() == 1)
            return;
        int temp = s.pop();
        reverseStack(s);
        insert(s, temp);
    }

    public static void insert(Stack<Integer> s, int temp) {
        if (s.size() == 0) {
            s.push(temp);
            return;
        }
        int val = s.pop();
        insert(s, temp);
        s.push(val);
    }
}