package code.missiongoogle;

import java.util.LinkedList;

public class StreamMain  {
    static ListNode head;
    static ListNode tail;
    static class ListNode{
        int data;
        ListNode next;
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        public static void creteList(int data){
            ListNode newList = new ListNode(data);
            if (head == null) {
                head = newList;
                tail = newList;
                return;
            }
            tail.next = newList;
            tail = newList;
        }

        public static void addFirst(int data){
            ListNode add = new ListNode(data);
            if (head == null) {
                head = add;
                tail = add;
                return;
            }
            add.next = head;
            head = add;
        }

        public static void addLast(int data){
            ListNode curr = head;
            ListNode adL = new ListNode(data);
            while (curr.next != null){
                curr = curr.next;
            }
            curr.next = adL;
        }

        public static int countNumberOfNode(){
            int count = 0;
            while (head != null){
                count++;
                head = head.next;
            }
            return count;
        }

        public static void searchElement(int data){
            if (head == null){
                System.out.println("List is empty");
                return;
            }
            int i = 0;
            while (head != null){
                if (head.data == data){
                    System.out.println("find "+i);
                    return;
                }
                head = head.next;
                i++;
            }
        }

        public static void reverseL(){
            ListNode p = null;
            while (head != null){
                ListNode te = head.next;
                head.next = p;
                p = head;
                head = te;
            }
            display();
        }

        public static void display(){
            ListNode cur = head;
            while (cur != null){
                System.out.print(cur.data+"->");
                cur = cur.next;
            }
        }

    }

    public static void main(String[] args) {

        ListNode.creteList(10);
        ListNode.creteList(20);
        ListNode.creteList(30);

        ListNode.addFirst(5);
        ListNode.addLast(40);

        //ListNode.searchElement(40);
        //System.out.println(ListNode.countNumberOfNode());
        ListNode.reverseL();



    }
}























/*char []v = {'k','l','o','3'};
        String  str = new String(v, 1, 3);
        System.out.println(str);*/

        /*List<String> list = List.of("Gaddar", "Amit", "Gudiya", "Ravi");
        List<String> a = list.stream().filter(e -> e.startsWith("G")).collect(toList());
        System.out.println(a);
        List<Integer> num = List.of(1,2,3,4,5,6,7,8,9);
        List<Integer> num1 = num.stream().map(e -> e * e).collect(toList());

        System.out.println(num1);*/