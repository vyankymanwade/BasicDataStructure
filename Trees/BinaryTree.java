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

    public static void main(String args[]) {
        BinaryTree bt = new BinaryTree();

        bt.root = new Node(10);
        bt.root.left = new Node(5);
        bt.root.right = new Node(15);
        bt.root.left.left = new Node(3);
        bt.root.left.right = new Node(7);
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
    }
}