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

    public void AddList(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void AddLast(int data){
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
        li.AddList(100);
        li.AddList(200);
        li.AddList(300);
        li.AddList(400);

        li.AddLast(1000);

        li.printList();

    }
}
