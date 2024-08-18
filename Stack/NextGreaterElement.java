import java.util.Arrays;

public class NextGreaterElement {
    Node top;
    int length;

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public NextGreaterElement() {
        this.top = null;
        this.length = 0; // Initialize length
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        length++; // Increment the length
    }

    public int pop() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty"); // Handle empty stack
        }
        int val = top.data;
        top = top.next;
        length--; // Decrement the length
        return val;
    }

    public void print() {
        System.out.print("Stack using Linked List: ");
        Node cur = top;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    // Method to find the next greater element for each element in the array
    public int[] findNextGreaterElement(int[] arr) {
        int[] res = new int[arr.length];
        System.out.println("Finding the Next Greater Element for each item:");
        for (int i = arr.length - 1; i >= 0; i--) {
            while (top != null && top.data <= arr[i]) {
                pop();
            }
            int nextGreater = (top != null) ? top.data : -1;
            push(arr[i]);
            res[i] = nextGreater;
        }
        return res;

    }

    public static void main(String[] args) {
        NextGreaterElement ngeStack = new NextGreaterElement();
        int[] arr = {4, 7, 3, 4, 8, 1};
        int[] res = ngeStack.findNextGreaterElement(arr);
        System.out.println(" Next Greater Element: " +Arrays.toString(res));

    }
}
