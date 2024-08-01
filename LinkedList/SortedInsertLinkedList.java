public class SortedInsertLinkedList {
    private Node head;
    private int len = 0;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (this.head == null || this.head.data >= data) {
            newNode.next = this.head;
            this.head = newNode;
        } else {
            Node current = this.head;
            while (current.next != null && current.next.data < data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        this.len++;
    }

    public void printList() {
        System.out.print("List: ");
        Node current = this.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Sorted Insert in a Linked List");
        SortedInsertLinkedList list = new SortedInsertLinkedList();
        list.insert(1);
        list.insert(5);
        list.insert(1);
        list.insert(4);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(4);
        list.printList();
    }
}
