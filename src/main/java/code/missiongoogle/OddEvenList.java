package code.missiongoogle;

public class OddEvenList {
    static Node head;
    public static class Node{
        int data;
        Node next;
        Node(int d){
            this.data = d;
            this.next = null;
        }
    }

    public void createNode(int data){
        Node newNode = new Node(data);
        if (head == null)
        {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void checkOdd(){
        if (head == null) return;
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;
        while (even != null && even.next !=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
    }

    public void display(){
        Node cu = head;
        if (head == null){
            System.out.println("Linked is null");
            return;
        }
        while(cu != null)
        {
            System.out.print(" -> "+cu.data);
            cu = cu.next;
        }
        System.out.print(" null");
    }

    public static void main(String[] args) {
    OddEvenList la = new OddEvenList();
    la.createNode(100);
    la.createNode(200);
    la.createNode(300);
    la.createNode(400);
    la.createNode(500);
    la.createNode(600);
    la.createNode(700);
    la.createNode(800);
    la.createNode(900);
    la.createNode(1000);
    la.createNode(1100);
    la.createNode(1200);

        System.out.println("Before not arrange linked list");
        la.display();
        System.out.println("\nAfter arrange linked list");
        la.checkOdd();
        la.display();
    }
}
