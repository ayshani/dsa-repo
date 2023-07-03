package com.tree;
/*
110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

Example 1:Input: root = [3,9,20,null,null,15,7]
Output: true

TC : o(n)
SC : o(logn)
 */
public class BalancedBinaryTree {
    boolean result;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        System.out.println(new BalancedBinaryTree().isBalanced(root));
    }
    public boolean isBalanced(TreeNode root) {
        result = true;
        getHeight(root);
        return result;
    }
    private int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(Math.abs(leftHeight-rightHeight)>1){
            result = false;
        }
        return Math.max(leftHeight,rightHeight)+1;
    }
}
