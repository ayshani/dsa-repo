package com.tree;
/*
100. Same Tree

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true

TC : o(n)
SC: o(logn)
 */
public class SameTree {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println(new SameTree().isSameTree(root1,root2));
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if(p== null || q== null)
            return false;
        if(p.val!=q.val)
            return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

}
