package LinkedList;

public class MergeTwoSortedLinkedList {
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
        Node temp = new Node(data);
        if (this.head == null) {
            this.head = temp;
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = temp;
        }
    }

    public void print() {
        System.out.print("Print: ");
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + ", ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static MergeTwoSortedLinkedList mergeSortedList(MergeTwoSortedLinkedList sl1, MergeTwoSortedLinkedList sl2) {
        MergeTwoSortedLinkedList sl3 = new MergeTwoSortedLinkedList();
        Node sl1Cur = sl1.head;
        Node sl2Cur = sl2.head;

        while (sl1Cur != null && sl2Cur != null) {
            if (sl1Cur.data <= sl2Cur.data) {
                sl3.insert(sl1Cur.data);
                sl1Cur = sl1Cur.next;
            } else {
                sl3.insert(sl2Cur.data);
                sl2Cur = sl2Cur.next;
            }
        }

        while (sl1Cur != null) {
            sl3.insert(sl1Cur.data);
            sl1Cur = sl1Cur.next;
        }

        while (sl2Cur != null) {
            sl3.insert(sl2Cur.data);
            sl2Cur = sl2Cur.next;
        }

        return sl3;
    }

    public static void main(String[] args) {
        System.out.println("Merge Two Sorted Linked List");
        MergeTwoSortedLinkedList sl1 = new MergeTwoSortedLinkedList();
        MergeTwoSortedLinkedList sl2 = new MergeTwoSortedLinkedList();

        sl1.insert(1);
        sl1.insert(2);
        sl1.insert(7);

        sl2.insert(3);
        sl2.insert(6);
        sl2.insert(8);
        sl2.insert(9);

        System.out.println("First List:");
        sl1.print();
        
        System.out.println("Second List:");
        sl2.print();

        MergeTwoSortedLinkedList sl3 = mergeSortedList(sl1, sl2);
        
        System.out.println("Merged List:");
        sl3.print();
    }
}
