package com.tree;
/*
404. Sum of Left Leaves

Given the root of a binary tree, return the sum of all left leaves.

A leaf is a node with no children. A left leaf is a leaf that is the left child of
another node.



Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
TC : o(n)
SC: o(logn)
 */
public class SumOfLeftLeaves {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(root));
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        int ans =0;
        if(root.left!=null){
            if(root.left.left==null && root.left.right== null){
                ans += root.left.val;
            } else{
                ans += sumOfLeftLeaves(root.left);
            }
        }
        ans += sumOfLeftLeaves(root.right);
        return ans;
    }
}
