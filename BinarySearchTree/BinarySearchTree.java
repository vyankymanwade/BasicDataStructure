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

    public Node insert(Node root, Node newNode) {
        Node temp = root;
        Node parent = null;
        while (temp != null) {
            parent = temp;
            if (newNode.data > temp.data)
                temp = temp.right;
            else if (newNode.data < temp.data)
                temp = temp.left;
            else
                return root;
        }
        if (parent == null)
            return newNode;
        if (newNode.data > parent.data)
            parent.right = newNode;
        else
            parent.left = newNode;
        return root;

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

    public Node delete(Node root, int data) {
        if (root == null)
            return null;
        else if (data > root.data)
            root.right = delete(root.right, data);
        else if (data < root.data)
            root.left = delete(root.left, data);
        else {
            if (root.left == null) // node to be deleted only have right child
                return root.right;
            else if (root.right == null) // node to be deleted only have left child
                return root.left;
            else { // both child
                Node successor = getSuccessor(root); // getting closet greater value
                root.data = successor.data;
                root.right = delete(root.right, successor.data);
            }
        }
        return root;
    }

    public Node getSuccessor(Node root) {
        Node temp = root.right;
        while (temp != null && temp.left != null)
            temp = temp.left;
        return temp;
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
        bst.root = bst.insert(bst.root, new Node(45));
        System.out.print("inorder : ");
        bst.inorder(bst.root);
        System.out.println();
        bst.root = bst.recursiveInsert(bst.root, new Node(75));
        System.out.print("inorder : ");
        bst.inorder(bst.root);
        System.out.println();
        bst.root = bst.delete(bst.root, 70);
        System.out.print("inorder : ");
        bst.inorder(bst.root);
        System.out.println();
    }
}