package Queue;

// Generic Queue class implementation
class Queue<T> {
    private Node front, rear;

    // Inner Node class
    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to add an element to the queue
    public void enQueue(T data) {
        Node temp = new Node(data);
        if (rear == null) { // Queue is empty
            front = temp;
            rear = temp;
        } else {
            rear.next = temp; // Link the new node after rear
            rear = temp; // Make the new node the rear
        }
    }

    // Method to remove an element from the queue
    public T deQueue() {
        if (front == null) { // Queue is empty
            System.out.println("Queue is empty, cannot dequeue.");
            return null;
        }
        T data = front.data;
        front = front.next; // Move front to the next node
        if (front == null) { // If the queue is now empty, update rear to null
            rear = null;
        }
        return data;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }
}

public class GenerateBinaryNumbers {

    // Method to generate binary numbers up to a given number n
    public String[] generateBinaryNumbersToN(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Number of binary numbers to generate must be positive.");
        }

        String[] result = new String[n];
        Queue<String> queue = new Queue<>();
        queue.enQueue("1");

        for (int i = 0; i < n; i++) {
            result[i] = queue.deQueue(); // Get the current binary number
            queue.enQueue(result[i] + "0"); // Add "0" to the end of the current binary number and enqueue
            queue.enQueue(result[i] + "1"); // Add "1" to the end of the current binary number and enqueue
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Generate Binary Numbers:");
        GenerateBinaryNumbers generator = new GenerateBinaryNumbers();
        int num = 5;

        try {
            String[] result = generator.generateBinaryNumbersToN(num);
            System.out.println("Generated binary numbers up to " + num + ":");
            for (String binary : result) {
                System.out.println(binary);
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
