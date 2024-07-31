public class NthNodeLinkedList {
    Node head;

    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void print() {
        System.out.print("List: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void findNthNode(int target) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        int count = 1; // Start counting from 1

        while (current != null) {
            if (count == target) {
                System.out.println("Nth Node - " + current.data);
                return;
            }
            current = current.next;
            count++;
        }

        System.out.println("Target is out of bounds");
    }

    public static void main(String[] args) {
        System.out.println("Nth Node in Linked List");
        NthNodeLinkedList list = new NthNodeLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.print();
        list.findNthNode(2); // Change target value here to test different positions
    }
}
