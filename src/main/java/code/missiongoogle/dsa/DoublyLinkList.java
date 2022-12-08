package code.missiongoogle.dsa;

public class DoublyLinkList {
    static ListNode head;
    static ListNode tail;
    static class ListNode{
        int data;
        ListNode previous;
        ListNode next;
        public ListNode(int d){
            this.data = d;
            this.next = null;
            this.previous = null;
        }
    }

    public void createD(int data){
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            tail = null;
            return;
        }
        head.previous = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void insertAtLast(int data){
        ListNode n = new ListNode(data);
        ListNode cu = head;
        if (head == null){
            head = n;
            tail = null;
            return;
        }
        while (cu.next != null){
            cu = cu.next;
        }
        cu.next = n;
        n.next = tail;
        n.previous = cu;
    }

    public void print(){
        ListNode cur = head;
        if (head == null){
            System.out.println("Linked list are empty");
            return;
        }
        /*System.out.println(" "+cur.data);
        System.out.println(" "+tail);*/
        while (cur != tail){
            System.out.print(" "+cur.data);
            cur = cur.next;
        }
        System.out.print(" Tail");
    }

    public void keyDelete(int key){
        ListNode cur = head;
        ListNode temp = null;
        if (head == null){
            System.out.println("LinkList in empty");
            return;
        }
        /*while (cur != null || cur.next != key){
            temp = head;
            cur = cur.next;

        }*/
    }
    public static void main(String[] args){
        DoublyLinkList linkList = new DoublyLinkList();
        linkList.createD(100);
        linkList.createD(200);
        linkList.createD(300);
        linkList.createD(400);
        linkList.insertAtLast(1000);
        linkList.insertAtLast(11110);


        linkList.print();
        System.out.print("\nAfter last inserting\n");
        linkList.print();
    }
}
