package LinkedList;

public class RemoveLoppLinkedList {
    Node head;
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void initializeList(int[] values, int loopIndex){
        Node[] nodes = new Node[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Node(values[i]);
            if (i > 0) {
                nodes[i - 1].next = nodes[i];
            }
        }
        if (loopIndex >= 0 && loopIndex < values.length) {
            nodes[nodes.length - 1].next = nodes[loopIndex];
        }
        head = nodes[0];
    }
    public void removeLoop(){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("Loop detected");
                break;
            }
        }
        slow = head;
        while(slow.next != fast.next){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }
    public void print(){
        System.out.println("Print");
        Node cur = head;
        while (cur != null){
            System.out.print(cur.data+", ");
            cur = cur.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        System.out.println("Remove Loop Linked List");
        RemoveLoppLinkedList list = new RemoveLoppLinkedList();
        
        // Initialize list with loop
        int[] values = {1, 2, 3, 4, 5, 6};
        int loopIndex = 2; // index of node to create a loop (3rd node, data=3)
        list.initializeList(values, loopIndex);
        list.removeLoop();
        list.print();
    }
}
