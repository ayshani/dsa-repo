package com.tree;
/*
104. Maximum Depth of Binary Tree

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down
to the farthest leaf node.



Example 1:Input: root = [3,9,20,null,null,15,7]
Output: 3

TC : o(n)
SC : o(logn)
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right =  new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right =  new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(root));
    }
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left_height = maxDepth(root.left);
        int right_height = maxDepth(root.right);
        return Math.max(left_height, right_height) +1;
    }
}
