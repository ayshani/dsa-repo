package com.tree;
/*
Maximum sum leaf to root path
https://practice.geeksforgeeks.org/problems/maximum-sum-leaf-to-root-path/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
Given a Binary Tree, find the maximum sum path from a leaf to root.


Example 1:

Input:
        1
       / \
      2   3
Output:
4
Explanation:
Following the path 3 -> 1, results in a
sum of 4, which is the maximum path sum
from leaf to root for the given tree.

TC : o(n)
SC: o(logn)
 */
public class MaximumSumLeafToRootPath {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(MaximumSumLeafToRootPath.maxPathSum(root));
    }
    public static int maxPathSum(TreeNode root)
    {
        //code here
        return util(root);
    }

    private static int util(TreeNode root){
        if(root==null)
            return Integer.MIN_VALUE;
        if(root.left==null && root.right==null)
            return root.val;

        int left = util(root.left);
        int right = util(root.right);

        return Math.max(left,right) + root.val;
    }
}
