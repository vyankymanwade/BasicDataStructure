import java.util.Stack;

class StackExample {
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        System.out.println("after inserting stack is : " + s);
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " "); // it delete top of stack
        }
        s.push(90);
        s.push(100);
        System.out.println();
        System.out.println(s);
        System.out.println("Size of stack: " + s.size());
        System.out.println("top of stack: " + s.peek()); // it gives only top not delete top from stack
        System.out.println("90 is at from top: " + s.search(90)); // search from top of stack and returns position
    }
}