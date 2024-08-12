package LinkedList;

public class CircularLinkedList {
    Node head;
    Node tail; // Maintain a tail pointer for efficient insertions at the end

    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert a node at the beginning of the list
    public void insertAtStart(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head; // Circular link
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head; // Maintain circular link
        }
    }

    // Insert a node at the end of the list
    public void insertAtEnd(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head; // Circular link
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Maintain circular link
        }
    }

    // Insert a node at the end of the list
    public void removeFirst() {
        head = head.next;
        tail.next = head;
    }

    // Print the list starting from the head node
    public void print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node curNode = head;
        do {
            System.out.print(curNode.data + " ");
            curNode = curNode.next;
        } while (curNode != head);
        System.out.println();
    }

    // Delete a node with a specific value
    public void deleteNode(int val) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node curNode = head;
        Node prevNode = null;
        do {
            if (curNode.data == val) {
                if (curNode == head) { // If head needs to be deleted
                    tail.next = head.next;
                    head = head.next;
                } else {
                    prevNode.next = curNode.next;
                    if (curNode == tail) { // If tail needs to be deleted
                        tail = prevNode;
                    }
                }
                break;
            }
            prevNode = curNode;
            curNode = curNode.next;
        } while (curNode != head);
    }

    public static void main(String[] args) {
        System.out.println("Circular Linked List");
        CircularLinkedList cList = new CircularLinkedList();
        cList.insertAtEnd(2);
        cList.insertAtEnd(3);
        cList.insertAtEnd(4);
        cList.insertAtStart(1);
        cList.insertAtStart(0);
        cList.print();
        cList.deleteNode(3);
        cList.print();
        cList.removeFirst();
        cList.print();
    }
}
