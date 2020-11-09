import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class InfixToPostfix {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(convert(input));
    }

    public static String convert(String input) {
        Stack<Character> s = new Stack<Character>();
        StringBuffer postfix = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);
            if (Character.isLetter(token)) {
                postfix.append(token);
            } else if (token == '(') {
                s.push(token);
            } else if (token == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    postfix.append(s.pop());
                }
                s.pop();
            } else {
                if (s.isEmpty())
                    s.push(token);
                else if (precedenceOf(token) > precedenceOf(s.peek())) {
                    s.push(token);
                } else if (precedenceOf(token) <= precedenceOf(s.peek())) {
                    while (!s.isEmpty() && precedenceOf(token) <= precedenceOf(s.peek())) {
                        postfix.append(s.pop());
                    }
                    s.push(token);
                }
            }
        }
        while (!s.isEmpty()) {
            postfix.append(s.pop());
        }
        return postfix.toString();
    }

    public static int precedenceOf(char c) {
        switch (c) {
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}