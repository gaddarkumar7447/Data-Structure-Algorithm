package code.missiongoogle;
public class LS11 {
    static Node head;
    public class Node{
        int data;
        Node next;
        Node(int d){
            this.data = d;
            this.next = null;
        }
    }
    public void AdList(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void ALast(int data){
        Node newNode1 = new Node(data);
        if (head == null){
            head = newNode1;
            return;
        }
        Node cur = head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = newNode1;
    }

    public static void printList(){
        Node n = head;
        if (head == null){
            System.out.println("Linked list is null");
            return;
        }
        while (n != null){
            System.out.print(" -> "+n.data);
            n = n.next;
        }
        System.out.print(" Null");
    }

    public void Delete(int data){
        Node key = new Node(data);
        if (head == null){
            System.out.println("Head is already null");
            return;
        }
        while (head.next == key)
        {
            if (head != key)
                System.out.println("This number is not present in the list");
            else
                head = head.next;
        }

    }

    /*public void deleteFirst(){
        if (head == null){
            System.out.println("Linked is already empty");
            return;
        }
        head = head.next;
    }*/

    /*public void deleteLast(){
        if (head == null)
        {
            System.out.println("Linked list already empty");
            return;
        }
        if (head.next == null)
        {
            head = null;
            return;
        }
        Node secondLast = head;
        Node lastNode = head.next;
        while (lastNode.next != null)
        {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }

    }*/

    public void deleteKey(int key){
        Node currentNode = head;
        Node temp = null;
        while(currentNode != null && currentNode.data != key){
            temp = currentNode;
            currentNode = currentNode.next;
        }
        if (currentNode == null)
            return;
        temp.next = currentNode.next;

    }

    public static void main(String[] args) {
        LS11 as = new LS11();
        as.AdList(50);
        as.AdList(100);
        as.AdList(200);
        as.AdList(300);
        as.AdList(500);
        as.ALast(900);
        as.ALast(800);
        as.ALast(700);

        as.deleteKey(300);
        as.deleteKey(50);
        as.printList();

    }
}
