package code.missiongoogle;

import jdk.jshell.spi.ExecutionControlProvider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

class pp{
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int data) {
            this.val = data;
            this.next = null;
        }
    }
    private static ListNode mergeSort(ListNode list1, ListNode list2) {

        /*if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val > list2.val){
            ListNode a = list1;
            list1 = list2;
            list2 = a;
        }
        ListNode newNode = list1;
        while (list1 != null && list2 != null){
            ListNode temp = new ListNode(-1);
            System.out.println(temp);
            while (list1 != null && list1.val <= list2.val){
                temp = list1;
                list1 = list1.next;
            }
            temp.next = list2;
            ListNode swap = list1;
            list1 = list2;
            list2 = list1;
            list1 = swap;
        }
        return newNode;*/
       ListNode head = null;
        if (list1 == null) {
            return list2;
        }
        else if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            head = list1;
            head.next = mergeSort(list1.next, list2);
        }
        else {
            head = list2;
            head.next = mergeSort(list1, list2.next);

        }
        return head;
    }

    public static void main(String[] args)  {
        /*BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringReader s = new StringReader(bf.readLine());*/
            ListNode list1 = new ListNode(1);
            list1.next = new ListNode(5);
            list1.next.next = new ListNode(10);
            list1.next.next.next = new ListNode(12);

            ListNode list2 = new ListNode(2);
            list2.next = new ListNode(3);
            list2.next.next = new ListNode(9);

            ListNode a = mergeSort(list1,list2);
           while (a != null){
               System.out.print(a.val+" ");
               a = a.next;
           }

    }


}


