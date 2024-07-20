package LinkedList;

public class SinglyLinkedList {
    Node head;

    public class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void add(int val) {
        Node temp = new Node(val);
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

    public void print() {
        Node curNode = head;
        while (curNode != null) {
            System.out.print(curNode.data + ", ");
            curNode = curNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Singly Linked List");
        SinglyLinkedList sList = new SinglyLinkedList();
        sList.add(1);
        sList.add(2);
        sList.add(3);
        sList.print();
    }
}
