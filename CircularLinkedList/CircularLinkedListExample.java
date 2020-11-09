class CircularLinkedListExample {
    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = next;
        }
    }

    public void pushBack(Node newNode) {
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head.next;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    public void pushBackEfficient(Node newNode) {
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            pushFrontEfficient(newNode);
            head = head.next;
        }
    }

    public void pushFront(Node newNode) {
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head.next;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void pushFrontEfficient(Node newNode) {
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            newNode.next = head.next;
            head.next = newNode;
            int tempData = head.data;
            head.data = newNode.data;
            newNode.data = tempData;
        }
    }

    public void print(Node head) {
        if (head == null)
            return;
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public void deleteFirst() {
        if (head == null || head.next == null)
            head = null;
        else {
            Node temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = head.next;
            head = head.next;
        }
    }

    public static void main(String args[]) {
        CircularLinkedListExample cll = new CircularLinkedListExample();
        cll.pushBack(new Node(10));
        cll.pushBack(new Node(20));
        cll.pushBack(new Node(30));
        cll.print(cll.head);
        cll.pushFront(new Node(5));
        System.out.print("Aftre adding 5 in front: ");
        cll.print(cll.head);

        cll.pushFront(new Node(2));
        System.out.print("Aftre adding 2 in front by efficient method : ");
        cll.print(cll.head);

        cll.pushBackEfficient(new Node(40));
        System.out.print("Aftre adding 40 in back by efficient method : ");
        cll.print(cll.head);

        cll.deleteFirst();
        System.out.print("Aftre deleting front : ");
        cll.print(cll.head);
    }
}