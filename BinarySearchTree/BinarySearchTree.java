class BST {
    Node root;

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public boolean search(Node root, int data) {
        if (root == null)
            return false;
        if (root.data == data)
            return true;
        else if (data > root.data)
            return search(root.right, data);
        else
            return search(root.left, data);
    }

    public boolean iterativeSearch(Node root, int data) {
        while (root != null) {
            if (root.data == data)
                return true;
            else if (data > root.data)
                root = root.right;
            else
                root = root.left;
        }
        return false;
    }

    public void insert(Node newNode) {
        if (root == null)
            root = newNode;
        Node temp = root;
        if (search(root, newNode.data)) {
            System.out.println("already present");
            return;
        } else {
            if (newNode.data > temp.data) {
                while (temp.right != null && newNode.data > temp.data)
                    temp = temp.right;
                while (temp.left != null && newNode.data < temp.data)
                    temp = temp.left;
                temp.right = newNode;
            } else {
                while (temp.left != null && newNode.data < temp.data)
                    temp = temp.left;
                while (temp.right != null && newNode.data > temp.data)
                    temp = temp.right;
                temp.left = newNode;
            }
        }
    }

    public Node recursiveInsert(Node root, Node newNode) {
        if (root == null)
            return newNode;
        else if (newNode.data > root.data)
            root.right = recursiveInsert(root.right, newNode);
        else
            root.left = recursiveInsert(root.left, newNode);
        return root;
    }

    public static void main(String args[]) {
        BST bst = new BST();
        bst.root = new Node(50);
        bst.root.left = new Node(30);
        bst.root.right = new Node(70);
        bst.root.left.left = new Node(10);
        bst.root.left.right = new Node(40);
        bst.root.right.left = new Node(60);
        bst.root.right.right = new Node(80);
        System.out.print("inorder : ");
        bst.inorder(bst.root);
        System.out.println();
        System.out.println("search(100): " + bst.search(bst.root, 100));
        System.out.println("IterativeSearch(70): " + bst.iterativeSearch(bst.root, 70));
        // bst.insert(new Node(75));
        // System.out.print("inorder : ");
        // bst.inorder(bst.root);
        // System.out.println();
        bst.root = bst.recursiveInsert(bst.root, new Node(75));
        System.out.print("inorder : ");
        bst.inorder(bst.root);
        System.out.println();
    }
}