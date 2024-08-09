package LinkedList;

public class DoubleLinkedList {
    Node head;
    Node tail;

    public class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode; // Initialize tail
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode; // Update tail to the new node
        }
    }

    public void insertBegining(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode; // Initialize tail
        } else {
            newNode.next = head;
            head.prev = newNode; // Fixing the bug: update the prev pointer of the current head
            head = newNode; // Update head to the new node
        }
    }

    public void print() {
        System.out.print("Forward: ");
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void printReverse() {
        System.out.print("Reverse: ");
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Double Linked List");
        DoubleLinkedList dLinkedList = new DoubleLinkedList();
        dLinkedList.insertEnd(1);
        dLinkedList.insertEnd(2);
        dLinkedList.insertEnd(3);
        dLinkedList.insertEnd(4);
        dLinkedList.insertBegining(0);
        dLinkedList.print(); // Print forward
        dLinkedList.printReverse(); // Print in reverse       
    }
}
