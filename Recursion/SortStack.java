import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SortStack {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<Integer>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int item = Integer.parseInt(br.readLine());
            s.push(item);
        }
        sortStack(s);
        System.out.println(s);
    }

    public static void sortStack(Stack<Integer> s) {
        if (s.size() == 1)
            return;
        int temp = s.peek();
        s.pop();
        sortStack(s);
        insert(s, temp);
    }

    public static void insert(Stack<Integer> s, int temp) {
        if (s.size() == 0 || s.peek() <= temp) {
            s.push(temp);
            return;
        }
        int last = s.pop();
        insert(s, temp);
        s.push(last);
    }
}