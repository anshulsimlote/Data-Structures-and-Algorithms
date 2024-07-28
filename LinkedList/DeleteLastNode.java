public class DeleteLastNode {
    Node head;
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void deleteLastNode(){
        Node cur = head;
        while(cur.next.next != null){
            cur = cur.next;
        }
        cur.next = null;
    }
    public void print(){
        System.out.println("Print ");
        Node cur = head;
        while(cur != null){
            System.out.print(cur.data+", ");
            cur = cur.next;
        }
        System.out.println(" ");
    }
    public void insert(int data){
        Node temp = new Node(data);
        if(head == null){
            head = temp;
        }else{
            Node cur = head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = temp;
        }
    }
    public static void main(String[] args){
        System.out.println("Delete Last Node");
        DeleteLastNode sl = new DeleteLastNode();
        sl.insert(1);
        sl.insert(2);
        sl.insert(3);
        sl.insert(4);
        sl.insert(5);
        sl.print();
        sl.deleteLastNode();
        sl.print();

    }
}
