package com.tree;
/*
543. Diameter of Binary Tree

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

Example 1:
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
TC : o(n)
SC: o(logn)
 */
public class DiameterOfBinaryTree {
    int path =0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);

        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return path;
    }

    private int maxDepth(TreeNode root){
        if(root==null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        path = Math.max(path, leftDepth+rightDepth);
        return Math.max(leftDepth,rightDepth)+1;
    }
}
