package code.missiongoogle;
import java.util.*;

public class TreeB {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int index = -1;
        // Covariant return type
        public Node buildTree(int []Node ){
            index++;
            if (Node[index] == -1){
                return null;
            }
            Node newNode = new Node(Node[index]);
            newNode.left = buildTree(Node);
            newNode.right = buildTree(Node);
            return newNode;
        }
    }

    public static void preOrder(Node root){
        List<Integer> res = new LinkedList<Integer>();
        if (root == null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void postOrder(Node root){
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static void levelOrderTraversal(Node root){
        List<List<Integer>> list = new ArrayList<>();
       if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()){
            Node curNode = q.remove();
            if (curNode == null){
                System.out.println();
                if (q.isEmpty()) break;
                else q.add(null);
            }
            else{
                System.out.print(curNode.data+" ");
                list.add(Collections.singletonList(curNode.data));
            if (curNode.left != null) q.add(curNode.left);
            if (curNode.right != null) q.add(curNode.right);}
        }
    }

    public static int countsOfNode(Node root){
        if (root == null) return 0;
        /*int leftNode = countsOfNode(root.left);
        int rightNode = countsOfNode(root.right);*/
        return countsOfNode(root.left) + countsOfNode(root.right) + 1;
    }

    public static int sumOfNodes(Node root){
        if (root == null) return 0;
        /*int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);*/
        return sumOfNodes(root.left)+sumOfNodes(root.right) + root.data;
    }
    public static int heightOfTheTree(Node root){
        if (root == null) return 0;
        /*int leftHeight = heightOfTheThree(root.left);
        int rightHeight = heightOfTheThree(root.right);
        int maxHeight = Math.max(leftHeight, rightHeight);*/
        return Math.max(heightOfTheTree(root.left), heightOfTheTree(root.right)) + 1;
    }

    public static int diameter(Node root){
        if (root ==  null) return  0;
        int dia1 = diameter(root.left);
        int dia2 = diameter(root.right);
        int dia3 = heightOfTheTree(root.left) + heightOfTheTree(root.right) + 1;
        return Math.max(dia3,Math.max(dia1,dia2));

        /*int lDia = diameter(root.left);
        int rDia = diameter(root.right);
        return Math.max(lDia + rDia + 1 , Math.max(dia1,dia2));*/
    }
    public static void main(String[] args) {
        int []node = new int[] {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree(node);
//        System.out.println(root.data);
        System.out.println("PreOrder");
        preOrder(root);
        System.out.println("\nInOrder");
        inOrder(root);
        System.out.println("\nPostOrder");
        postOrder(root);
        System.out.print("\nLevel Order traversal\n");
        levelOrderTraversal(root);
        int a = countsOfNode(root);
        System.out.println("Number of node present in the tree = "+a);
        int sum = sumOfNodes(root);
        System.out.print("Sum of node = "+sum);
        int height = heightOfTheTree(root);
        System.out.print("\nHeight of the tree = "+height);
        int dia = diameter(root);
        System.out.print("\nDiameter of the tree = "+dia);

     }
}
