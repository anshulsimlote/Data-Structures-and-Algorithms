package LinkedList;

public class RemoveNodeAtAnyPoint {
    Node head;
    public class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insertNodeAtPos(int data, int pos) {
        Node node = new Node(data);

        // If inserting at the head (position 1)
        if (pos == 1) {
            node.next = head;  // New node points to the old head
            head = node;       // Head is now the new node
            return;
        }

        Node curNode = head;
        int count = 1;  // Start count at 1 since pos is 1-based

        // Traverse the list to find the position
        while (curNode != null && count < pos - 1) {
            curNode = curNode.next;
            count++;
        }

        // If curNode is not null, insert the node
        if (curNode != null) {
            node.next = curNode.next;
            curNode.next = node;
        } else {
            // If curNode is null, the position is out of bounds
            System.out.println("Position out of bounds");
        }
    }

    public void removeNodeAtPos(int pos) {
        // If the list is empty or position is less than 1
        if (head == null || pos < 1) {
            System.out.println("Position out of bounds");
            return;
        }

        // If the head is to be removed
        if (pos == 1) {
            head = head.next;
            return;
        }

        Node curNode = head;
        int count = 1;

        // Traverse the list to find the node just before the position to be removed
        while (curNode != null && count < pos - 1) {
            curNode = curNode.next;
            count++;
        }

        // If curNode is null or the next node is null, position is out of bounds
        if (curNode == null || curNode.next == null) {
            System.out.println("Position out of bounds");
            return;
        }

        // Remove the node at the given position
        curNode.next = curNode.next.next;
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
        System.out.println("Remove Node At Any Point");
        RemoveNodeAtAnyPoint sl = new RemoveNodeAtAnyPoint();
        sl.insertNodeAtPos(1, 1);
        sl.insertNodeAtPos(2, 2);
        sl.insertNodeAtPos(4, 3);
        sl.insertNodeAtPos(3, 3);
        sl.print();  // Output: 1, 2, 3, 4,
        sl.removeNodeAtPos(3);
        sl.print();  // Output: 1, 2, 4,
    }
}
