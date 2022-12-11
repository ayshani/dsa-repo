package com.tree;
/*
124. Binary Tree Maximum Path Sum

A path in a binary tree is a sequence of nodes where each pair of
adjacent nodes in the sequence has an edge connecting them.
A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

Example 2:
Input: root = [-10,9,20,null,null,15,7]
            -10
          9      20
               15    7

Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.

 */
public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
    }
    int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue =Integer.MIN_VALUE;
        getMaxSum(root);
        return maxValue;
    }

    private int getMaxSum(TreeNode root){
        if(root==null)
            return 0;
        // Get maximum sum from left sub tree
        int leftSum = Math.max(0,getMaxSum(root.left));
        // Get maximum sum from right sub tree
        int rightSum = Math.max(0,getMaxSum(root.right));

        // check if wwe already have one maxValue
        maxValue = Math.max(maxValue, leftSum+ root.val+ rightSum);

        return Math.max(leftSum, rightSum) + root.val;
    }
}
