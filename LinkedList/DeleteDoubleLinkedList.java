package LinkedList;

public class DeleteDoubleLinkedList {
    Node head, tail;

    public class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void insert(int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }

    public void deleteFirst() {
        if (head == null) { // No nodes to delete
            return;
        }
        if (head == tail) { // Only one node in the list
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteLast() {
        if (tail == null) { // No nodes to delete
            return;
        }
        if (head == tail) { // Only one node in the list
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void print() {
        System.out.print("PRINT: ");
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + ", ");
            cur = cur.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        System.out.println("Delete Double Linked List Delete First and Last");
        DeleteDoubleLinkedList doubleLinkedList = new DeleteDoubleLinkedList();
        doubleLinkedList.insert(1);
        doubleLinkedList.insert(2);
        doubleLinkedList.insert(3);
        doubleLinkedList.insert(4);
        doubleLinkedList.print();
        doubleLinkedList.deleteFirst();
        doubleLinkedList.print();
        doubleLinkedList.deleteLast();
        doubleLinkedList.print();
    }
}
