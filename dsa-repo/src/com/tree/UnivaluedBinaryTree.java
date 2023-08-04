package com.tree;
/*
965. Univalued Binary Tree

A binary tree is uni-valued if every node in the tree has the same value.

Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.



Example 1:
Input: root = [1,1,1,1,1,null,1]
Output: true

TC  : o(n)
SC: o(logn)
 */
public class UnivaluedBinaryTree {

    int singleValue;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        System.out.println(new UnivaluedBinaryTree().isUnivalTree(root));
    }
    public boolean isUnivalTree(TreeNode root) {
        if(root==null)
            return true;
        singleValue = root.val;
        return check(root);
    }
    private boolean check(TreeNode root){
        if(root==null)
            return true;
        if(root.val!=singleValue)
            return false;
        return check(root.left) && check(root.right);
    }
}
