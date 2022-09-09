package com.tree;
/*
1448. Count Good Nodes in Binary Tree

Given a binary tree root, a node X in the tree is named good if in the path from root
to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.

Example 1:
Input: root = [3,1,4,3,null,1,5]
            3
         1     4
       3     1    5
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.

Logic
------
Record the maximum value along the path from the root to the node.

TC:  O(N)
Sc : O(height)
 */
public class CountGoodNodesInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(new CountGoodNodesInBinaryTree().goodNodes(root));
    }
    public int goodNodes(TreeNode root) {
        return good(root,Integer.MIN_VALUE);
    }

    private int good(TreeNode root, int maxValue){
        if(root==null)
            return 0;
        int res = root.val>=maxValue ? 1: 0;

        res+= good(root.left, Math.max(root.val, maxValue));
        res+= good(root.right, Math.max(root.val, maxValue));

        return res;
    }
}
