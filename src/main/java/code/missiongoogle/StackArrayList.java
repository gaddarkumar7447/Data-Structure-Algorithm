package code.missiongoogle;

import java.util.ArrayList;
import java.util.Stack;

public class StackArrayList {

    static class stackArray{
        static ArrayList<Integer> list = new ArrayList<>();
        public boolean isListEmpty(){
            return list.size() == 0;
        }
        public static void push(int data){

        }
        public int pop(){
            if (isListEmpty()){
                System.out.println("Sack is empty");
                return -1;
            }
            int top = list.get(list.size())-1;
            list.remove(list.size()-1);
            return top;
        }
        public int peek(){
            if (isListEmpty()){
                System.out.println("Sack is empty");
                return -1;
            }
            return list.get(list.size())-1;
        }

    }

    public static void pushAtBottom(int data, Stack<Integer> s){
        if (!s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(data, s);
        s.push(data);
    }

    public static void reverse(Stack<Integer> s){
        if (s.isEmpty()) return;
        int top = s.pop();
        pushAtBottom(top, s);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(90);
        pushAtBottom(10000,stack);
        pushAtBottom(520,stack);
        pushAtBottom(963,stack);
        stack.pop();
//        System.out.println(stack);
        reverse(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
