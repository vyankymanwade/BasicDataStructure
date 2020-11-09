class Doubly {
    Node head;

    static class Node {
        int data;
        Node prev, next;

        public Node(int data) {
            this.data = data;
            this.prev = this.next = null;
        }
    }

    public void pushBack(Node newNode) {
        if (head == null)
            head = newNode;
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    public void pushFront(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void print(Node head) {
        if (head == null)
            return;
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void reverseList() {
        if (head == null || head.next == null)
            return;
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            prev = temp.prev;
            temp.prev = temp.next;
            temp.next = prev;
            temp = temp.prev;
        }
        if (prev != null)
            head = prev.prev;
    }

    public void deleteFirst() {
        if (head == null || head.next == null)
            head = null;
        else {
            head.next.prev = null;
            head = head.next;
        }
    }

    public void deleteLast() { // If we maintain tail pointing to last node we can delete last node in O(1)
                               // time
        if (head == null || head.next == null)
            head = null;
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.prev.next = null;
        }
    }

    public static void main(String args[]) {
        Doubly dll = new Doubly();
        dll.pushFront(new Node(5));
        dll.pushBack(new Node(10));
        dll.pushBack(new Node(20));
        dll.pushBack(new Node(30));

        System.out.print("after inserting 5 at front and 3  nodes at end : ");
        dll.print(dll.head);

        dll.pushFront(new Node(2));
        System.out.print("after inserting 2 at front: ");
        dll.print(dll.head);

        dll.reverseList();
        System.out.print("after reversing: ");
        dll.print(dll.head);

        dll.deleteFirst();
        System.out.print("after deleting first: ");
        dll.print(dll.head);

        dll.deleteLast();
        System.out.print("after deleting last: ");
        dll.print(dll.head);
    }
}