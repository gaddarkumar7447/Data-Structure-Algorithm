package code.missiongoogle;


public class treeS {

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
    static class EBinary {
        static int index = -1;
        public Node build(int []Node){
            index++;
            if (Node[index] == -1) return null;
            Node newNode = new Node(Node[index]);
            newNode.left = build(Node);
            newNode.right = build(Node);
            return newNode;
        }
    }

    public static void preOrder(Node root){
        if (root == null) return;
        System.out.println(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static int numberOf(Node root){
        if (root == null) return 0;
        return (numberOf(root.right) + numberOf(root.right) + 1);
    }

    public static int height(Node root){
        if (root == null) return 0;
        int a1 = height(root.left);
        int a2 = height(root.right);
        int a3 = (a1 + a2 + 1);
        return Math.max(a3,Math.max(a1,a2) +1);
    }
    public static void main(String[] args) {
        int []n = new int[] {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        EBinary eBinary = new EBinary();
        Node root = eBinary.build(n);
//        preOrder(root);
        System.out.println("Number of node present in the tree: "+numberOf(root));
        System.out.println("Height of the tree: "+height(root));

    }



}
