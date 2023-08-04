package com.tree;
/*
250. Count Univalue Subtrees

Given the root of a binary tree, return the number of uni-value
subtrees
.

A uni-value subtree means all nodes of the subtree have the same value.



Example 1:
Input: root = [5,1,5,5,5,null,5]
Output: 4

TC: o(n)
SC: o(logn)
 */
public class CountUnivalueSubtrees {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(5);
        System.out.println(new CountUnivalueSubtrees().countUnivalSubtrees(root));
    }
    int count=0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root==null)
            return 0;
        util(root);
        return count;
    }
    private boolean util(TreeNode root){
        if(root==null)
            return true;
        boolean left = util(root.left);
        boolean right = util(root.right);
        if(left && right){
            if(root.left!=null && root.left.val != root.val)
                return false;
            if(root.right!=null && root.right.val != root.val)
                return false;
            count++;
            return true;
        }
        return false;
    }
}
