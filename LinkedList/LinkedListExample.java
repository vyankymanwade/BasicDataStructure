
class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insertAt(int pos, Node newNode) {
        if (head == null)
            return;
        if (pos == 1) {
            pushFront(newNode);
            return;
        }
        Node temp = head;
        int count = 1;
        while (pos - 1 != count) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            System.out.println("position not avl:");
            return;
        }
        Node nextNode = temp.next;
        temp.next = newNode;
        newNode.next = nextNode;

    }

    public void pushFront(Node newNode) {
        if (head == null)
            head = newNode;
        Node temp = head;
        head = newNode;
        newNode.next = temp;
    }

    public void pushBack(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void deleteFirst() {
        if (head == null)
            return;
        head = head.next;
    }

    public void sortedInsert(Node newNode) {
        if (head == null)
            head = newNode;
        if (head.next == null && head.data <= newNode.data) {
            pushBack(newNode);
        } else if (head.next == null && head.data > newNode.data) {
            pushFront(newNode);
        }
        Node temp = head;
        while (newNode.data >= temp.next.data && (temp.next.next != null)) {
            temp = temp.next;
        }
        if (temp.next.next == null) {
            temp.next.next = newNode;
            return;
        }

        Node nextNode = temp.next;
        temp.next = newNode;
        newNode.next = nextNode;
    }

    public void deleteLast() {
        if (head == null)
            return;
        if (head.next == null)
            head = null;
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void recursivePrint(Node head) {
        if (head == null)
            return;
        System.out.print(head.data + " ");
        recursivePrint(head.next);
    }

    public void printReverse(Node head) {
        if (head == null)
            return;
        printReverse(head.next);
        System.out.print(head.data + " ");
    }

    public int search(Node head, int key) {
        if (head == null)
            return -1;
        Node temp = head;
        int pos = 0;
        while (temp != null) {
            pos += 1;
            if (temp.data == key)
                return pos;
            temp = temp.next;
        }
        return -1;
    }

    public int recursiveSearch(Node head, int key, int pos) {
        if (head.data == key)
            return pos;
        if (head == null)
            return -1;
        return recursiveSearch(head.next, key, pos + 1);
    }

    public int middleElement(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return (slow.data);
    }

    public int nthNodeFromEnd(int n) {
        Node first = head;
        Node second = head;
        for (int i = 0; i < n; i++) {
            if (first == null) { // Corner case if length is smaller than required position
                System.out.println("Length is more");
                return -1;
            }
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return (second.data);
    }

    public void reverseLinkedList() {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr.next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = curr;
        head.next = prev;
    }

    public Node recursiveReverse(Node head) {
        if (head == null || head.next == null)
            return head;
        Node remainingLinkedListHead = recursiveReverse(head.next);
        Node remainingLinkedListTail = head.next;
        head.next = null;
        remainingLinkedListTail.next = head;
        return remainingLinkedListHead;
    }

    public Node recursiveReverseMethod2(Node curr, Node prev) {
        if (curr == null)
            return prev;
        Node next = curr.next;
        curr.next = prev;
        return (recursiveReverseMethod2(next, curr));
    }

    public void deleteDuplicate(Node head) {
        Node temp = head;
        while (temp.next != null && temp != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.pushBack(new Node(1));
        ll.pushBack(new Node(2));
        ll.pushBack(new Node(3));
        ll.pushBack(new Node(4));
        ll.pushBack(new Node(5));
        System.out.println("after adding 5 element: ");
        ll.print(ll.head);
        System.out.println("after adding 5 element recursive print: ");
        ll.recursivePrint(ll.head);
        System.out.println("after adding 5 element reverse print: ");
        ll.printReverse(ll.head);
        System.out.println();
        System.out.println("4 at position: " + ll.search(ll.head, 4));
        System.out.println("5 at position: " + ll.recursiveSearch(ll.head, 5, 1));
        ll.pushFront(new Node(0));
        System.out.println("after adding 0 at front : ");
        ll.print(ll.head);
        ll.deleteFirst();
        System.out.println("after deleting front :");
        ll.print(ll.head);
        ll.deleteLast();
        System.out.println("after deleting last :");
        ll.print(ll.head);
        ll.insertAt(5, new Node(10));
        System.out.println("after inserting 10 at 5 :");
        ll.print(ll.head);

        ll.sortedInsert(new Node(5));
        System.out.println("after sorted insert 5 :");
        ll.print(ll.head);

        System.out.println("middle element " + ll.middleElement(ll.head));

        ll.sortedInsert(new Node(25));
        System.out.println("after sorted insert 25 :");
        ll.print(ll.head);

        System.out.println("middle element " + ll.middleElement(ll.head));

        System.out.println("3rd node from end: " + ll.nthNodeFromEnd(1));

        ll.reverseLinkedList();

        System.out.println("After reverse: ");
        ll.print(ll.head);

        ll.head = ll.recursiveReverse(ll.head);

        System.out.println("After reverse: ");
        ll.print(ll.head);

        ll.head = ll.recursiveReverseMethod2(ll.head, null);

        System.out.println("After reverse: ");
        ll.print(ll.head);

        // Another Linked list for remove duplicate from linkedlist

        LinkedList ll2 = new LinkedList();
        ll2.pushBack(new Node(10));
        ll2.pushBack(new Node(20));
        ll2.pushBack(new Node(20));
        ll2.pushBack(new Node(30));
        ll2.pushBack(new Node(30));
        ll2.pushBack(new Node(30));
        System.out.println("Second LinkedList");
        ll2.print(ll2.head);

        ll2.deleteDuplicate(ll2.head);
        System.out.println("delete duplicate: ");
        ll2.print(ll2.head);
    }

}