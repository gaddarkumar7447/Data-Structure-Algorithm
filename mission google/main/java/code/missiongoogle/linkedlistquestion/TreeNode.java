package code.missiongoogle.linkedlistquestion;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    static class BinaryTree {
        static int index = -1;
        // Covariant return type
        public TreeNode buildTree(int []Node ){
            index++;
            if (Node[index] == -1){
                return null;
            }
            TreeNode newNode = new TreeNode(Node[index]);
            newNode.left = buildTree(Node);
            newNode.right = buildTree(Node);
            return newNode;
        }
    }
}

class Solution {
    List<Integer> list = new ArrayList<>();
    List<Integer> list1 = new ArrayList<>();
    public boolean isSameTree(TreeNode p, TreeNode q) {
        firstTree(p);
        secondTree(q);
        return list == list1;
    }

    private void secondTree(TreeNode q) {
        if (q == null) return;
        list1.add(q.val);
        secondTree(q.left);
        secondTree(q.right);
    }

    private void firstTree(TreeNode p) {
        if (p == null) return;
        list1.add(p.val);
        firstTree(p.left);
        firstTree(p.right);
    }

    public static void main(String[] args) {
        TreeNode.BinaryTree tree = new TreeNode.BinaryTree();
        int []nums = {1,2,3};
        int[] nums1 = {1, 2, 3};
        TreeNode node = tree.buildTree(nums1);
        TreeNode node1 = tree.buildTree(nums);

        Solution solution = new Solution();
        solution.isSameTree(node1, node);


    }
}