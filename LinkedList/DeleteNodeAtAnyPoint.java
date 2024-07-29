public class DeleteNodeAtAnyPoint {
    private Node head;

    private class Node {
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

    public void deleteNode(int pos) {
        if (head == null || pos < 1) {
            System.out.println("Invalid position.");
            return;
        }

        if (pos == 1) {
            head = head.next;
            return;
        }

        Node current = head;
        for (int i = 1; current != null && i < pos - 1; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("Position out of range.");
            return;
        }

        current.next = current.next.next;
    }

    public static void main(String[] args) {
        System.out.println("Delete Node At Any Point");
        DeleteNodeAtAnyPoint list = new DeleteNodeAtAnyPoint();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.print();

        list.deleteNode(1);
        list.print();

        list.deleteNode(3);
        list.print();

        list.deleteNode(10); // Test for invalid position
    }
}
