package com.tree;
/*
108. Convert Sorted Array to Binary Search Tree

Given an integer array nums where the elements are sorted in ascending order,
convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every
node never differs by more than one.

Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Logic
------
Get middle and create the root.
then o-mid for left sub tree and mid+1 to n for right sub tree.

TC : o(n)
SC : o(n)
 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode root = new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(nums);
        new TreeTraversal().printTreeLevelOrder(root);
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return recur(nums,0,nums.length-1);
    }

    private TreeNode recur(int[] nums, int start, int end){
        if(start>end)
            return null;
        if(start==end){
            TreeNode tn = new TreeNode(nums[start]);
            tn.left = null;
            tn.right = null;
            return tn;
        }

        int mid = (start+end)/2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = recur(nums,start,mid-1);
        node.right = recur(nums,mid+1,end);

        return node;
    }
}
