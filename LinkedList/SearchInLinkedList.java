public class SearchInLinkedList {
    Node head;
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void print() {
        System.out.print("List: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void search(int data) {
        System.out.println("Search Result: ");
        Node current = head;
        int counter = 0;
        while (current != null) {
            if(current.data == data){
                System.out.println(current.data + " found at index "+counter);
                return;
            }
            current = current.next;
            ++counter;
        }
        System.out.println("Not Found");
       
    }

    public static void main(String[] args) {
        System.out.println("Search In Linked List");
        SearchInLinkedList list = new SearchInLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.print();
        list.search(2);
        list.search(12);
    }
}
