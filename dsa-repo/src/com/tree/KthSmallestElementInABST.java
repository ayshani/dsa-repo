package com.tree;
/*
230. Kth Smallest Element in a BST

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all
the values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1
 */
public class KthSmallestElementInABST {
    int count;

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
        System.out.println(new KthSmallestElementInABST().kthSmallest(root,3));
    }
    public int kthSmallest(TreeNode root, int k) {
        count =k;

        return inorder(root);
    }

    private int inorder(TreeNode root){
        if(root==null)
            return 0;
        int left =inorder(root.left);
        if(left>0)
            return left;
        count--;
        if(count==0)
            return root.val;
        int right =inorder(root.right);
        if(right>0)
            return right;
        return 0;
    }
}
