package code.missiongoogle.dsa;
import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

class Solution {
    ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != tempB){
            //tempA = tempA != null ? tempA.next : headB;
            if (tempA != null){
                tempA = tempA.next;
            }
            else {
                tempA = headB;
            }
            //tempB = tempB != null ? tempB.next : headA;
            if (tempB != null){
                tempB = tempB.next;
            }else {
                tempB = headA;
            }
        }
        return tempA;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Solution sol = new Solution();

    }

}