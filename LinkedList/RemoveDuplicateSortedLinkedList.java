public class RemoveDuplicateSortedLinkedList {
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
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
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

    public void removeDuplicates() {
        if (this.head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = this.head;

        while (current != null && current.next != null) {
            if (current.next.data == current.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Remove Duplicate in a Sorted Linked List");
        RemoveDuplicateSortedLinkedList list = new RemoveDuplicateSortedLinkedList();
        list.insert(1);
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(4);
        list.insert(4);
        list.insert(5);
        list.printList();
        list.removeDuplicates();
        list.printList();
    }
}
