package com.tree;
/*
98. Validate Binary Search Tree

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [2,1,3]
        2
      1    3
Output: true
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(new ValidateBinarySearchTree().isValidBST(root));
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long minValue, long maxValue){
        if(root==null)
            return true;

        if(root.val<=minValue || root.val>=maxValue)
            return false;

        return helper(root.left, minValue, root.val) && helper(root.right, root.val , maxValue);
    }
}
