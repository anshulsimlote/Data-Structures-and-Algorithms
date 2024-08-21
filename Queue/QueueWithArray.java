package Queue;

class QueueWithArray {
    int front, rear, capacity;
    int[] queue;

    // Constructor to initialize the queue
    QueueWithArray(int c) {
        front = 0;
        rear = -1;
        capacity = c;
        queue = new int[capacity];
    }

    // Function to insert an element at the rear of the queue
    void enqueue(int data) {
        // Check if the queue is full
        if (rear == capacity - 1) {
            System.out.println("Queue is full");
            return;
        }

        // Insert element at the rear
        queue[++rear] = data;
    }

    // Function to delete an element from the front of the queue
    void dequeue() {
        // If the queue is empty
        if (front > rear) {
            System.out.println("Queue is empty");
            return;
        }

        // Shift all elements from index 1 till rear to the left by one
        for (int i = 0; i < rear; i++) {
            queue[i] = queue[i + 1];
        }

        // Decrement rear
        rear--;
    }

    // Function to print queue elements
    void display() {
        if (front > rear) {
            System.out.println("Queue is Empty");
            return;
        }

        // Traverse front to rear and print elements
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " <-- ");
        }
        System.out.println();
    }

    // Function to print the front of the queue
    void front() {
        if (rear == -1) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("Front Element is: " + queue[front]);
    }

    public static void main(String[] args) {
        // Create a queue of capacity 4
        QueueWithArray q = new QueueWithArray(4);

        // Print queue elements
        q.display();

        // Insert elements in the queue
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        // Print queue elements
        q.display();

        // Insert element in the queue
        q.enqueue(60);

        // Print queue elements
        q.display();

        // Dequeue elements
        q.dequeue();
        q.dequeue();

        System.out.println("After two node deletions");

        // Print queue elements
        q.display();

        System.out.println("After one insertion");
        q.enqueue(60);

        // Print queue elements
        q.display();

        // Print front of the queue
        q.front();
    }
}
