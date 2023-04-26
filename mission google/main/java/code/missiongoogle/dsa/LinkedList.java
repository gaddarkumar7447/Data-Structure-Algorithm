package code.missiongoogle.dsa;

public class LinkedList {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node last = new Node(data);
        if (head == null) {
            head = last;
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = last;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("Linked is already empty");
            return;
        }
        head = head.next;
    }

    public void deleteKey(int key) {
        Node seco1nd = new Node(0);

        Node second = head;
        Node tem = null;
        while (second != null && second.data != key) {
            tem = head;
            second = second.next;
        }
        if (second == null) {
            return;
        }
        tem.next = second.next;
    }

    public void reverseIterate() {
        if (head == null || head.next == null) return;
        Node previous = head;
        Node currentNode = head.next;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            currentNode.next = previous;
            previous = currentNode;
            currentNode = nextNode;
        }
        head.next = null;
        head = previous;
    }

    /*//*public Node reverseI(Node head){
        if (head == null || head.next == null) return head;
        Node newN = reverseI(head.next);
        head.next.next = head;
        head.next =null;
        return newN;
    }*/

    public void findNode() {
        if (head == null) return;
        Node cur = head;
        int size = 0;
        while (cur != null) {
            cur = cur.next;
        }
        System.out.println(cur);
    }

    public void displayList() {
        Node current = head;
        while (current != null) {
            System.out.print(" " + current.data);
            current = current.next;
        }
        System.out.print(" Null");

    }

    public Node deleteFromLast(int num) {
        Node newNode = new Node(0);
        newNode.next = head;
        Node cur = newNode, nth = newNode;
        for (int i = 0; i <= num + 1; i++) {
            cur = cur.next;
        }
        while (cur != null) {
            cur = cur.next;
            nth = nth.next;
        }
        nth.next = nth.next.next;
        return newNode.next;
    }


    public static void main(String[] args) {


        LinkedList la = new LinkedList();
        Node a = new Node(23);

        la.addFirst(100);
        la.addFirst(200);
        la.addFirst(300);
        la.addFirst(400);
        la.addFirst(500);
        la.addFirst(600);
        la.addFirst(700);
        la.displayList();

      /* la.addLast(900);
       la.addLast(800);
       la.addLast(700);
       la.addLast(500);
       la.addLast(300);
       la.addLast(200);*/

//       la.deleteKey(300);
        /*out.println("Gaddar");
       la.displayList();
        System.out.println("\nAfter reverse Iterator of linked list");
        la.deleteFromLast(2);
        la.displayList();*/

//      la.reverseIterate();
//        la.head = la.reverseI(la.head);
//       la.reverseI(la.head);
//       la.displayList();


    }
}
