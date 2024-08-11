package LinkedList;

public class CircularLinkedList {
    Node head;

    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = temp;
            head.next = head; // Point to itself to create the circular link
        } else {
            Node curNode = head;
            while (curNode.next != head) {
                curNode = curNode.next;
            }
            curNode.next = temp;
            temp.next = head; // Maintain circular nature
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node curNode = head;
        do {
            System.out.print(curNode.data + ", ");
            curNode = curNode.next;
        } while (curNode != head);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Circular Linked List");
        CircularLinkedList cList = new CircularLinkedList();
        cList.add(1);
        cList.add(2);
        cList.add(3);
        cList.print();
    }
}
