import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedParenthesis {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(isBalanced(s));
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')') {
                if (stack.isEmpty())
                    return false;
                if (isCorresponding(stack.peek(), s.charAt(i))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }

    public static boolean isCorresponding(char stackChar, char inputToken) {
        if (stackChar == '(' && inputToken == ')')
            return true;
        else if (stackChar == '{' && inputToken == '}')
            return true;
        else if (stackChar == '[' && inputToken == ']')
            return true;
        else
            return false;
    }
}