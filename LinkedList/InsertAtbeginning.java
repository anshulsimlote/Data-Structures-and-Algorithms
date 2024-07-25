package LinkedList;

public class InsertAtbeginning {
    Node head;
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }        
    }

    public void insertAtbeginning(int data){
        Node temp = new Node(data);
        if(head == null){
            head = temp;
        }else{
            temp.next = head;
            head = temp;
        }
    }

    public void print(){
        if(head != null){
            Node curNode = head;
            while(curNode != null){
                System.out.println(curNode.data);
                curNode = curNode.next;
            }
        }
    }

    public static void main(String[] args){
        System.out.println("Insert At beginning");
        InsertAtbeginning sList = new InsertAtbeginning();
        sList.insertAtbeginning(5);
        sList.insertAtbeginning(4);
        sList.insertAtbeginning(3);
        sList.insertAtbeginning(2);
        sList.insertAtbeginning(1);
        sList.print();
    }

}
