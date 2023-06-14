package com.tree;
/*
530. Minimum Absolute Difference in BST

Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any
two different nodes in the tree.

Example 1:
Input: root = [4,2,6,1,3]
Output: 1

TC : o(n)
SC : o(n)
 */
public class MinimumAbsoluteDifferenceInBST {

    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(new MinimumAbsoluteDifferenceInBST().getMinimumDifference(root));
    }
    public int getMinimumDifference(TreeNode root) {
        if(root== null)
            return min;
        getMinimumDifference(root.left);
        if(prev != null)
            min = Math.min(min, root.val -prev);
        prev = root.val;
        getMinimumDifference(root.right);
        return min;
    }
}
