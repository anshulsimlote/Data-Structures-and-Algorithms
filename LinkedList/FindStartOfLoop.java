package LinkedList;

public class FindStartOfLoop {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void initializeList(int[] values, int loopIndex) {
        if (values == null || values.length == 0) return;

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

    public Node findLoopStart() {
        Node slow = head;
        Node fast = head;
        boolean loopExists = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                loopExists = true;
                break;
            }
        }

        if(loopExists){
            slow = head;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            System.out.println("Loop starts at node with data: " + slow.data);
            return slow;
        }
        System.out.println("No loop start found because no loop exists");
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Find Loop start in Linked List");
        FindStartOfLoop list = new FindStartOfLoop();
        
        // Initialize list with loop
        int[] values = {1, 2, 3, 4, 5, 6};
        int loopIndex = 2; // index of node to create a loop (3rd node, data=3)
        list.initializeList(values, loopIndex);
        
        // Find and print the start of the loop
        list.findLoopStart();
    }
}
