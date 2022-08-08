package code.missiongoogle;

import java.util.Scanner;
public class DemoClass {
        static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
            System.out.println("Gaddar");
        }
    }
    static class BinaryTreeBST{
        static int index = -1;
        public Node buildTree(int []arr){

            index++;
            Node newNode = new Node(arr[index]);
            if (arr[index] == -1) return null;
            newNode.left = buildTree(arr);
            newNode.right = buildTree(arr);
            return newNode;
        }
    }
    public class Encap{
       private int cap;
        public int getCap() {
            return cap;
        }

        public void setCap(int cap) {
            this.cap = cap;
        }
    }

}
