package com.tree;
/*
958. Check Completeness of a Binary Tree

Given the root of a binary tree, determine if it is a complete binary tree.

In a complete binary tree, every level, except possibly the last, is completely filled,
and all nodes in the last level are as far left as possible. It can have between 1 and 2h
nodes inclusive at the last level h.

Example 1:
Input: root = [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}),
and all nodes in the last level ({4, 5, 6}) are as far left as possible.


TC : o(n)
SC: o(logn)
 */
public class CheckCompletenessOfABinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new CheckCompletenessOfABinaryTree().isCompleteTree(root));
    }
    int maxPos, size;
    public boolean isCompleteTree(TreeNode root) {
        maxPos=0;
        size=0;
        preorder(root,1);
        return maxPos==size;
    }

    private void preorder(TreeNode root,int pos){
        if(root==null)
            return;
        maxPos = Math.max(maxPos,pos);
        size++;
        preorder(root.left,2*pos);
        preorder(root.right, 2*pos+1);
    }
}
