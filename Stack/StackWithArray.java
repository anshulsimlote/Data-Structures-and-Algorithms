public class StackWithArray {
    private int[] stackArray; // Array to store stack elements
    private int top; // Index of the top element
    private int maxSize; // Maximum capacity of the stack

    // Constructor to initialize the stack
    public StackWithArray(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; // Stack is initially empty, so top is set to -1
    }

    // Push an element onto the stack
    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + data);
            return;
        }
        stackArray[++top] = data; // Increment top and add element
    }

    // Pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1; // Return -1 as an indicator of an empty stack
        }
        return stackArray[top--]; // Return the top element and decrement top
    }

    // Peek at the top element of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1; // Return -1 as an indicator of an empty stack
        }
        return stackArray[top]; // Return the top element
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Get the current size of the stack
    public int size() {
        return top + 1;
    }

    // Print the stack elements
    public void print() {
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Stack Implementation Using Array");

        StackWithArray stack = new StackWithArray(5); // Create a stack with a maximum size of 5

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.print(); // Stack: 10 20 30

        System.out.println("Top element: " + stack.peek()); // Top element: 30

        stack.pop();
        stack.print(); // Stack: 10 20

        System.out.println("Stack size: " + stack.size()); // Stack size: 2

        stack.push(40);
        stack.push(50);
        stack.push(60); // Stack is full now
        stack.push(70); // Attempt to push onto a full stack

        stack.print(); // Stack: 10 20 40 50 60
    }
}
