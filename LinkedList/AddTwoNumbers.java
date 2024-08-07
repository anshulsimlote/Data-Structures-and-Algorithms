package LinkedList;

public class AddTwoNumbers {
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

    public static AddTwoNumbers sum(AddTwoNumbers sl1, AddTwoNumbers sl2) {
        AddTwoNumbers sl3 = new AddTwoNumbers();
        Node sl1Cur = sl1.head;
        Node sl2Cur = sl2.head;
        int carry = 0;

        while (sl1Cur != null || sl2Cur != null) {
            int sum = carry;
            if (sl1Cur != null) {
                sum += sl1Cur.data;
                sl1Cur = sl1Cur.next;
            }
            if (sl2Cur != null) {
                sum += sl2Cur.data;
                sl2Cur = sl2Cur.next;
            }
            carry = sum / 10;
            sl3.insert(sum % 10);
        }

        if (carry > 0) {
            sl3.insert(carry);
        }

        return sl3;
    }

    public static void main(String[] args) {
        System.out.println("Add Two Numbers Linked List");
        AddTwoNumbers sl1 = new AddTwoNumbers();
        AddTwoNumbers sl2 = new AddTwoNumbers();

        sl1.insert(3);  // Represents number 321
        sl1.insert(2);
        sl1.insert(1);

        sl2.insert(4);  // Represents number 4329
        sl2.insert(3);
        sl2.insert(2);
        sl2.insert(9);

        System.out.println("First Number:");
        sl1.print();
        
        System.out.println("Second Number:");
        sl2.print();

        AddTwoNumbers sl3 = sum(sl1, sl2);
        
        System.out.println("Resulted Number:");
        sl3.print();
    }
}
