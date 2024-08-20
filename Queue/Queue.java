package Queue;

public class Queue {
    Node front, rear;

    // Inner Node class
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to add an element to the queue
    public void enQueue(int data) {
        Node temp = new Node(data);
        if (rear == null) { // Queue is empty
            rear = temp;
            front = temp;
        } else {
            rear.next = temp; // Link the new node after rear
            rear = temp; // Make the new node the rear
        }
    }

    // Method to remove an element from the queue
    public void deQueue() {
        if (front == null) { // Queue is empty
            System.out.println("Queue is empty, cannot dequeue.");
            return;
        }
        front = front.next; // Move front to the next node
        if (front == null) { // If the queue is now empty, update rear to null
            rear = null;
        }
    }

    // Method to print the elements of the queue
    public void print() {
        if (front == null) { // Queue is empty
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        Node cur = front;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Queue is FIFO");
        System.out.println("Queue");
        Queue q = new Queue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.print(); // Queue: 1 2 3
        q.deQueue();
        q.print(); // Queue: 2 3
        q.deQueue();
        q.deQueue();
        q.print(); // Queue is empty.
        q.deQueue(); // Queue is empty, cannot dequeue.
    }
}
