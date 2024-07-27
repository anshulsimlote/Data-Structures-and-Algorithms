public class DeleteFirstNode{
    Node head;
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
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
    public void print(){
        System.out.println("Print");
        Node cur = head;
        while(cur != null){
            System.out.print(cur.data+", ");;
            cur = cur.next;
        }
        System.out.println("");
    }
    public void deleteFirst(){
        head = head.next;
       
    }
    public static void main(String[] args){
        System.out.println("Delete First Node");
        DeleteFirstNode sl = new DeleteFirstNode();
        sl.insert(1);
        sl.insert(2);
        sl.insert(3);
        sl.insert(4);
        sl.print();
        sl.deleteFirst();
        sl.print();
    }
}