import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostfixEvaluation {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(evaluate(input));

    }

    public static int evaluate(String input) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);
            if (token == ' ')
                continue;
            else if (Character.isDigit(token)) {
                int n = 0;
                while (Character.isDigit(token)) { // this is for number having more than 1 digit
                    n = n * 10 + (int) (token - '0');
                    i++;
                    token = input.charAt(i);
                }
                i--;
                s.push(n);
            } else {
                int op2 = s.pop();
                int op1 = s.pop();
                switch (token) {
                    case '+':
                        s.push((op1 + op2));
                        break;
                    case '-':
                        s.push((op1 - op2));
                        break;
                    case '*':
                        s.push((op1 * op2));
                        break;
                    case '/':
                        s.push((op1 / op2));
                        break;
                    case '^':
                        s.push((int) (Math.pow(op1, op2)));
                        break;
                }

            }
        }
        return (s.pop());
    }
}