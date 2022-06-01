package code.missiongoogle;

public class LS1 {
    static Node head;
    public static class Node{
        int data;
        Node next;
        Node(int d){
            this.data = d;
            this.next = null;
        }
    }

    public void addList(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node new1Node = new Node(data);
        if (head  == null){
            head = new1Node;
            return;
        }
        Node current = head;
        while (current.next != null)
        {
            current = current.next;
        }
        current.next = new1Node;
    }

    public void printList(){
        Node cur = head;
        if (head == null)
        {
            System.out.println("Linked is empty");
        }
        while (cur != null)
        {
            System.out.print(" -> "+cur.data);
            cur = cur.next;
        }
        System.out.println(" Null");

    }


    public static void main(String[] args) {
        LS1 li = new LS1();
        li.addList(100);
        li.addList(200);
        li.addList(300);
        li.addList(400);

        li.addLast(1000);

        li.printList();

    }
}
