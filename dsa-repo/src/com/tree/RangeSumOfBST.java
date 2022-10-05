package com.tree;
/*
938. Range Sum of BST

Given the root node of a binary search tree and two integers low and high,
return the sum of values of all nodes with a value in the inclusive range [low, high].

Example 1:

Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
                10
             5      15
           3   7        18
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

TC : o(n)
SC : o(n)
 */
public class RangeSumOfBST {
    int sum =0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);
        root.left.left.left = new TreeNode(1);
        root.left.right.left = new TreeNode(6);

        System.out.println(new RangeSumOfBST().rangeSumBST(root,6,10));
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null)
            return 0;
        if(root.val>=low && root.val<=high)
            sum+= root.val;

        rangeSumBST(root.left, low,high);
        rangeSumBST(root.right,low,high);

        return sum;
    }
}
