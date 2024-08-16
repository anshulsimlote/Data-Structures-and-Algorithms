public class ReverseStringUsingStack {
    private char[] stackArr;
    private int maxSize;
    private int top;

    // Constructor to initialize the stack
    public ReverseStringUsingStack(int size) {
        this.maxSize = size;
        this.stackArr = new char[maxSize];
        this.top = -1; // Stack is initially empty, so top is set to -1
    }

    // Push element onto the stack
    public void push(char data) {
        if (top >= maxSize - 1) {
            throw new StackOverflowError("Stack is full. Cannot push more elements.");
        }
        stackArr[++top] = data; // Increment top and add element
    }

    // Pop element from the stack
    public char pop() {
        if (top < 0) {
            throw new RuntimeException("Stack is empty. Cannot pop elements.");
        }
        return stackArr[top--]; // Return the top element and decrement top
    }

    // Main method to reverse a string using stack
    public static void main(String[] args) {
        System.out.println("Reverse String Using Stack");

        String str = "abcde";
        System.out.println("Actual "+str);
        ReverseStringUsingStack stack = new ReverseStringUsingStack(str.length()); // Stack size set to string length

        // Push all characters of the string into the stack
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        // Use StringBuilder for efficient string concatenation
        StringBuilder reversedStr = new StringBuilder();

        // Pop all characters from the stack and append to the result
        while (stack.top != -1) {
            reversedStr.append(stack.pop());
        }

        // Convert StringBuilder to String and print the result
        System.out.println("Reverse "+reversedStr.toString());
    }
}
