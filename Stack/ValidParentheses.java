public class ValidParentheses {
    Node top;
    int length;

    public class Node {
        char data;
        Node next;

        public Node(char data) {  // Change to accept char data
            this.data = data;
            this.next = null;
        }
    }

    public ValidParentheses() {
        this.top = null;
        this.length = 0; // Initialize length
    }

    public void push(char data) {  // Change to accept char data
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        length++; // Increment the length
    }

    public char pop() {  // Change return type to char
        if (top == null) {
            throw new IllegalStateException("Stack is empty"); // Handle empty stack
        }
        char val = top.data;  // Change to char
        top = top.next;
        length--; // Decrement the length
        return val;
    }

    public boolean isEmpty() {
        return top == null;
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

    // Method to check if the expression has valid parentheses
    public boolean check(String exp) {
        for (char ch : exp.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                push(ch);
            } else {
                if (isEmpty()) {  // Handle case where closing parenthesis has no matching opening
                    return false;
                }
                char topChar = pop();
                if ((ch == ')' && topChar != '(') ||
                    (ch == '}' && topChar != '{') ||
                    (ch == ']' && topChar != '[')) {
                    return false;
                }
            }
        }
        return isEmpty();  // Stack should be empty if all parentheses are matched
    }

    public static void main(String[] args) {
        System.out.println("Valid Parentheses");
        ValidParentheses stack = new ValidParentheses();
        String exp = "{()}";
        boolean res = stack.check(exp);
        System.out.println("Output: " + res);  // Output: true for valid expression

        String exp2 = "{(})";
        boolean res2 = stack.check(exp2);
        System.out.println("Output: " + res2);  // Output: false for invalid expression
    }
}
