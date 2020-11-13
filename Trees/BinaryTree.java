import java.util.Stack;

class BinaryTree {
    Node root;

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public int noOfNodes(Node root) {
        if (root == null)
            return 0;
        else
            return (1 + noOfNodes(root.left) + noOfNodes(root.right));
    }

    public int getMax(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        else
            return maxFunction(root.data, getMax(root.left), getMax(root.right));
    }

    public int maxFunction(int data, int left, int right) {
        return ((data > left ? (data > right ? data : right) : (left > right ? left : right)));
    }

    public int height(Node root) {
        if (root == null)
            return 0;
        else {
            return (1 + Math.max(height(root.left), height(root.right)));
        }
    }

    public void IterativeInorder(Node root) {
        Node temp = root;
        Stack<Node> s = new Stack<Node>();
        while (temp != null || !s.isEmpty()) {
            while (temp != null) {
                s.push(temp);
                temp = temp.left;
            }
            temp = s.pop();
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
        System.out.println();
    }

    public void IterativePreorder(Node root) {
        Node temp = root;
        Stack<Node> s = new Stack<Node>();
        while (temp != null || !s.isEmpty()) {
            while (temp != null) {
                System.out.print(temp.data + " ");
                s.push(temp);
                temp = temp.left;
            }
            temp = s.pop();
            temp = temp.right;
        }
    }

    public static void main(String args[]) {
        BinaryTree bt = new BinaryTree();

        bt.root = new Node(10);
        bt.root.left = new Node(5);
        bt.root.right = new Node(15);
        bt.root.left.left = new Node(3);
        bt.root.left.right = new Node(7);
        bt.root.left.left.left = new Node(25);
        System.out.print("inorder :");
        bt.inorder(bt.root);
        System.out.println();
        System.out.print("preorder :");
        bt.preorder(bt.root);
        System.out.println();
        System.out.print("postorder :");
        bt.postorder(bt.root);
        System.out.println();
        System.out.println("No of nodes in tree: " + bt.noOfNodes(bt.root));
        System.out.println("Maximum from tree: " + bt.getMax(bt.root));
        System.out.println("Height of Tree: " + bt.height(bt.root));
        System.out.print("Iterative Print Inorder: ");
        bt.IterativeInorder(bt.root);
        System.out.print("Iterative Print preorder: ");
        bt.IterativePreorder(bt.root);
    }
}