package code.missiongoogle;




public class Stack1 {
    static Node head;

    static class Node {
       int data;
       Node next;
       Node(int data){
           this.data = data;
           this.next = null;
       }
    }

    public boolean isStackEmpty(){
        return head == null;
    }

    public void push(int data){
        Node newNode = new Node(data);
        if (isStackEmpty()){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void display(){
        Node cur = head;
        if (isStackEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        while (cur != null){
            System.out.println(" "+cur.data);
            cur = cur.next;
        }
    }

    public int pop(){
        if (isStackEmpty()){
            System.out.println("Stack is e");
            return -1;
        }
        int top = head.data;
        head = head.next;
        return top;
    }
    public int peek(){
        if (isStackEmpty()){
            System.out.println(" ");
            return -1;
        }
        return head.data;
    }
    public static void main(String[] args) {
            Stack1 st = new Stack1();
           st.push(7);
           st.push(8);
           st.push(6);
           st.push(5);
           st.push(4);
           st.peek();
//           st.pop();
//           st.pop();
//           st.pop();

            st.display();
    }
}
