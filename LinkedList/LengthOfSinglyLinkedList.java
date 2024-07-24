package LinkedList;

public class LengthOfSinglyLinkedList {
    Node head;

    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void add(int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
        } else {
            Node curNode = head;
            while (curNode.next != null) {
                curNode = curNode.next;
            }
            curNode.next = temp;
        }
    }

    public int len() {
        int len = 0;
        Node curNode = head;
        while (curNode != null) {
            curNode = curNode.next;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println("Length Of Singly Linked List");
        LengthOfSinglyLinkedList singlyLinkedList = new LengthOfSinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        singlyLinkedList.add(4);
        System.out.println("Length: " + singlyLinkedList.len());
    }
}
