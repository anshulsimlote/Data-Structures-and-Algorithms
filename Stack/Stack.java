public class Stack {
    private Node top;
    private int length;

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Stack() {
        this.top = null;
        this.length = 0; // Initialize the length of the stack
    }

    // Push an element onto the stack
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        length++; // Increment the length
    }

    // Pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1; // Returning -1 as an indicator of an empty stack
        }
        int poppedData = top.data;
        top = top.next;
        length--; // Decrement the length
        return poppedData;
    }

    // Peek at the top element of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1; // Returning -1 as an indicator of an empty stack
        }
        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Get the current size of the stack
    public int size() {
        return length;
    }

    // Print the stack
    public void print() {
        System.out.print("Stack using Linked List: ");
        Node cur = top;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Stack Implementation");
        Stack stack = new Stack();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.print(); // Stack: 3 2 1 0
        
        System.out.println("Top element: " + stack.peek()); // Top element: 3
        
        stack.pop();
        stack.print(); // Stack: 2 1 0
        
        stack.pop();
        stack.pop();
        stack.print(); // Stack: 0
        
        System.out.println("Is stack empty? " + stack.isEmpty()); // Is stack empty? false
        
        stack.pop();
        stack.print(); // Stack:
        
        System.out.println("Is stack empty? " + stack.isEmpty()); // Is stack empty? true
    }
}
